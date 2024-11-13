<script setup>
import { defineProps } from "vue";

const props = defineProps({
  image: {
    type: String,
    default: "",
  },
  discount: {
    type: String,
    default: "",
  },
  category: {
    type: String,
    default: "",
  },
  type: {
    type: String,
    default: "",
  },
  nStars: {
    type: [String, Number],
    default: 5,
    validator: (value) => {
      const numberValue = parseInt(value, 10);
      return !isNaN(numberValue) && numberValue >= 0 && numberValue <= 5;
    },
  },
  nReviews: {
    type: [String, Number],
    default: 0,
    validator: (value) => {
      const numberValue = parseInt(value, 10);
      return !isNaN(numberValue) && numberValue >= 0;
    },
  },
  description: {
    type: String,
    default: "",
  },
  newPrice: {
    type: String,
    default: "",
  },
  oldPrice: {
    type: String,
    default: "",
  },
  infoText: {
    type: String,
    default: "",
  },
});

// console.log(nStars);
</script>

<template>
  <div class="relative w-64 p-4 text-center">
    <!-- Discount Badge -->
    <div
      v-if="discount"
      class="absolute top-2 left-2 bg-primary-background text-white text-sm font-bold py-1 px-2 rounded"
    >
      {{ discount }}
    </div>

    <!-- Product Image -->
    <img :src="image" alt="Product Image" class="w-full rounded-md mb-4" />

    <!-- Listing Category -->
    <h2 class="text-2xl uppercase font-normal text-secondary-background">
      {{ category }}
    </h2>

    <!-- Listing Type -->
    <h3 class="text-xl font-normal text-secondary-background">{{ type }}</h3>

    <!-- Rating Stars -->
    <div class="flex justify-center space-x-1">
      <span>
        <span v-for="i in nStars" :key="'filled-star-' + i">
          <font-awesome-icon
            :icon="['fas', 'star']"
            class="text-trinary-background text-sm"
          />
        </span>
        <span v-for="i in 5 - nStars" :key="'empty-star-' + (i + nStars)">
          <font-awesome-icon
            :icon="['far', 'star']"
            class="text-trinary-background text-sm"
          />
        </span>
      </span>
      <span class="text-xs flex items-center text-secondary-background"
        >{{ nReviews }} мнения</span
      >
    </div>

    <!-- Product Description -->
    <p class="text-sm font-medium text-secondary-background">
      {{ description }}
    </p>

    <!-- Prices -->
    <div class="flex justify-center items-baseline space-x-2">
      <span class="text-xl font-bold text-secondary-background"
        >{{ newPrice }} лв.</span
      >
      <span
        v-if="oldPrice"
        class="text-lg text-secondary-background line-through"
        >{{ oldPrice }} лв.</span
      >
    </div>

    <!-- Info Note -->
    <div
      v-if="infoText"
      class="flex items-center justify-center text-xs text-secondary-background mb-4"
    >
      {{ infoText }}
    </div>

    <!-- Add Button (Fixed Text: "Добави") -->
    <button
      class="w-full py-2 bg-secondary-background text-white rounded hover:bg-secondary-accent"
    >
      Добави
    </button>
  </div>
</template>

<!-- Tailwind CSS Custom Style -->
<style scoped></style>
