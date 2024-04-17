<template>
    <div>

        <div>
            <router-link v-bind:to="{name: 'home'}"><button>test button</button></router-link>
        </div>

        <div >
            <patient-appointments v-for="appointment in appointmentList" v-bind:key="appointment.appointmentId"
                v-bind:appointment="appointment" />
        </div>

        <!-- <div v-if="$store.state.currentRole === 'ROLE_DOCTOR'">
            <doctor-appointments v-for="appointment in appointmentList" v-bind:key="appointment.doctorId"
                v-bind:appointment="appointment" />
        </div> -->

    </div>
</template>

<script>

import AppointmentService from '../services/AppointmentService';
import DoctorAppointments from '../components/DoctorAppointments.vue';
import PatientAppointments from '../components/PatientAppointments.vue';

export default {
    components: {
        // DoctorAppointments,
        PatientAppointments
    },
    data() {
        return {
            appointmentList: [],
            // patientList:[], // do we need to reference a list of patients ? and can we from the method in AppointmentService?
        };
    },
    methods: {

        accessAppointments(patientId) {
            AppointmentService.getAppointmentsByPatientId(patientId)
            .then(response => {
                if (response.status === 200) {
                    this.appointmentList = response.data;
                }
            })
        },
        listAppointmentsForPatients(patientId) {
            AppointmentService.getAppointmentsByPatientId(patientId).then((response) => {
                if (response.status === 200) {
                    this.appointmentList = response.data;
                    //this.patientList = response.data; // this implementation applies to the above patient list situation - but doesn't appear to do what we want
                }
            })
        },
        listAppointmentsForDoctors(doctorId) {
            AppointmentService.getAppointmentsByDoctorId(doctorId).then((response) => {
                if (response.status === 200) {
                    this.appointmentList = response.data;
                }
            })
        },
        listPatients() {

        }
    },
    created() {
        // if (this.$store.state.currentRole === 'ROLE_USER') {
            // this.listAppointmentsForPatients(this.$route.params.patientId);
        // } else if (this.$store.state.currentRole === 'ROLE_DOCTOR') {
        //     this.listAppointmentsForDoctors(this.$route.params.doctorId);
        // }

        //this.listAppointmentsForPatients(this.$route.params.patientId);
        this.accessAppointments(this.$route.params.patientId);
    }
    
    // this.listAppointmentsForDoctors(this.$route.params.doctorId);
}

</script>

<style scoped></style>