<template>
  <div id="main">
    <div>
      <label for="outlet">Outlet</label>
      <input type="text" name="outlet">
      <button @click = "selectOutlet">Submit</button>
    </div>
  </div>

</template>

<script setup>
import {defineEmits, defineProps} from "vue";

const emits = defineEmits('selectedOutlet');
function selectOutlet() {

}
</script>

<style scoped>
div {

}
#main{
  display: flex;
  align-items: center;
  justify-content: center;
  align-content: center;
  background-color: mediumpurple;
  height: 100%;
  width: 100%;
}
</style>