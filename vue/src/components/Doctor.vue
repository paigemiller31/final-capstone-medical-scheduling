<template>
    <div class="doctor-main">
        
            <div>{{ doctor.firstName + " " + doctor.lastName + " "}}</div>
            <div>{{ doctor.specialization + " "}}</div>
            <div>${{ doctor.costPerHour }}.00 per hour</div>
        

    </div>
</template>


<script>

export default {
    props: ["doctor"],

    computed: {},
    components: {},
};

</script>


<style scoped>


</style>