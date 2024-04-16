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

    getReviewsByOfficeId(officeId) {
       
        return axios.get(`/reviews/${officeId}`)
    },

    addNewReviewByOfficeId(review) {
        return axios.post('/reviews', review)
    },
    // NEW VERSION OF API CALL TO GET OFFICES THAT EACH HAVE-A LIST OF DOCTORS
    getOfficesDeep() {
        return axios.get('/offices-details');
    },

    getDoctorsDeep(officeId) {
        return axios.get(`/doctor/${officeId}`);
    },

}