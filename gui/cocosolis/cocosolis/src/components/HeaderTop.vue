<script>
</script>

<template>
    <div id="container-top" class="bg-primary-background text-primary-foreground">
        <p>Пакетите за Black Friday са тук 🤍 Пазарувай с до 30% отстъпка</p>
        <p>Пакетите за Black Friday са тук 🤍 Пазарувай с до 30% отстъпка</p>
    </div>
</template>

<style scoped>
#container-top {
    /* width: 100%; */
    text-align: center;
    font-size: 15px;
    font-weight: 500;
    text-transform: uppercase;
    max-height: 32px;
    padding-top: 0.35rem;
    padding-bottom: 0.35rem;

    white-space: nowrap;
    overflow: hidden;
}

#container-top p {
    display: inline-block;
    /* TODO: chech */
    width: 100%;
    padding-right: 0.35rem;
    animation: scrollText 15s linear infinite;
}

#container-top:hover p {
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