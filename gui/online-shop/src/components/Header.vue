<script setup lang="ts">
    import '@fortawesome/fontawesome-free/css/all.min.css'
    defineProps<{ title: string }>()

    function test() {
        console.log('test')
    }
</script>

<template>
    <header class="header">
        <h1>{{ title }}</h1>
        <nav class="nav-links">
            <ul>
                <li><a href="/">Home</a></li>
                <li><a href="/products/">Products</a></li>
                <li><a href="/about/">About</a></li>
                <li><a href="/contacts/">Contact</a></li>
            </ul>
            
        </nav>
        <nav class="nav-icons">
            <ul>
                <li><a @click="test"><i class="fas fa-search"></i></a></li>
                <li><a href="/cart/"><i class="fas fa-shopping-cart"></i></a></li>
            </ul>
        </nav>
    </header>
</template>

<style scoped>
.header {
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 1rem 3rem;
    background-color: #f8f9fa;
}

.header h1 {
    margin: 0;
    color: #007bff;
    font-size: 1.5rem;
}

.header nav {
    display: flex;
    gap: 1rem;
    justify-content: space-between;
}

.header nav ul {
    list-style: none;
    display: flex;
    gap: 1rem;
    padding: 0;
    margin: 0;
}

.header nav ul li a {
    text-decoration: none;
    color: #007bff;
}
</style>