const Jimp = require('jimp');
const fs = require('fs');
const { ChartJSNodeCanvas } = require('chartjs-node-canvas');

// Load and convert the image to grayscale
async function loadImage(filepath) {
    try {
        const image = await Jimp.read(filepath);
        image.grayscale(); // Convert to grayscale

        return image;
    } catch (error) {
        console.error(`Error loading image: ${error.message}`);
        return null;
    }
}

// Calculating the histogram for each intensity level
function calculateHistogram(image) {
    const histogram = new Array(256).fill(0);

    image.scan(0, 0, image.bitmap.width, image.bitmap.height, (x, y, idx) => {
        const intensity = image.bitmap.data[idx]; // Grayscale intensity
        histogram[intensity]++;
    });

    return histogram;
}

// Calculating the Hmid threshold based on the histogram
function calculateHmid(histogram, numPixels) {
    return histogram.reduce((acc, val) => acc + val, 0) / 256;
}

// Computing R(C) and Cn(C)
function histogramEqualizationAlgorithm(histogram, numPixels, method = 1) {
    const hmid = calculateHmid(histogram, numPixels);
    let hsum = 0;
    let rver = 0;
    const l = new Array(256).fill(0);
    const r = new Array(256).fill(0);
    const cn = new Array(256).fill(0);

    for (let c = 0; c < 256; c++) {
        l[c] = rver;
        hsum += histogram[c];

        while (hsum > hmid) {
            hsum -= hmid;
            rver++;
        }

        r[c] = rver;

        // Apply method for Cn(C)
        if (method === 1) {
            cn[c] = Math.floor((l[c] + r[c]) / 2);
        } else if (method === 2) {
            cn[c] = l[c] + Math.floor(Math.random() * (r[c] - l[c] + 1));
        } else {
            throw new Error("Invalid method. Choose method 1 or 2.");
        }
    }

    return cn;
}

// Apply Cn mapping to the original image to get the equalized image
function applyEqualization(image, cn) {
    const equalizedImage = image.clone();

    equalizedImage.scan(0, 0, image.bitmap.width, image.bitmap.height, (x, y, idx) => {
        const intensity = image.bitmap.data[idx];
        equalizedImage.bitmap.data[idx] = cn[intensity];
    });

    return equalizedImage;
}

// Histogram equalization
async function histogramEqualization(filepath, method = 1) {
    const image = await loadImage(filepath);

    if (!image) return { original: null, equalized: null };

    const numPixels = image.bitmap.width * image.bitmap.height;
    const histogram = calculateHistogram(image);
    const cn = histogramEqualizationAlgorithm(histogram, numPixels, method);
    const equalizedImage = applyEqualization(image, cn);

    return { original: image, equalized: equalizedImage };
}

// Display images and histograms (In Node.js, for saving histogram charts to files)
async function displayImagesAndHistograms(original, equalized) {
    if (!original || !equalized) {
        console.log("No image to display due to loading error.");
        return;
    }

    const originalHistogram = calculateHistogram(original);
    const equalizedHistogram = calculateHistogram(equalized);

    const width = 800;
    const height = 600;
    const chartJSNodeCanvas = new ChartJSNodeCanvas({ width, height });

    const createHistogramChart = async (data, title) => {
        const configuration = {
            type: 'line',
            data: {
                labels: Array.from({ length: 256 }, (_, i) => i),
                datasets: [{
                    label: title,
                    data: data,
                    borderColor: 'black',
                    borderWidth: 1,
                    fill: false
                }]
            },
            options: {
                responsive: false,
                scales: {
                    x: { type: 'linear', min: 0, max: 255 },
                    y: { beginAtZero: true }
                }
            }
        };

        return await chartJSNodeCanvas.renderToBuffer(configuration);
    };

    // Save original and equalized histograms as images
    const originalHistogramBuffer = await createHistogramChart(originalHistogram, 'Original Histogram');
    fs.writeFileSync('original_histogram.png', originalHistogramBuffer);

    const equalizedHistogramBuffer = await createHistogramChart(equalizedHistogram, 'Equalized Histogram');
    fs.writeFileSync('equalized_histogram.png', equalizedHistogramBuffer);

    // Save original and equalized images
    await original.writeAsync('original_image.png');
    await equalized.writeAsync('equalized_image.png');
    console.log("Images and histograms have been saved.");
}

// Test run
const filepath = 'image.jpg';
histogramEqualization(filepath, 1)
    .then(({ original, equalized }) => displayImagesAndHistograms(original, equalized))
    .catch(error => console.error(error));

