<template>
    <div class="doctor-main">

        <div>{{ doctor.firstName + " " + doctor.lastName + " " }}</div>
        <div>{{ doctor.specialization + " " }}</div>
        <div>${{ doctor.costPerHour }}.00 per hour</div>

        <div id="appt-selection">

            <input type="date" name="apptDay" id="apptDay"/>


        </div>


        <div class="appointment-button">
            <router-link class="router-link" v-bind:to="{ name: 'doctors', params: { doctorId } }">
                Schedule an Appointment
            </router-link>
        </div>
    </div>
</template>


<script>

export default {
    data() {
        return {
        }
    },
    props: ["doctor"],

    computed: {},
    components: {},
    methods: {

        
    }
};

</script>


<style scoped></style>