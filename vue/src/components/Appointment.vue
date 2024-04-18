<template>
    <div class="appointment-main">

                <span class="appt-detail">{{appointment.appointmentDate}}</span>
                <span class="appt-detail">{{appointment.appointmentTime}}</span>
                <span class="appt-detail">{{appointment.firstName}}</span>
                <span class="appt-detail">{{appointment.lastName}}</span>
                <span class="appt-detail">{{appointment.specialization}}</span>

        <!-- <div>{{ appointment.patientId }}</div> -->
        
    
    </div>
    </template>
    
    <script>
    export default {
        props: ["appointment"],
        

    computed: {},
    components: {},
    };
    </script>
    
    <style scoped>
    
    .appt-detail {
        display: inline-block;
        margin: 10px 10px;
        min-width: 60px;
    }

    </style>