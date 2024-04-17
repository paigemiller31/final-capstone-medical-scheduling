import axios from 'axios';

export default {

    getDoctorsByOfficeId(officeId) {
        return axios.get(`/doctor/${officeId}`)
    },

    createAnAppointment(appointment) {
        return axios.post('/appointments', appointment)
    }

}