<template>
  <body>
    <div id="register" class="text-center">
      <form v-on:submit.prevent="register">
        <div class="container">
          <div class="register-component">
            <h1 id="register-header">Register</h1>
            <div class="form-input-group">
              <input type="text" class="register-input-box" v-model="user.username" required autofocus
                placeholder=" Username" />
            </div>
            <div class="form-input-group">
              <input type="password" class="register-input-box" v-model="user.password" required
                placeholder=" Password" />
            </div>
            <div class="form-input-group">
              <input type="password" class="register-input-box" v-model="user.confirmPassword" required
                placeholder=" Confirm Password" />
            </div>
            <div role="alert" v-if="registrationErrors">
              {{ registrationErrorMsg }}
            </div>
            <!-- added register method - what is it doing ... ? -->
            <p class="button-alignment"><button id="button" type="submit" v-on:click="login()">Submit</button></p>
          </div>
          <div class="login-component">
            <p>Already registered?</p>
            <router-link v-bind:to="{ name: 'login' }"><button id="button" type="submit">Login</button></router-link>
          </div>
        </div>
      </form>
    </div>
  </body>
</template>

<script>
import authService from '../services/AuthService';

export default {
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    login() {

      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password entries do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              // this.$router.push({
              //   path: '/patientRegistration',
              //   query: { registration: 'success' },
              // });
              authService
                .login(this.user)
                .then(response => {
                  if (response.status == 200) {
                    this.$store.commit("SET_AUTH_TOKEN", response.data.token);
                    this.$store.commit("SET_USER", response.data.user);
                    this.$router.push("/patientRegistration");
                  }
                })
                .catch(error => {
                  const response = error.response;

                  if (response.status === 401) {
                    this.invalidCredentials = true;
                  }
                });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
              // ^^^^^^^^^^^^^^ change dis
            }
          });




      }
    },
    registerAsPatient() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password entries do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/patientregistration',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
              // ^^^^^^^^^^^^^^ change dis
            }
          });
      }
    },

    registerAsDoctor() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password entries do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/doctorregistration',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
              // ^^^^^^^^^^^^^^ change dis
            }
          });
      }
    },

    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>
.container {
  display: grid;
  grid-template-columns: 1fr 2fr 1fr;
  grid-template-rows: 1fr 2fr 1fr;
  grid-template-areas:
    ". . ."
    ". register ."
    ". login ."
  ;
  height: 90vh;
}

.register-component {
  grid-area: register;
  justify-content: center;
  align-items: center;
  display: flex;
  flex-direction: column;
  margin-bottom: 150px;
}

.login-component {
  grid-area: login;
  align-items: center;
  justify-content: end;
  display: flex;
  flex-direction: column;
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

#register-header {
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
}

.register-input-box {
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