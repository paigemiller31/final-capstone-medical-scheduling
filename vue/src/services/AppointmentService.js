import axios from 'axios';

export default {

    // this is for patients to see their appointments
    getAppointmentsByPatientId(patientId) {
        alert(patientId)
        return axios.get(`/patient-appointments/${patientId}`)
    },

    // this is for doctors to see appointments
    getAppointmentsByDoctorId(doctorId) {
        return axios.get(`/doctor-appointments/${doctorId}`)
    },

    /* not using this yet, so commenting it out for now to focus on ^
    getScheduleAppointmentsByPatientId(patientId) {
        return axios.get(`scheduleAppointments/${patientId}`)
    },
    */

}