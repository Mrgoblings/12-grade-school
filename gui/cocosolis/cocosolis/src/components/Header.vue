<script setup lang="ts">
import MovingBar from "./MovingBar.vue";
import HeaderContainer from "./HeaderContainer.vue";
// import HeaderBottom from "./HeaderBottom.vue";

import { ref, onMounted, onUnmounted } from "vue";

const isScrolled = ref(false);

const handleScroll = () => {
  isScrolled.value = window.scrollY > 0;
};

onMounted(() => {
  window.addEventListener("scroll", handleScroll);
  console.log("Header mounted");
});

onUnmounted(() => {
  window.removeEventListener("scroll", handleScroll);
  console.log("Header UNmounted");
});
</script>

<template>
  <header class="fixed w-full z-50">
    <!-- <HeaderTop> -->
    <MovingBar
      additionalClasses="bg-primary-background text-primary-foreground text-base"
    >
      Пакетите за Black Friday са тук 🤍 Пазарувай с до 30% отстъпка
    </MovingBar>

    <HeaderContainer />

    <!-- <HeaderBottom :active="isScrolled" /> -->
  </header>
</template>

<style>
header.scrolled {
  height: 1.6rem;
}
</style>
