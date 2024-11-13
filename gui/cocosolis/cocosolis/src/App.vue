<script setup lang="ts">
import Header from "./components/Header.vue";
import BlackFriday from "./components/BlackFriday.vue";
import ProductSection from "./components/ProductSection.vue";
import HomeBenefits from "./components/HomeBenefits.vue";
import Newsletter from "./components/Newsletter.vue";
import Footer from "./components/Footer.vue";
import Product from "./components/Product.vue";
</script>

<template>
  <Header />
  <BlackFriday />
  <ProductSection title="Промо Пакети" type="dark" />
  <ProductSection
    title="Коса"
    description="Натурални продукти за силна, гъста и бляскава коса"
    type="light"
  />
  <ProductSection
    title="Кожа"
    description="Серията SKIN за перфектна кожа, без несъвършенства."
    type="light"
  />
  <ProductSection
    title="Лице"
    description="Високоефективни натурални продукти за подмладена и сияйна кожа"
    type="dark"
  />
  <ProductSection
    title="АВТОБРОНЗАНТИ"
    description="За перфектен тен, без да е необходимо слънце. Постигнете естествено изглеждащ, равномерен, наситен, бронзов тен."
    type="light"
  />
  <ProductSection
    title="Тен"
    description="Натурални, био масла за супер тен и сияйна кожа"
    type="dark"
  />
  <ProductSection
    title="Бясък"
    description="Натурални продукти за елегантен блясък и грижа за кожата"
    type="light"
  />
  <ProductSection
    title="SPF"
    description="Натурални, био слънцезащитни лосиони"
    type="dark"
  />
  <HomeBenefits />
  <Newsletter />
  <Footer />
</template>

<style></style>
