<template>
  <div>
    <h1>Offices</h1>
    <div class="offices-list">
      <office-card v-for="office in offices" v-bind:office="office" v-bind:key="office.id" />
    </div>

  </div>
</template>
    
<script>
import OfficeCard from './OfficeCard.vue';
import OfficeService from '../services/OfficeService';

export default {

  
  computed: {
    offices() {
      let id = this.$route.params.officeId;
      let office = this.officeList.filter(office => {
        return office.officeId == id;
      });

      if (office.length > 0) {
        return office[0];
      } else {
        return {};
      }
    }
  },
  components: {
    OfficeCard
  }
};
</script>
    
<style></style>