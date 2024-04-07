<template>
    <div>
        patient
    </div>
    <patient-registration/>
</template>


<script>

import PatientRegistration from '../components/PatientRegistration.vue'

export default {
    components: {
        PatientRegistration
    },
    data () {
        return {
            patient: {
                id: 0,
                firstName: '',
                lastName: '',
                addressLineOne: '',
                addressLineTwo: '',
                city: '',
                state: '',
                zipCode: '',
                phoneNumber: '',
                emailAddress: '',
            },
        }
    },
};
</script>


<style></style>