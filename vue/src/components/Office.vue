<template>
  <div class="office-main">
    <div class="office-name">{{ office.officeName }}</div>

    <div class="information-text">
      <div class="address">{{ office.addressLine1 }}</div>
      <div class="address">{{ office.addressLine2 }}</div>

      <div class="address">{{ office.city }}, {{ office.state }} {{ office.zipCode }}</div>

      <br />
      <div class="address">{{ office.phoneNumber }}</div>
      <div class="address">{{ office.email }}</div>
      <br />
      <div class="hours-line">
        <div class="address">{{ office.officeHours }}</div>
      </div>
    </div>
    <br>

    <div class="doctor-list-item" v-for="doc in office.officeDoctors" v-bind:key="doc.doctorId">
      {{ doc.firstName + " " + doc.lastName }}
      <div class="doctor-info">
      <div>{{ doc.specialization + " " }}</div>
      <div>${{ doc.costPerHour }}.00 per hour</div>
    </div>
      <br>
    </div>

    <div class="appointment-button">
      <router-link class= "router-link" v-bind:to="{ name: 'doctors', params: { officeId: office.officeId } }">
        Schedule an Appointment
      </router-link>
    </div>
  </div>
</template>
    
<script>

export default {
  props: ["office"],

  computed: {},
  components: {},
};
</script>
    
<style scoped>
.office-main {
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  border-radius: 2px;
  margin: 10px;
  background-color: rgb(235, 235, 235);
  border: 1.5px solid rgb(196, 196, 196);
  padding: 10px;
  min-width: 250px;
}

.office-name {
  font-size: 16px;
  text-align: center;
  padding-bottom: 30px;
  text-transform: uppercase;
}

.address {
  font-size: 14px;
}

.doctor-list-item {
  display: flex;
  flex-direction: column;
  font-size: 14px;
  padding-left: 10px;
}


.router-link {
  display: flex;
  flex-direction: column;
  justify-self: flex-end;
  text-decoration: none;
  color: black;
  border: solid 1px rgb(190, 189, 189);
  border-radius: 4px;
  font-size: 13px;
  text-align: center;
  padding: 4px;
  background-color: rgb(217, 217, 217);
  letter-spacing: .05rem
}

.information-text {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.hours-line {
  padding-bottom: 30px;
}

.doctor-info {
  font-size: 13px;
}
</style>