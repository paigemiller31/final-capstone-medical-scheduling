<template>
  <div class="office-main">
    <h3>{{ office.officeName }}</h3>

    <div>
      <span class="address">{{ office.addressLine1 }}</span>
      <span class="address">{{ office.addressLine2 }}</span>

      <span class="address">{{ office.city }}, {{ office.state }} {{ office.zipCode }}</span>

      <br/>
      <span class="address">{{ office.phoneNumber }}</span>
      <span class="address">{{ office.email }}</span>
      <br/>
      <span class="address">{{ office.officeHours }}</span>
    </div>

    <h4>Meet our staff and Book Appointments</h4>

    <ul>
      <li
        class="doctor-list-item"
        v-for="doc in office.officeDoctors"
        v-bind:key="doc.doctorId"
      >
        <router-link v-bind:to="{ path: '/doctor/' + doc.doctorId }">
          <button class="btn-select-doc">
            {{ doc.firstName + " " + doc.lastName }}
          </button>
        </router-link>
      </li>
    </ul>
  </div>
</template>
    
<script>
// import OfficeCard from './OfficeCard.vue';
// import OfficeService from '../services/OfficeService';

export default {
  props: ["office"],

  computed: {},
  components: {},
};
</script>
    
<style scoped>
.office-main {
  border: 2px black solid;
  border-radius: 4px;
}

.address {
  display: block;
}
</style>