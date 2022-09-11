<template>
  <div></div>
</template>

<script>
import axios from 'axios';
axios.defaults.withCredentials = true;
export default {
  name: "LoginPage",
  data() {
    return {
      token: null,
      outlet: undefined,
      addr: "",
    };
  },
  methods: {
    async getOutlet() {
      this.outlet = await axios.get("http://localhost:8080/outlet/" + this.addr,)
    }
  },

  async mounted() {
    var bodyFormData = new FormData();
    bodyFormData.append("password","password1234");
    bodyFormData.append("username","James");
    let token = localStorage.getItem('yuki-outlet-jwt');
    if (token == null) {
      // eslint-disable-next-line no-unused-vars
      const login =await axios.get('http://localhost:9000/oauth2/authorize?response_type=code&client_id=yuki-client&redirect_uri=http://127.0.0.1:9090/login/oauth2/code/yuki-client&scope=writeStuff+deleteStuff')
          .then(res => {
            console.log(res);
            axios({
              method: 'post',
              url: res.request.responseURL,
              data:bodyFormData,
            });}).then(window.open("http://localhost:9000/oauth2/authorize?response_type=code&client_id=yuki-client&redirect_uri=http://127.0.0.1:9090/login/oauth2/code/yuki-client&scope=writeStuff+deleteStuff"))

    }
  }
}

</script>

<style scoped>

</style>