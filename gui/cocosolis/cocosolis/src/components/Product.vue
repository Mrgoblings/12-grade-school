<script setup>
    import { defineProps } from 'vue';

    const props = defineProps({
        image: {
            type: String,
            default: ''
        },
        discount: {
            type: String,
            default: ''
        },
        title: {
            type: String,
            default: ''
        },
        description: {
            type: String,
            default: ''
        },
        newPrice: {
            type: String,
            default: ''
        },
        oldPrice: {
            type: String,
            default: ''
        },
        infoText: {
            type: String,
            default: ''
        }
    });
</script>

<template>
    <div class="relative w-64 p-4 bg-gray-100 rounded-lg shadow-lg text-center">
        <!-- Discount Badge -->
        <div v-if="discount" class="absolute top-2 left-2 bg-brown-600 text-white text-sm font-bold py-1 px-2 rounded">
            {{ discount }}
        </div>

        <!-- Product Image -->
        <img :src="image" alt="Product Image" class="w-full rounded-md mb-4" />

        <!-- Product Title -->
        <h2 class="text-lg font-semibold text-gray-700">{{ title }}</h2>

        <!-- Product Description -->
        <p class="text-sm text-gray-500 mt-2 mb-4">{{ description }}</p>

        <!-- Prices -->
        <div class="flex justify-center items-baseline space-x-2 mb-2">
            <span class="text-xl font-bold text-gray-700">{{ newPrice }} лв.</span>
            <span v-if="oldPrice" class="text-lg text-gray-400 line-through">{{ oldPrice }} лв.</span>
        </div>

        <!-- Info Note -->
        <div class="flex items-center justify-center text-xs text-gray-500 mb-4">
            <span class="font-bold text-gray-400 mr-1">i</span> {{ infoText }}
        </div>

        <!-- Add Button (Fixed Text: "Добави") -->
        <button class="w-full py-2 bg-gray-700 text-white rounded hover:bg-gray-800">
            Добави
        </button>
    </div>  
</template>

<!-- Tailwind CSS Custom Style -->
<style scoped>
.bg-brown-600 {
    background-color: #6f4e37;
}

</style>
