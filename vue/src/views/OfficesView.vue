<!-- RICH CONTRIBUTION -->
<template>
  <body>
    <div class="home">
      <div class="form-body">
        <h1 class="main-header">Offices</h1>

        <div class="office-images-row">
          <img src="src\assets\Haven.JPG" alt="office">
          <img src="src\assets\Artemis.JPG" alt="office">
          <img src="src\assets\Visage.JPG" alt="office">
          <img src="src\assets\Banyan.JPG" alt="office">
        </div>
        <div class="office-row">
          <!-- *NEW* OFFICE COMPONENT aka 'OFFICE CARD' -->
          <div></div>
          <office v-for="off in officeList" :key="off.officeId" :office="off" />
        </div>
        
        <ul id="update-button" v-if="$store.state.currentRole === 'ROLE_ADMIN'">
          <div class="update-button-row">
          <div v-for="office in officeList" v-bind:key="office.officeId">
            <router-link v-bind:to="{ path: '/offices/' + office.officeId + '/edit' }">
              <button id="update-office-btn" v-bind:officeId="office.officeId">Update Office</button>
            </router-link>
          </div>
        </div>
        </ul>
      </div>
    </div>
  </body>
</template>

<script>
import OfficeService from "../services/OfficeService";
import Office from "../components/Office.vue";

export default {
  components: {
    Office,
  },
  data() {
    return {
      officeList: [],
    };
  },
  methods: {
    listOffices() {
      OfficeService.getOfficesDeep().then((response) => {
        if (response.status === 200) {
          this.officeList = response.data;
        }
      });
    },
  },
  created() {
    this.listOffices();
  },
};
</script>

<style scoped>
* {
  font-family: Arial, Helvetica, sans-serif;
  color: #000000;
}

.home {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas: 
    ". offices ."
  ;
}

office {
  margin: 10px 0px;
}

body {
  overflow: hidden;
}

.main-header {
  text-transform: uppercase;
  text-justify: center;
  text-align: center;
  padding-top: 25px;
  font-weight: 100;
  font-size: 25pt;
}

.form-body {
  grid-area: offices;
  background-color: rgba(219, 219, 219, 0.5);
  margin-top: 75px;
  margin-bottom: 50px;
  margin-left: 50px;
  margin-right: 50px;
  width: 100vh;
  padding-left: 300px;
  padding-right: 300px;
}

.office-row {
  display: flex;
  flex-direction: row;
  justify-content: center;
}

.office-images-row {
  display: flex;
  justify-content: center;
  padding-bottom: 10px;
}

img {
  max-width: 250px;
  margin: 20px;
  border: rgb(229, 229, 229) solid 1px;
}

.update-button-row {
  display: flex;
  justify-content: space-between;
  padding: 10px;
}


button {
  font-family: Arial, Helvetica, sans-serif;
  font-size: 8pt;
  text-transform: uppercase;
  letter-spacing: 3pt;
  background-color: transparent;
  border: solid 1px #000000;
  padding: .3rem;
  row-gap: 30px;
}

button:hover {
  cursor: pointer;
}

</style>


<!-- JASMINE :)

<style scoped>
* {
  font-family: Arial, Helvetica, sans-serif;
  color: #000000;
}

.home {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas: 
    ". offices ."
  ;
}

office {
  margin: 10px 0px;
}

body {
  overflow: hidden;
}

.main-header {
  text-transform: uppercase;
  font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
  text-justify: center;
  text-align: center;
  padding-top: 25px;
  font-weight: 100;
  font-size: 26pt;
  letter-spacing: .15rem;
}

.form-body {
  grid-area: offices;
  background-color: rgba(116, 114, 114, 0.5);
  border-radius: 1%;
  margin-top: 75px;
  margin-bottom: 50px;
  margin-left: 50px;
  margin-right: 50px;
  width: 100vh;
  height: 145vh;
  padding-left: 300px;
  padding-right: 300px;
}

.office-row {
  display: flex;
  flex-direction: row;
  justify-content: center;
}

.office-images-row {
  display: flex;
  justify-content: center;
  padding-bottom: 10px;
}

img {
  min-width: 256px;
  max-height: 200px;
  border-radius: 0px;
  margin: 20px;
}

.update-button-row {
  display: flex;
  justify-content: space-between;
  padding: 10px;
}


button {
  font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
  font-size: 8pt;
  text-transform: uppercase;
  letter-spacing: 3pt;
  background-color: transparent;
  border: solid 1px #000000;
  padding: .3rem;
  row-gap: 30px;
}

button:hover {
  cursor: pointer;
}

</style>

 -->