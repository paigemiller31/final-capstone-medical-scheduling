import axios from 'axios';

export default {

    getOffices() {
        return axios.get('/offices')
    },

    // we need this for the method to get itemized/separated office things, like office.officeName, office.phoneNumber, etc.
    getOfficeByOfficeId(officeId) {
      return axios.get(`offices/${officeId}`)  
    },

    getDoctorsByOfficeId(officeId) {
        return axios.get(`/doctor/${officeId}`)
    },

}