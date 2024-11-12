<script setup>
    import Product from "./Product.vue"

    import { defineProps } from 'vue';

    const props = defineProps({
        title: {
            type: String,
            default: ''
        },
        description: {
            type: String,
            default: ''
        },
        type: {
            type: String,
            default: '',
            validator: value => ['light', 'dark'].includes(value)
        },
    });
</script>

<template>
    <div class="bg-trinary-foreground flex">
        <Product image="https://cocosolis.com/wp-content/uploads/bf24__dream-hair.jpg" discount="-15%"
            title="BRONZE TAN" description="Естествено изглеждащ бронзов тен, когато пожелаете" newPrice="66,30"
            oldPrice="78,00" infoText="Най-ниска цена за последните 30 дни: 78,00 лв." />

        <Product image="https://cocosolis.com/wp-content/uploads/bf24__dream-hair.jpg" discount="-15%"
            title="BRONZE TAN" description="Естествено изглеждащ бронзов тен, когато пожелаете" newPrice="66,30"
            oldPrice="78,00" infoText="Най-ниска цена за последните 30 дни: 78,00 лв." />
    </div>
</template>

<style>
</style>