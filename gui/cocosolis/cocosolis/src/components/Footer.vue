<template>
  <!-- Top Bar for Partnership Info -->
  <div
    class="bg-[#2aace2] text-white flex flex-col sm:flex-row text-center justify-center py-2 text-base font-normal px-12"
  >
    <div class="flex flex-row justify-center items-center pr-20">
      <img
        src="https://cocosolis.com/wp-content/uploads/SOS_logo-BG.svg"
        alt="SOS Logo"
        class="w-28 border-r-2 border-white pr-4"
      />
      <img
        src="https://cocosolis.com/wp-content/uploads/cocosolis-sos-gold-partners-2023.svg"
        alt="Gold Partner Logo"
        class="w-28"
      />
    </div>
    <div class="">
      COCOSOLIS дарява по 1лв. от всяко закупен продукт на SOS детски селища.
    </div>
  </div>

  <footer
    class="flex flex-col bg-secondary-background text-white text-xs px-12 leading-3"
  >
    <!-- Payment Methods -->
    <div
      class="text-xl font-semibold text-center py-4 border-b mb-4 mt-12 px-18"
    >
      <p>Гарантирано сигурно плащане с:</p>
      <div class="flex justify-center space-x-1 mt-8">
        <img
          src="https://cocosolis.com//wp-content/uploads/icon-payments-visa.svg"
          alt="Visa"
          class="h-14"
        />
        <img
          src="https://cocosolis.com//wp-content/uploads/icon-payments-mastercard.svg"
          alt="Mastercard"
          class="h-14"
        />
        <img
          src="https://cocosolis.com//wp-content/uploads/icon-payments-discover.svg"
          alt="Discover"
          class="h-14"
        />
        <img
          src="https://cocosolis.com//wp-content/uploads/icon-payments-paypal.svg"
          alt="Paypal"
          class="h-14"
        />
        <img
          src="https://cocosolis.com//wp-content/uploads/icon-payments-amex.svg"
          alt="Amex"
          class="h-14"
        />
        <img
          src="https://cocosolis.com//wp-content/uploads/icon-payments-gpay.svg"
          alt="Google Pay"
          class="h-14"
        />
        <img
          src="https://cocosolis.com//wp-content/uploads/icon-payments-apple-pay.svg"
          alt="Apple Pay"
          class="h-14"
        />
      </div>
    </div>

    <!-- Main Footer Content -->
    <div
      class="flex flex-wrap md:flex-nowrap justify-between py-6 px-12 space-x-12 border-b"
    >
      <!-- Useful Links Section -->
      <div class="flex-1 mb-6 md:mb-0">
        <h3 class="font-semibold mb-4">Полезни връзки</h3>
        <ul class="space-y-2">
          <li><a href="#" class="hover:underline">Продукти</a></li>
          <li><a href="#" class="hover:underline">CLUB</a></li>
          <li><a href="#" class="hover:underline">Контакти</a></li>
          <li><a href="#" class="hover:underline">За нас</a></li>
          <li><a href="#" class="hover:underline">Правила за закупуване</a></li>
          <li>
            <a href="#" class="hover:underline">Условия за ползване на сайта</a>
          </li>
          <li>
            <a href="#" class="hover:underline"
              >Условия на Програма за лоялност</a
            >
          </li>
          <li><a href="#" class="hover:underline">Политика за бисквитки</a></li>
          <li><a href="#" class="hover:underline">Политика за връщане</a></li>
          <li><a href="#" class="hover:underline">Поръчка и доставка</a></li>
          <li>
            <a href="#" class="hover:underline"
              >Политика за защита на лични данни</a
            >
          </li>
        </ul>
      </div>

      <!-- Newsletter Subscription Section -->
      <div class="flex-1 mb-6 md:mb-0">
        <h3 class="font-semibold mb-4">НЕКА БЪДЕМ ПРИЯТЕЛИ!</h3>
        <p class="mb-4">
          Абонирайте се, за да бъдете сред първите, които ще научат за нашите
          нови продукти и промоции:
        </p>
        <input
          type="email"
          placeholder="твоята имейл адрес"
          v-model="email"
          class="w-full p-2 rounded text-black mb-2"
        />
        <label class="text-xs text-[#dcc9be] block mb-4">
          <input type="checkbox" v-model="consent" class="mr-2" />
          Съгласен/а съм предоставеният от мен имейл да бъде използван, за да
          получавам известия за новости, подаръци и бъдещи промоции, свързани с
          продуктите COCOSOLIS, съгласно
          <a href="#" class="underline">Общите условия за ползване на сайта</a>
          и <a href="#" class="underline">Политика за личните данни</a>.
        </label>
        <button
          :disabled="!consent || !email"
          @click="joinClub"
          class="mt-4 px-6 py-2 w-full font-base text-sm bg-secondary-accent text-primary-foreground disabled:cursor-not-allowed disabled:opacity-50"
        >
          ВЛЕЗ В КЛУБА
        </button>
      </div>

      <!-- Follow Us Section -->
      <div class="flex-1 mb-6 md:mb-0 text-center md:text-left">
        <h3 class="font-semibold mb-4">Последвайте ни</h3>
        <div class="flex space-x-4 justify-center md:justify-start">
          <a href="#"><i class="fab fa-facebook-f text-2xl"></i></a>
          <a href="#"><i class="fab fa-instagram text-2xl"></i></a>
          <a href="#"><i class="fab fa-tiktok text-2xl"></i></a>
        </div>
        <p class="mt-4 text-xs">
          Тагни ни и има шанс да видиш своята снимка или видео в профила ни!
          #cocosolis
        </p>
      </div>
    </div>

    <div class="justify-center text-lg text-primary-foreground py-7 mx-auto">
      &copy; 2016 - 2024 COCOSOLIS | All rights reserved
    </div>
  </footer>
</template>

<script>
export default {
  data() {
    return {
      email: "",
      consent: false,
    };
  },
  methods: {
    joinClub() {
      if (this.consent && this.email) {
        alert("Thank you for joining!");
        // Add functionality to submit the form data here
      }
    },
  },
};
</script>

<style scoped></style>
