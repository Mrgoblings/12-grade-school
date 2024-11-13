<script setup>
import Product from "./Product.vue";

import { defineProps } from "vue";

const props = defineProps({
  title: {
    type: String,
    default: "",
  },
  description: {
    type: String,
    default: "",
  },
  type: {
    type: String,
    default: "",
    validator: (value) => ["light", "dark"].includes(value),
  },
});
</script>

<template>
  <section class="bg-trinary-foreground flex flex-col justify-center py-16">
    <div class="flex flex-col justify-center text-center">
      <h1>{{ title }}</h1>
      <h2 v-if="description">{{ description }}</h2>
    </div>
    <div class="flex space-x-2 w-full justify-center">
      <Product
        image="https://cocosolis.com/wp-content/uploads/bf24__dream-hair.jpg"
        discount="-15%"
        category="BRONZE TAN"
        type=" Hair Growth Serum Spray"
        nStars="4"
        nReviews="1297"
        description="Естествено изглеждащ бронзов тен, когато пожелаете"
        newPrice="66,30"
        oldPrice="78,00"
        infoText="Най-ниска цена за последните 30 дни: 78,00 лв."
      />

      <Product
        image="https://cocosolis.com/wp-content/uploads/bf24__dream-hair.jpg"
        discount="-15%"
        title="BRONZE TAN"
        description="Естествено изглеждащ бронзов тен, когато пожелаете"
        newPrice="66,30"
        oldPrice="78,00"
        infoText="Най-ниска цена за последните 30 дни: 78,00 лв."
      />
    </div>
  </section>
</template>

<style scoped>
h1 {
  font-size: 2rem;
  font-weight: 300;
  text-transform: uppercase;
  margin-bottom: 1rem;
  letter-spacing: 0em;
}
</style>
