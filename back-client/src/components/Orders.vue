<template>
  <div>
    <div>{{orderId}}</div>
    <div>
      <ul>
        <li v-for="item in items" :key = item>{{item}}</li>
      </ul>
    </div>
    <div v-if="!completed">
      <button @click="completeOrder">Complete Order!</button>
    </div>
  </div>
</template>

<script setup>
import {ref} from "vue";
import Axios from "axios"

const orderId = ref("");
const completed = ref(false);
const items = ref([]);

function completeOrder(){
  Axios.post("http://localhost:8080/orders/complete", {'orderId': orderId});
}
</script>

<style scoped>

</style>