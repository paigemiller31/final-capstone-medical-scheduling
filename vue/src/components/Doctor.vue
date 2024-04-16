<template>
    <div class="doctor-main">
        <div class="doctors-info-row">
            <span>{{ doctor.firstName + " " + doctor.lastName + " "}}</span>
            <span>{{ doctor.specialization + " "}}</span>
            <span>${{ doctor.costPerHour }}.00 per hour</span>
        </div>

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

.doctors-info-row {
    display: flex;
}

</style>