<template>
    <div class="doctor-main">
     
        <div>
            <br>
        <li>   {{ review.review }} </li></div>
            <br>
        
        <div class="appointment-button">

        

     <div v-if="$store.state.currentRole === 'ROLE_DOCTOR'">
        <router-link class="router-link" v-bind:to="{ name: 'offices' }">
                Reply by Doctor
        </router-link>
         <button v-for="office in officeList" v-bind:office="office"
         v-bind:key="office.officeId" v-on:click.prevent="$router.push('/office/:officeId/edit')">UPDATE</button>
        </div>


        </div>
    </div>
</template>


<script>

export default {
    props: ["review"],

    computed: {},
    components: {},
};

</script>


<style scoped>


.router-link {

  justify-self: flex-end;
  text-decoration: none;
  color: black;
  border: solid 1px rgb(190, 189, 189);
  border-radius: 4px;
  font-size: 13px;
  text-align: center;
  padding: 4px;
  background-color: rgb(250, 249, 249);
  letter-spacing: .05rem
}
</style>