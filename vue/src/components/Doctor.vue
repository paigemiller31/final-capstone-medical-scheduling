<template>
    <div class="doctor-main">

        <div class="doctor-name">{{ doctor.firstName + " " + doctor.lastName + " " }}</div>
        <div class="doctor-specialization">{{ doctor.specialization + " " }}</div>
        <div class="doctor-cost">${{ doctor.costPerHour }}.00 Copay</div>

        <div id="appt-selection">
            <input type="date" name="apptDay" id="apptDay" />
            <input type="time" name="apptTime" id="apptTime">
        </div>
        
            
        

        <!-- post method for this button to create appointment when clicked -->
        <!-- <div class="appointment-button">
            <router-link class="router-link" v-bind:to="{ name: 'doctors', params: { doctorId } }">
                Schedule an Appointment
            </router-link>
        </div> -->

        <div id="submit-button">
            <router-link class="router-link" v-bind:to="{ name: 'my-appointment' }">
                Schedule Appointment
            </router-link>
        </div>
    </div>
</template>


<script>

import { routeLocationKey } from 'vue-router';
import DoctorService from '../services/DoctorService';

export default {
    data() {
        return {

            // is this correct?
            addAppointment: {
                doctorId: '',
                appointment: '',
            }
        }
    },
    props: ["doctor"],

    computed: {},
    components: {},
    methods: {

        accessAppointment(doctorId) {
            this.addAppointment.doctorId = this.$route.params.doctorId;
        },

        // is this correct? hmmm...... doctorId? appointmentId?
        submitForm() {
            this.addAppointment.doctorId = this.$route.params.doctorId;
            DoctorService.createAnAppointment(this.addAppointment)
                .then(response => {
                    if (response.status === 201) {
                        this.$router.push({ name: 'my-appointment' });
                    }
                })
        },

    },
    created() {
        this.accessAppointment(this.$route.params.doctorId);
    }
};

</script>


<style scoped>
* {
    font-family: Arial, Helvetica, sans-serif;
    color: #000000;
}

.doctor-main {
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    text-align: center;
    border-radius: 2px;
    margin: 30px;
    background-color: rgb(235, 235, 235);
    border: 1.5px solid rgb(196, 196, 196);
    padding: 20px;
    height: 250px;
    min-width: 250px;
}

.doctor-name {
    font-size: 20px;
    
}

.doctor-specialization {
    font-size: 17px;
}

.doctor-cost {
    font-size: 15px;
}



input {
    background-color: rgb(230, 230, 230);
    font-size: 14px;
    padding: 4px;
    width: 200px;
    text-align: center;
    border: solid 1px rgb(190, 189, 189);
    border-radius: 4px;
    letter-spacing: .05rem;
    margin-bottom: 10px;
}

.router-link {
    text-decoration: none;
    color: black;
    border: solid 1px rgb(190, 189, 189);
    border-radius: 4px;
    font-size: 13px;
    text-align: center;
    padding: 4px;
    background-color: rgb(217, 217, 217);
    letter-spacing: .05rem
}

#submit-button {}
</style>