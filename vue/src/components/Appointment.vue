<template>
    <div class="appointment-main">
        <span class="name">{{ appointment.firstName + ' ' +  appointment.lastName }}</span>
        <span class="date">{{ appointment.appointmentDate }}</span>
        <span class="time">{{ appointment.appointmentTime }}</span>
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
.appointment-main {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    grid-template-areas:
        "name date time"
    ;
    margin-bottom: 20px;
    background-color: rgb(235, 235, 235);
    border: 1.5px solid rgb(190, 190, 190);
    border-radius: 3pt;
    padding: 15px;
    width: 1000px;
}

.name {
    grid-area: name;
    display: flex;
    justify-content: center;
    font-family: Arial, Helvetica, sans-serif;
    font-size: 16px;

}

.date {
    grid-area: date;
    display: flex;
    justify-content: center;
    font-family: Arial, Helvetica, sans-serif;
    font-size: 16px;
    letter-spacing: .07rem;
}

.time {
    grid-area: time;
    display: flex;
    justify-content: center;
    font-family: Arial, Helvetica, sans-serif;
    font-size: 16px;
    letter-spacing: .07rem;
}

</style>