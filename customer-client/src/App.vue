<template>
  <img alt="Vue logo" src="./assets/logo.png">
  <login-page/>
</template>

<script>
import loginPage from "@/components/LoginPage";

export default {
  name: 'App',
  components: {
    loginPage
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
