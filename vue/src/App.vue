<template>
  <div id="capstone-app">
    <div id="nav" class="top-nav">

      <router-link class="nav-link" v-bind:to="{ name: 'home' }" v-if="$store.state.token != ''"> Welcome, {{$store.state.user.username}}</router-link>

      <router-link class="nav-link" v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">Login</router-link>
      <router-link class="nav-link" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>


    <div  v-if="$store.state.token != ''">

      <!-- <div v-if="$store.state.currentRole === 'ROLE_USER'"> -->
        <router-link class="nav-link" v-bind:to="{ name: 'my-appointment' }">My Appointments</router-link>

      <!-- </div> -->

      <!-- <div v-if="$store.state.currentRole === 'ROLE_DOCTOR'"> -->
        <!-- <router-link class="nav-link" v-bind:to="{ name: 'home' }">Incoming Appointments</router-link>
        <router-link class="nav-link" v-bind:to="{ name: 'home' }">Reviews Management</router-link> -->
      <!-- </div> -->

    </div>

      <!-- FIX BUG: offices router link broken when not logged in-->
      <router-link class="nav-link" v-bind:to="{ name: 'offices' }">Offices</router-link>

      <router-link class="home-button" v-bind:to="{ name: 'home' }"><img src="..\..\src\assets\home-button-removebg-preview.png"></router-link>

    </div>
    <router-view />
  </div>
</template>


<script>

</script>


<style>
body {
  background-image: url("/src/assets/background.jpg");
  background-attachment: fixed;
  background-size: cover;
}

.top-nav {
  /* overflow: hidden; */
  background-color: #ffffff;
  margin-top: 35px;
  height: 50px;
}

.home-button {
  margin-left: 15px;
}

.top-nav .nav-link {
  float: right;
  color: #000000;
  text-align: center;
  margin-top: 15px;
  margin-right: 28px;
  text-decoration: none;
  font-family: Arial, Helvetica, sans-serif;
  font-size: 11.5pt;
  text-transform: uppercase;
}

.top-nav>.nav-link:hover {
  background-color: #FFFFFF;
  color: #000000;
}

.top-nav>.nav-link.active {
  color: #000000;
}
</style>






<!-- JASMINE :)

<style scoped>
body {
  background-image: url("/src/assets/background.jpg");
  background-attachment: fixed;
  background-size: cover;
}

.top-nav {
  /* overflow: hidden; */
  position: sticky;
  top: 0px;
  background-color: rgba(255, 255, 255, 0.7);
  margin-top: 0px;
  height: 70px;
}

.home-button {
  margin-left: 40px;
}

.top-nav .nav-link {
  float: right;
  color: #999999;
  font-weight: 500;
  text-align: center;
  margin-top: 22px;
  margin-right: 45px;
  text-decoration: none;
  font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
  font-size: 13pt;
  text-transform: uppercase;
}

.top-nav>.nav-link:hover {
  color: #d7d7d7;
}

.top-nav>.nav-link.active {
  color: #000000;
}
</style>

-->