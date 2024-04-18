<template>
  <div>
    <div>
      <appointment
        v-for="appointment in appointmentList"
        v-bind:key="appointment.appointmentId"
        v-bind:appointment="appointment"
      />
    </div>
  </div>
</template>

<script>
import AppointmentService from "../services/AppointmentService";
import DoctorAppointments from "../components/DoctorAppointments.vue";
import Appointment from "../components/Appointment.vue";

export default {
  components: {
    // DoctorAppointments,
    Appointment,
  },
  data() {
    return {
      appointmentList: [],
      patient: [],
      // do we need to reference a list of patients ? and can we from the method in AppointmentService?
    };
  },
  methods: {
    accessPatientDetails(patientId) {
      // alert(  'accessPatientDetails is success')
      AppointmentService.getPatientDetailsByPatientId(patientId).then(
        (response) => {
          if (response.status === 200) {
            //alert(  'this is success')
            this.patient = response.data;

            //  alert(  this.patientList);
          }
        }
      );
    },
    listAppointmentsForPatients(patientId) {
      AppointmentService.getAppointmentsByPatientId(patientId).then(
        (response) => {
          if (response.status === 200) {
            this.appointmentList = response.data;
          }
        }
      );
    },
    listAppointmentsForDoctors(doctorId) {
      AppointmentService.getAppointmentsByDoctorId(doctorId).then(
        (response) => {
          if (response.status === 200) {
            this.appointmentList = response.data;
          }
        }
      );
    },

    accessDoctorDetails(doctorId) {
      // alert(  'accessPatientDetails is success')
      AppointmentService.getDoctorDetailsByDoctorId(doctorId).then(
        (response) => {
          if (response.status === 200) {
            //alert(  'this is success')
            this.patient = response.data;

            //  alert(  this.patientList);
          }
        }
      );
    },
    listPatients() {},
  },
  created() {
    switch (this.$store.state.user.authorities[0].name) {
      case "ROLE_USER":
        this.listAppointmentsForPatients(this.$store.state.user.id);
        break;
      case "ROLE_DOCTOR":
        this.listAppointmentsForDoctors(this.$store.state.user.id);
        break;
      default:
        break;
    }

    // this.accessAppointments(this.$route.params.patientId);
    // this.accessAppointments(this.$store.state.user.id );
    //this.accessPatientDetails(this.$store.state.user.id );
    // this.listAppointmentsForDoctors(this.$store.state.user.id  );
    // this.accessDoctorDetails(this.$store.state.user.id  );
  },

  // this.listAppointmentsForDoctors(this.$route.params.doctorId);
};
</script>

<style scoped></style>