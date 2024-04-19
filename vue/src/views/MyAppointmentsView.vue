<template>
  <div class="form-body">

    <header class="appointment-header">Upcoming Appointments</header>

    <div class="column-group">
    <div class="column-names-row">
    <div class="name">Name</div>
    <div class="date">Date</div>
    <div class="time">Time</div>
    </div>
    </div>

    <div class="appointment-info">
      <appointment
        v-for="appointment in appointmentList"
        v-bind:key="appointment.appointmentId"
        v-bind:appointment="appointment"
      />
    </div>
    <div class="courtesy-note" v-if="$store.state.currentRole === 'ROLE_USER'">Please call the office at which your appointment is scheduled if you need to cancel or reschedule.</div>
  </div>
</template>

<script>
import AppointmentService from "../services/AppointmentService";
//import DoctorAppointments from "../components/DoctorAppointments.vue";
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

<style scoped>

* {
  font-family: Arial, Helvetica, sans-serif;
}

.form-body {
    margin-top: 70px;
    margin-bottom: 50px;
    margin-left: 70px;
    margin-right: 70px;
    padding-right: 90px;
    padding-left: 90px;
    padding-top: 100px;
    padding-bottom: 200px;
    background-color: rgba(219, 219, 219, 0.5);
}

.appointment-header {
  margin-bottom: 2rem;
  font-weight: 100;
  font-size: 22pt;
  text-transform: uppercase;
  text-align: center;
  letter-spacing: .01rem;
}

.column-group {
  display: flex;
  justify-content: center;
}

.column-names-row {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas: 
    "name date time"
  ;
  margin-top: 50px;
  text-transform: uppercase;
  font-size: 20px;
  width: 1000px;
  padding: 10px;
  border-bottom: rgb(0, 0, 0) 1px solid;
}

.name {
  display: flex;
  justify-content: center;
  grid-area: name;
}

.date {
  display: flex;
  justify-content: center;
  grid-area: date;
}

.time {
  display: flex;
  justify-content: center;
  grid-area: time;
}

.appointment-info {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin-top: 30px;
}

.courtesy-note {
  display: flex;
  justify-content: center;
  font-size: 16px;
  font-style: italic;
  margin-top: 10px;
}
</style>