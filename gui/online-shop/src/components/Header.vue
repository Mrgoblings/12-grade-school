<script setup lang="ts">
import '@fortawesome/fontawesome-free/css/all.min.css'
import { ref } from 'vue'

defineProps<{ title: string }>()

const isDark = ref(false)

function toggleTheme() {
    isDark.value = !isDark.value
    if (isDark.value) {
        document.documentElement.classList.add('dark')
    } else {
        document.documentElement.classList.remove('dark')
    }
}

function test() {
    console.log('test')
}
</script>

<template>
    <header class="flex flex-col md:flex-row justify-between items-center p-4 bg-[color:var(--background)] text-[color:var(--foreground)]">
        <h1 class="text-xl text-[color:var(--primary)]">{{ title }}</h1>
        <nav class="order-3 md:order-2 w-full md:w-auto">
            <ul class="flex flex-col md:flex-row gap-4 justify-around w-full">
                <li><a href="/" class="text-[color:var(--primary)]">Home</a></li>
                <li><a href="/products/" class="text-[color:var(--primary)]">Products</a></li>
                <li><a href="/about/" class="text-[color:var(--primary)]">About</a></li>
                <li><a href="/contacts/" class="text-[color:var(--primary)]">Contact</a></li>
            </ul>
        </nav>
        <nav class="order-2 md:order-3">
            <ul class="flex gap-4">
                <li>
                    <button @click="toggleTheme" class="text-[color:var(--primary)]">
                        <i :class="isDark ? 'fas fa-sun' : 'fas fa-moon'"></i>
                    </button>
                </li>
                <li><a @click="test"><i class="fas fa-search text-[color:var(--primary)]"></i></a></li>
                <li><a href="/cart/"><i class="fas fa-shopping-cart text-[color:var(--primary)]"></i></a></li>
            </ul>
        </nav>
    </header>
</template>