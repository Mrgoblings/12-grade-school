<script>

import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
</script>

<template>
    <nav id="header-container" class="bg-primary-foreground text-primary-foreground">
        <div id="logo">
            <img src="https://cocosolis.com/wp-content/uploads/cocosolis-logo.svg" alt="COCOSOLIS" />
        </div>

        <ul id="menu-cart" class="text-secondary-background">
            <li><a href="#">Начало</a></li>
            <li><a href="#">Продукти</a></li>
            <li><a href="#">Club</a></li>
            <li><a href="#">За Нас</a></li>
            <li><a href="#">Контакти</a></li>
            <li>
                <font-awesome-icon :icon="['fas', 'bars']" />
            </li>
        </ul>
    </nav>
</template>

<style scoped>
#header-container {
    width: 100%;
    text-align: center;
    display: flex;
    justify-content: center;
    gap: 2rem;
    /* make contents diplay in a row */
    align-items: center;

    border-bottom: 1px solid rgb(0 0 0 / 8%);
}

#header-container #logo {
    width: 204px;
    padding: 1rem 0;
}

#header-container #menu-cart {
    display: flex;
    justify-content: center;
    padding: 0.5rem 0;
}

#header-container #menu-cart li {
    margin: 0 1rem;
    text-transform: uppercase;
}
</style>