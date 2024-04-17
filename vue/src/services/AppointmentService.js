import axios from 'axios';

export default {

  // this is for patients to see their appointments
  getAppointmentsByPatientId(patientId) {
    //  alert(patientId)
      return axios.get(`/patient-appointments/${patientId}`)
  },

  getPatientDetailsByPatientId(patientId) {
     // alert(patientId)
      return axios.get(`/patient/id/${patientId}`)
  },


  // this is for doctors to see appointments
  getAppointmentsByDoctorId(doctorId) {
      return axios.get(`/doctor-appointments/${doctorId}`)
  },

  getDoctorDetailsByDoctorId(doctorId) {
      return axios.get(`/doctor/id/${doctorId}`)
  },

  /* not using this yet, so commenting it out for now to focus on ^
  getScheduleAppointmentsByPatientId(patientId) {
      return axios.get(`scheduleAppointments/${patientId}`)
  },
  */


}