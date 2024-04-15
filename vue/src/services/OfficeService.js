import axios from 'axios';

export default {

    getOffices() {
        return axios.get('/offices')
    },

    getOfficeByOfficeId(officeId) {
      return axios.get(`offices/${officeId}`)  
    },

    getDoctorsByOfficeId(officeId) {
        return axios.get(`/doctor/${officeId}`)
    },

    updateOfficeById(office) {
        return axios.put(`/offices/${office.officeId}`, office);
    },

    // NEW VERSION OF API CALL TO GET OFFICES THAT EACH HAVE-A LIST OF DOCTORS
    getOfficesDeep() {
        return axios.get('/offices-details');
    }

}