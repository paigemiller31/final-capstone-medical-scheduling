import axios from 'axios';

export default {

    registerPatient(patient) {
        return axios.post('/patient', patient)
    },

    // DELETE //
    registerDoctor(doctor) {
        return axios.post('/doctorRegistration', doctor)
    }
}