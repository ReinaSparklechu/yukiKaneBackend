<template>
  <div id="main">
    <MainPane v-if="selected"></MainPane>
    <SelectOutlet v-else :select="outlet"></SelectOutlet>
  </div>
</template>

<script setup>
import MainPane from "@/components/MainPane"
import SelectOutlet from "@/components/SelectOutlet";
import {ref} from "vue";

const selected = ref(false);
const outlet = ref("");

</script>

<style>
#main{
  display: flex;
  height: 100vh;
  width: 100vw;
  margin: 0;
}

</style>
