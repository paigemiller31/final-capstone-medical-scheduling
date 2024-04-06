<template>
  <div id="capstone-app">
    <div id="nav">

      <router-link class="nav-link" v-bind:to="{ name: 'home' }">HOME</router-link>&nbsp;|&nbsp;
      <router-link class="nav-link" v-bind:to="{ name: 'offices' }">OFFICES</router-link>&nbsp;|&nbsp;
      <router-link class="nav-link" v-bind:to="{ name: 'schedule-appointment' }">SCHEDULE APPOINTMENT</router-link>&nbsp;|&nbsp;
      <router-link class="nav-link" v-bind:to="{ name: 'my-appointment' }">MY APPOINTMENTS</router-link>&nbsp;|&nbsp;
      <router-link class="nav-link" v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">LOGIN</router-link> &nbsp;|&nbsp;
      <router-link class="nav-link" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">LOGOUT</router-link>

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
  font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}
</style>