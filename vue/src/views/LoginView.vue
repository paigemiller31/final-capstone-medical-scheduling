<template>
  <body>
    <div>
      <form v-on:submit.prevent="login">
        <!-- THIS IS NO LONGER BEING IMPLEMENTED, BUT IT MIGHT COME IN HANDY LATER -->
        <div role="alert" v-if="this.$route.query.registration">
          Thank you for registering, please sign in.
        </div>
        <div class="container">
          <div class="login-component">
            <h1 id="login-header">Login</h1>
            <div class="form-input-group">
              <input type="text" class="login-input-box" v-model="user.username" required autofocus
                placeholder=" Username" />
            </div>
            <div class="form-input-group">
              <input type="password" class="login-input-box" v-model="user.password" required placeholder=" Password" />
              <div role="alert" v-if="invalidCredentials">
                <p id="invalid-entry">Invalid username and password</p>
              </div>
              <p class="button-alignment"><button id="button" type="submit" v-on:click="login()">Submit</button></p>
            </div>
          </div>
          <div class="register-component">
            <p>Not registered yet?</p>
            <button id="button" type="submit" v-on:click="register()">Create an
              Account</button>
          </div>
        </div>
      </form>
    </div>
  </body>
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

.container {
  display: grid;
  grid-template-columns: 1fr 2fr 1fr;
  grid-template-rows: 1fr 2fr 1fr;
  grid-template-areas:
    ". . ."
    ". login ."
    ". register ."
  ;
  height: 88vh;
}

.login-component {
  grid-area: login;
  justify-content: center;
  align-items: center;
  display: flex;
  flex-direction: column;
  margin-bottom: 250px;
}

.register-component {
  grid-area: register;
  align-items: center;
  justify-content: end;
  display: flex;
  flex-direction: column;
  margin-bottom: 50px;
}

body {
  font-family: Arial, Helvetica, sans-serif;
  font-size: 11pt;
  letter-spacing: .2pt;
  text-shadow: 0.1px 0.1px 0.1px;
}

.form-input-group {
  margin-bottom: 2rem;
}

#login-header {
  margin-bottom: 2rem;
  font-family: Arial, Helvetica, sans-serif;
  font-weight: 100;
  font-size: 22pt;
  text-transform: uppercase;
}

input::placeholder {
  font-family: Arial, Helvetica, sans-serif;
  font-size: 7pt;
  color: rgb(210, 210, 210);
}

#button {
  font-family: Arial, Helvetica, sans-serif;
  font-size: 8pt;
  text-transform: uppercase;
  letter-spacing: 3pt;
  background-color: transparent;
  border-style: none;
  border-bottom: solid 1px #000000;
  padding: .1rem;
}

#button:hover {
  cursor: pointer;
}

.button-alignment {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 22px;
}

.login-input-box {
  width: 250px;
  height: 20px;
  padding: 7px;
  border-style: none;
  border-radius: 3px;
  outline: none;
}

#invalid-entry {
  justify-content: center;
  align-items: center;
  display: flex;
  flex-direction: column;
}
</style>