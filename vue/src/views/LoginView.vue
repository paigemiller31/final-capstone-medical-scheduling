<template>
  <div id="login">
    <form v-on:submit.prevent="login">
      <p></p>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div> <!-- ^^^ move this later -->
      <h1 id="login-header">LOGIN</h1>
      <div class="form-input-group">
        <input type="text" id="username-input-box" v-model="user.username" required autofocus placeholder=" Username" />
      </div>
      <div class="form-input-group">
        <input type="password" id="password-input-box" v-model="user.password" required placeholder=" Password"/>
      </div>

      <div role="alert" v-if="invalidCredentials">
        Invalid username and password
      </div>
      <p><button id="submit-button" type="submit" v-on:click="login()">Login</button></p>
      <p>
      <router-link class="register-link" v-bind:to="{ name: 'register' }">Register</router-link></p>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
.form-input-group {
  margin-bottom: 1rem;
}
#submit-button {
  font-size: 8pt;
}
.register-link {
  color: #000000;
  text-decoration: none;
}
#login-header {
  font-family:Arial, Helvetica, sans-serif;
  font-weight: 100;
  font-size: 22pt;
}
</style>
