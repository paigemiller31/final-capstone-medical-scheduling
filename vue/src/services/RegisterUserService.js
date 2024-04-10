import axios from 'axios';

export default {

    registerPatient(patient) {
        // pass in patient or user?
        return axios.post('/patient', patient)
    },

    registerDoctor(doctor) {
        // pass in doctor or user?
        return axios.post('/doctorRegistration', doctor)
    }
}