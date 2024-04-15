import axios from 'axios';

export default {

    getDoctorsByOfficeId(officeId) {
        return axios.get(`/doctor/${officeId}`)
    },

}