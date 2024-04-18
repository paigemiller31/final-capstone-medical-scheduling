<template>
  <div class="doctor-main">
    <div class="doctor-name">
      {{ doctor.firstName + " " + doctor.lastName + " " }}
    </div>
    <div class="doctor-specialization">{{ doctor.specialization + " " }}</div>
    <div class="doctor-cost">${{ doctor.costPerHour }}.00 Copay</div>

    <div id="appt-selection">
      <input
        type="date"
        name="apptDay"
        id="apptDay"
        @change="getTimesForDate"
      />

      <!-- input type="time" name="apptTime" id="apptTime" -->
    </div>

    <div id='buttonList'>
      <input
        type="button"

        v-for="slot in appointmentSlots"
        v-bind:key="slot.timeBlock"
        :value="slot.timeBlock"
        @click.prevent="bookTime"
        
      />
    </div>


    <!-- post method for this button to create appointment when clicked -->
    <!-- <div class="appointment-button">
            <router-link class="router-link" v-bind:to="{ name: 'doctors', params: { doctorId } }">
                Schedule an Appointment
            </router-link>
        </div> -->


  </div>
</template>


<script>
import { routeLocationKey } from "vue-router";
import DoctorService from "../services/DoctorService";
import AppointmentService from "../services/AppointmentService";

export default {
  data() {
    return {
      // is this correct? YES!!
      appointmentModel: {
        appointmentId: 0,
        patientId: 0,
        doctorId: 0,
        appointmentDate: '',
        appointmentTime: '',
        duration: 1,
        available: false,
        alert: true,
      },
      addAppointment: {
        appointmentId: 0,
        patientId: 0,
        doctorId: 0,
        appointmentDate: '',
        appointmentTime: '',
        duration: 1,
        available: false,
        alert: true,
      },
      selectedDate: null,
      selectedTime: null,
      appointmentSlots: [],
    };
  },
  props: ["doctor"],

  computed: {},
  components: {},
  methods: {

    bookTime(event) {


        this.selectedTime = event.target.value;

        this.addAppointment.doctorId = this.doctor.doctorId;
        this.addAppointment.patientId = this.$store.state.user.id;
        this.addAppointment.appointmentDate = this.selectedDate;
        this.addAppointment.appointmentTime = this.selectedTime;

        AppointmentService.postNewAppointment(this.addAppointment).then(
            response => {
                this.addAppointment = this.appointmentModel;
                this.selectedDate = '';
                this.appointmentSlots=[];
                document.getElementById('apptDay').value = '';

                this.$router.push("/myAppointments");
            }
        )
    },
    getTimesForDate(event) {
      this.selectedDate = event.target.value;
      AppointmentService.getAvailableAppointmentsByDoctorAndDate(
        this.doctor.doctorId,
        this.selectedDate
      ).then((response) => {
        let filterArray = [];
        filterArray = response.data;

        this.appointmentSlots = filterArray.filter((slot) => {
          return slot.patientId == 0;
        });
      });
    },

    accessAppointment(doctorId) {
      this.addAppointment.doctorId = this.$route.params.doctorId;
    },

    submitForm() {
      this.addAppointment.doctorId = this.$route.params.doctorId;
      DoctorService.createAnAppointment(this.addAppointment).then(
        (response) => {
          if (response.status === 201) {
            this.$router.push({ name: "my-appointment" });
          }
        }
      );
    },

    filterTimes() {},
  },
  created() {
    this.accessAppointment(this.$route.params.doctorId);
  },
};
</script>


<style scoped>
* {
  font-family: Arial, Helvetica, sans-serif;
  color: #000000;
}

.selected {
    color: gray;
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
  height: auto;
  width: 400px;
}

.doctor-name {
  font-size: 20px;
  margin-top: 10px;
  margin-bottom: 4px;
  letter-spacing: .01rem;
}

.doctor-specialization {
  font-size: 17px;
  margin-bottom: 2px;
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
  letter-spacing: 0.05rem;
  margin-bottom: 15px;
  margin-top: 10px;
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
  letter-spacing: 0.05rem;
}

</style>