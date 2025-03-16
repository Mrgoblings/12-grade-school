<script setup lang="ts">
import Header from "./components/Header.vue";
import BlackFriday from "./components/BlackFriday.vue";
import ProductSection from "./components/ProductSection.vue";
import Newsletter from "./components/Newsletter.vue";
import Footer from "./components/Footer.vue";
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
  <MovingBar>
    <div
      class="flex flex-row bg-secondary-background space-x-6 py-3 overflow-hidden text-nowrap"
    >
      <div class="uppercase text-primary-foreground font-medium">
        МЕДИИТЕ ГОВОРЯТ ЗА НАС
      </div>
      <div>
        <img
          src="https://cocosolis.com/bg/wp-content/uploads/cosmopolitan.svg"
        />
      </div>
      <div>
        <img src="https://cocosolis.com/bg/wp-content/uploads/vogue.svg" />
      </div>
      <div>
        <img src="https://cocosolis.com/bg/wp-content/uploads/elle.svg" />
      </div>
      <div>
        <img
          src="https://cocosolis.com/bg/wp-content/uploads/marie-claire.svg"
        />
      </div>
      <div>
        <img src="https://cocosolis.com/bg/wp-content/uploads/instyle.svg" />
      </div>
      <div>
        <img src="https://cocosolis.com/bg/wp-content/uploads/grazia.svg" />
      </div>
      <div>
        <img src="https://cocosolis.com/bg/wp-content/uploads/forbes.svg" />
      </div>
      <div>
        <img src="https://cocosolis.com/bg/wp-content/uploads/vanityfair.svg" />
      </div>
    </div>
  </MovingBar>
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
  <Newsletter />
  <Footer />
</template>

<style></style>
