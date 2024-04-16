<!-- RICH CONTRIBUTION -->
<template>
  <body>
    <div class="home">
      <div class="form-body">
        <h1 class="main-header">Offices</h1>

        <div class="office-images-row">
          <img src="src\assets\IMG_2679.JPG" alt="office">
          <img src="src\assets\IMG_2679.JPG" alt="office">
          <img src="src\assets\IMG_2679.JPG" alt="office">
          <img src="src\assets\IMG_2679.JPG" alt="office">
        </div>
        <div class="office-row">
          <!-- *NEW* OFFICE COMPONENT aka 'OFFICE CARD' -->
          <office v-for="off in officeList" :key="off.officeId" :office="off" />
        </div>
        <ul id="update-button" v-if="$store.state.user.authorities[0].name === 'ROLE_DOCTOR'">
          <div class="update-button-row">
          <div v-for="office in officeList" v-bind:key="office.officeId">
            <router-link v-bind:to="{ path: '/offices/' + office.officeId + '/edit' }">
              <button v-bind:officeId="office.officeId">Update</button>
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
  background-color: rgba(219, 219, 219, 0.5);
  margin-top: 75px;
  margin-bottom: 50px;
  margin-left: 30px;
  margin-right: 70px;
  width: 100vh;
}

.office-row {
  display: flex;
}

.office-images-row {
  display: flex;
}

img {
  max-width: 210px;
}

.update-button-row {
  display: flex;
}
</style>