<template>
  <div id="capstone-app">
    <div id="nav" class="top-nav">
      <header class="nav-header">
        <a class="logo-welcome">
          <router-link class="home-button" v-bind:to="{ name: 'home' }"><img
              src="..\..\src\assets\home-button-removebg-preview.png"></router-link>
          <li id="welcome-user" v-if="$store.state.token !== ''"><a>Welcome, {{ $store.state.user.username }}</a></li>
        </a>
        <nav class="links-nav">
          <ul class="all-links">
            <div class="all-links-spacing">
              <li class="li-links"><router-link class="nav-link" v-bind:to="{ name: 'offices' }">Offices</router-link></li>
              <div v-if="$store.state.token != ''">
                <li class="li-links"><router-link class="nav-link" v-bind:to="{ name: 'my-appointment' }">My
                    Appointments</router-link></li>
              </div>
              <li class="li-links"><router-link class="nav-link" v-bind:to="{ name: 'login' }"
                  v-if="$store.state.token == ''">Login</router-link></li>
              <li class="li-links"><router-link class="nav-link" v-bind:to="{ name: 'logout' }"
                  v-if="$store.state.token != ''">Logout</router-link></li>
            </div>
          </ul>
        </nav>
      </header>
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

.nav-header {
  display: flex;
  align-items: center;
}

.all-links {
  display: flex;
  justify-content: flex-end;
  margin-right: 10px;
}

.all-links-spacing {
  display: flex;
  justify-content: space-around;
}

.links-nav {
  flex-grow: 1;
}

.li-links {
  list-style-type: none;
}

.logo-welcome {
  display: flex;
  justify-content: center;
  align-items: center;
}

.top-nav {
  position: sticky;
  top: 0px;
  background-color: rgba(255, 255, 255, 0.7);
  height: 70px;
}

.home-button {
  margin-left: 10px;
}

#welcome-user {
  color: #000000;
  margin-left: 17px;
  font-family: Arial, Helvetica, sans-serif;
  font-size: 12pt;
  list-style-type: none;
  font-family: Arial, Helvetica, sans-serif;
  letter-spacing: .5pt;
}

.top-nav .nav-link {
  margin: 13px;
  color: #000000;
  text-decoration: none;
  font-family: Arial, Helvetica, sans-serif;
  font-size: 11.5pt;
  text-transform: uppercase;
}

.nav-link:hover {
  color: #666666;
}
</style>