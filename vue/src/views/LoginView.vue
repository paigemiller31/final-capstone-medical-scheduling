<template>
  <div id="login">
    <form v-on:submit.prevent="login">
      <p></p>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div> <!-- ^^^ move this later -->
      <h1 id="login-header">LOGIN</h1>
      <div class="form-input-group">
        <input type="text" class="login-input-box" v-model="user.username" required autofocus placeholder=" Username" />
      </div>
      <div class="form-input-group">
        <input type="password" class="login-input-box" v-model="user.password" required placeholder=" Password"/>
      </div>

      <div role="alert" v-if="invalidCredentials">
        Invalid username and password
      </div>
      <p class="button-alignment"><button id="submit-button" type="submit" v-on:click="login()">Submit</button></p>
      <p class="button-alignment">Not registered yet?</p>
      <p class="button-alignment"><button id="submit-button" type="submit" v-on:click="register()">Create an Account</button></p>
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
    },
    register() {
      this.$router.push("/register");
    }
  }
};
</script>

<style scoped>
.form-input-group {
  margin-bottom: 2rem;
}
#login-header {
  margin-bottom: 2rem;
  display: flex;
  justify-content: center;
  align-items: center;
  font-family: Arial, Helvetica, sans-serif;
  font-weight: 100;
  font-size: 22pt;
}
#login {
  height: 80vh;
  display: flex;
  justify-content: center;
  align-items: center;
}
input::placeholder {
  font-family: Arial, Helvetica, sans-serif;  
  font-size: 7pt;
  color: rgb(210, 210, 210);  
  }
.register-link {
  display: flex;
  justify-content: center;
  align-items: center;
  font-family: Arial, Helvetica, sans-serif;
  font-size: 8pt;
  text-transform: uppercase;
  letter-spacing: 3pt;
  background-color: transparent;
  border-style: none;
  border-bottom: solid 1px #000000;
  padding: .1rem;
  color: #000000;
  text-decoration: none;
  max-width: 200px;

}
#submit-button {
  font-family: Arial, Helvetica, sans-serif;
  font-size: 8pt;
  text-transform: uppercase;
  letter-spacing: 3pt;
  background-color: transparent;
  border-style: none;
  border-bottom: solid 1px #000000;
  padding: .1rem;
}
.button-alignment {
  display: flex;
  justify-content: center;
  align-items: center;
}
.login-input-box {
  width: 250px;
  padding: 7px;
  border-style: none;
  border-radius: 3px;
  outline: none;
}

</style>
