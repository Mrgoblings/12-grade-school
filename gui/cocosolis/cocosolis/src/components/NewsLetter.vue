<template>
  <div class="flex flex-wrap bg-trinary-accent">
    <!-- Left Side with Benefits List -->
    <div class="flex-1 text-secondary-background space-y-6 p-8">
      <div class="flex items-start space-x-3">
        <img
          src="https://cocosolis.com/wp-content/uploads/icon-leaf-regular-white.svg"
          alt="Leaf Icon"
          class="p-3 w-9 bg-secondary-accent rounded-full"
        />
        <div>
          <h3 class="text-lg font-semibold">Натурални и Био</h3>
          <p>
            Продуктите на COCOSOLIS са винаги натурални и създадени само с
            най-висококачествени био, студено пресовани масла.
          </p>
        </div>
      </div>
      <div class="flex items-start space-x-3">
        <img
          src="https://cocosolis.com/wp-content/uploads/icon-heart-solid-white.svg"
          alt="Heart Icon"
          class="p-3 w-9 bg-secondary-accent rounded-full"
        />
        <div>
          <h3 class="text-lg font-semibold">Създадени с любов</h3>
          <p>
            Създадени с любов и уважение към хората и природата. Нежни към
            кожата. Притежаващи аромат, в който ще се влюбите.
          </p>
        </div>
      </div>
      <div class="flex items-start space-x-3">
        <img
          src="https://cocosolis.com/wp-content/uploads/icon-paw-solid-white.svg"
          alt="Paw Icon"
          class="p-3 w-9 bg-secondary-accent rounded-full"
        />
        <div>
          <h3 class="text-lg font-semibold">С отношение</h3>
          <p>
            Без наличие на парабени, оцветители, минерални и синтетични масла и
            разбира се, без тестване върху животни.
          </p>
        </div>
      </div>
    </div>

    <!-- Right Side with Image (hidden on small screens) -->
    <div
      class="flex-1 hidden md:flex justify-center items-center bg-cover bg-center"
      style="
        background-image: url('https://cocosolis.com/wp-content/uploads/home-benefits-image.jpg');
      "
    ></div>

    <!-- Bottom Section with Newsletter Signup -->
    <div
      class="w-full bg-secondary-background p-8 text-primary-foreground leading-3"
    >
      <p>
        Нека бъдем приятели! Абонирайте се, за да бъдете сред първите, които ще
        научат за нашите нови продукти и промоции:
      </p>
      <input
        type="email"
        placeholder="твоят имейл адрес"
        v-model="email"
        class="w-full p-2 mt-2 rounded border-none text-black"
      />
      <p class="text-quaternary-foreground text-xs mt-2">
        Моля, поставете отметка в квадратчето по-долу, за да се присъедините.
      </p>
      <label class="text-quaternary-foreground text-xs block mt-2">
        <input type="checkbox" v-model="consent" class="mr-2" />
        Съгласен/а съм предоставеният от мен имейл да бъде използван, за да
        получавам известия за новости, подаръци и бъдещи промоции, свързани с
        продуктите COCOSOLIS, съгласно
        <a href="#" class="underline">Общите условия за ползване на сайта</a> и
        <a href="#" class="underline">Политика за личните данни</a>.
      </label>
      <button
        :disabled="!consent || !email"
        @click="joinClub"
        class="mt-4 px-6 py-2 w-full font-base text-sm bg-secondary-accent text-primary-foreground disabled:cursor-not-allowed disabled:opacity-50"
      >
        ВЛЕЗ В КЛУБА
      </button>
    </div>
  </div>
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
