<script setup>
  import { defineProps, defineEmits } from 'vue';

  const props = defineProps({
    additionalClasses: {
      type: String,
      default: ''
    }
  });
</script>

<template>
    <div :class="['moving-bar', additionalClasses]">
        <span class="moving-content">
            <slot></slot>
        </span>
        <span class="moving-content">
            <slot></slot>
        </span>
    </div>
</template>

<style scoped>
.moving-bar {
  text-align: center;
  font-weight: 500;
  text-transform: uppercase;
  padding-top: 0.35rem;
  padding-bottom: 0.35rem;
  white-space: nowrap;
  overflow: hidden;
}

.moving-content {
  display: inline-block;
  width: 100%;
  padding-right: 0.35rem;
  animation: scrollText 15s linear infinite;
}

.moving-bar:hover .moving-content {
  animation-play-state: paused;
}

@keyframes scrollText {
  0% {
    transform: translateX(0);
  }
  100% {
    transform: translateX(-100%);
  }
}
</style>