<template>
  <div id="capstone-app">
    <div id="nav">
      <!-- dis is what we have 
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'login' }">Log in</router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> -->

      <!-- dis is how we do it -->
      <router-link v-bind:to="{ name: 'home' }">HOME</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{name: 'offices'}">OFFICES</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{name: 'schedule-appointment'}">SCHEDULE APPOINTMENT</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{name: 'my-appointment'}">MY APPOINTMENTS</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">LOGIN</router-link> &nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">LOGOUT</router-link>

    </div>
    <router-view />
  </div>
</template>
