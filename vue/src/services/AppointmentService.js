import axios from 'axios';

export default {

    getAppointmentsByPatientId(patientId) {
        return axios.get(`appointments/${patientId}`)
    },

    // this is for doctors to see appointments
    getAppointmentsByDoctorId(doctorId) {
        return axios.get(`appointments/${doctorId}`)
    },

    // this is for patients to see their appointments
    getScheduleAppointmentsByPatientId(patientId) {
        return axios.get(`scheduleAppointments/${patientId}`)
    },

}