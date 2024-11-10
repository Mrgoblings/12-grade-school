<script setup lang="ts">
import Header from './components/Header.vue'
import BlackFriday from './components/BlackFriday.vue'
import ProductSection from './components/ProductSection.vue'
import HomeBenefits from './components/HomeBenefits.vue'
import Newsletter from './components/Newsletter.vue'
import Footer from './components/Footer.vue'
</script>

<template>
  <Header />
  <BlackFriday />
  <ProductSection title="Промо Пакети" type="dark"/>
  <ProductSection title="Коса" type="light"/>
  <ProductSection title="Кожа" type="light"/>
  <ProductSection title="Лице" type="dark"/>
  <ProductSection title="АВТОБРОНЗАНТИ" type="light"/>
  <ProductSection title="Тен" type="dark"/>
  <ProductSection title="Бясък" type="light"/>
  <ProductSection title="SPF" type="dark"/>
  <HomeBenefits />
  <Newsletter />
  <Footer />
  
</template>

<style>

</style>
