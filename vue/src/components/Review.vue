<template>
    <div class="doctor-main">
            <div class="reviews">" {{ review.review }} "</div>
        <br>
        
        <!--
        <div class="appointment-button">
         <div v-if="$store.state.currentRole === 'ROLE_DOCTOR'">
        <router-link class="router-link" v-bind:to="{ name: 'offices' }">Reply to Review</router-link>
         <button v-for="office in officeList" v-bind:office="office"
         v-bind:key="office.officeId" v-on:click.prevent="$router.push('/office/:officeId/edit')">Update</button>
        </div> 
        </div>-->

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

.reviews {
    display: flex;
    flex-basis: 100%;
    padding: 20px;
    border: solid 1.5px rgba(196, 196, 196, 0.8);
    border-radius: 4px;
    width: 700px;
    height: 50px;
    background-color: rgba(241, 241, 241, 0.7);
    font-style: italic;
}
</style>