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

}