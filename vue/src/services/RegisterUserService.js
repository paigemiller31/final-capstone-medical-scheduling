import axios from 'axios';

export default {

    registerPatient(patient) {
        return axios.post('/patient', patient)
    },

}