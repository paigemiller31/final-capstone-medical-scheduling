import axios from 'axios';

export default {

    getOffices() {
        return axios.get('/offices')
    },

    getDoctorsByOfficeId(officeId) {
        
        return axios.get(`/doctor/${officeId}` )
    }
}