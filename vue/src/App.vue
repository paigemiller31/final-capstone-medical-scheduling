<template>
  <div id="capstone-app">
    <div id="nav">

      <router-link class="nav-link" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link class="nav-link" v-bind:to="{ name: 'offices' }">Offices</router-link>&nbsp;|&nbsp;
      <router-link class="nav-link" v-bind:to="{ name: 'schedule-appointment' }">Schedule Appointment</router-link>&nbsp;|&nbsp;
      <router-link class="nav-link" v-bind:to="{ name: 'my-appointment' }">My Appointments</router-link>&nbsp;|&nbsp;
      <router-link class="nav-link" v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">Login</router-link>
      <router-link class="nav-link" v-bind:to="{ name: 'login' }" v-if="$store.state.token != ''">Logout</router-link>

    </div>
    <router-view />
  </div>
</template>

<script>
</script>


<style>
body {
  background-image: url("/src/assets/the one.jpg");
  background-attachment: fixed;
  background-size: cover;
}
.nav-link {
  color: #000000;
  text-decoration: none;
  text-transform: uppercase;
  font-family: Arial, Helvetica, sans-serif;
  font-size: 10pt;
} 




</style>
