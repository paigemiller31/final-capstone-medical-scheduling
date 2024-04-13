<template>
  <div id="capstone-app">
    <div id="nav" class="top-nav" >

      <router-link class="nav-link" v-bind:to="{ name: 'home' }">Home</router-link>
      <router-link class="nav-link" v-bind:to="{ name: 'offices' }">Offices</router-link>
      <router-link class="nav-link" v-bind:to="{ name: 'schedule-appointment' }">Schedule Appointment</router-link>
      <router-link class="nav-link" v-bind:to="{ name: 'my-appointment' }">My Appointments</router-link>
      <router-link class="nav-link" v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">Login</router-link>
      <router-link class="nav-link" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>

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
/* .nav-link {
  color: #000000;
  text-decoration: none;
  text-transform: uppercase;
  font-family: Arial, Helvetica, sans-serif;
  font-size: 10pt;
} */


.top-nav {
  overflow: hidden;
  background-color: #333;
}

.top-nav  .nav-link {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.top-nav  > .nav-link:hover {
  background-color: #ddd;
  color: black;
}

.top-nav  > .nav-link.active {
  background-color: #04AA6D;
  color: white;
}

</style>
