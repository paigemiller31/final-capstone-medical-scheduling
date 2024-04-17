<template>
    <div class="doctor-appointment-main">

        <div>{{ appointment.appointmentDate }}</div>
        <div>{{ appointment.appointmentTime }}</div>
        <div>{{ appointment.duration }}</div>
    
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
    
    </style>