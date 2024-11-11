<script>

import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
</script>

<template>
    <nav id="header-container" class="bg-primary-foreground text-primary-foreground">
        <div id="logo">
            <img src="https://cocosolis.com/wp-content/uploads/cocosolis-logo.svg" alt="COCOSOLIS" />
        </div>

        <ul id="menu-cart" class="text-secondary-background">
            <li><a href="#" class="hover:text-secondary-accent">Начало</a></li>
            <li><a href="#" class="hover:text-secondary-accent">Продукти</a></li>
            <li><a href="#" class="hover:text-secondary-accent">Club</a></li>
            <li><a href="#" class="hover:text-secondary-accent">За Нас</a></li>
            <li><a href="#" class="hover:text-secondary-accent">Контакти</a></li>
            <li class="text-xl">
                <font-awesome-icon :icon="['fas', 'bars']" />
            </li>

            <li class="text-xl pl-3">
                <font-awesome-icon :icon="['fas', 'magnifying-glass']" />
            </li>
            <li class="text-xl">
                <font-awesome-icon :icon="['fas', 'cart-shopping']" />
                <div id="circle-notification" class="bg-secondary-accent w-5 h-5 rounded-xl text-primary-foreground">0</div>
            </li>
            <li class="text-xl">
                <a href="#" class="hover:text-secondary-accent">
                    <font-awesome-icon :icon="['fas', 'user']" />
                    Влез в профил
                </a>   
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
    text-align: center;
    padding: 0.5rem 0;
    font-size: 1rem;
    font-weight: 300;
}

#header-container #menu-cart li {
    margin: 0 1rem;
    text-transform: uppercase;
}

#circle-notification {
    position: relative;
    top: -35px;
    right: -15px;
    font-size: 0.8rem;
    line-height: 1rem;
    display: flex;
    justify-content: center;
    align-items: center;

    font-weight: 300;
    font-size: 11px;
}

</style>