/** @type {import('tailwindcss').Config} */
export default {
  purge: ['./index.html', './src/**/*.{vue,js,ts,jsx,tsx}'],
  theme: {
    extend: {
      colors: {
        // Custom colors based on the page
        primary: '#52314d',        // Dark purple for text, headings, and main accents
        secondary: '#f0dfd6',      // Light beige background color
        accent: '#e89b87',         // Coral-like accent color
        'button-bg': '#52314d',    // Button background color matching primary
        'button-text': '#f0dfd6',  // Button text color to contrast with button-bg
        'sale-badge': '#e89b87',   // Badge color (e.g., for "20% off" tag)
        'price-original': '#8b6b6b', // Original price color, slightly muted
      },
      fontFamily: {
        sans: ['Helvetica', 'Arial', 'sans-serif'], // General sans-serif font
      },
      spacing: {
        // Custom spacing that may be useful
        '18': '4.5rem',
        '22': '5.5rem',
      },
      fontSize: {
        // Custom font sizes
        'xs': '0.75rem',
        'sm': '0.875rem',
        'base': '1rem',
        'lg': '1.125rem',
        'xl': '1.25rem',
        '2xl': '1.5rem',
        '3xl': '1.875rem',
        '4xl': '2.25rem',
      },
      borderRadius: {
        'lg': '12px', // Larger rounded corners
      },
      boxShadow: {
        'button': '0 4px 6px rgba(0, 0, 0, 0.1)', // Subtle shadow for buttons
      },
    },
  },
  variants: {
    extend: {},
  },
  plugins: [],
}

