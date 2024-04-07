<template>
    <div>
        
    </div>
</template>


<script>

import RegisterUserService from '../services/RegisterUserService';

export default {
    props: {
        patient: {
            type: Object,
            required: true,
        },
    },

    data() {
        return {
            createPatient: {
                id: this.patient.id,
                firstName: this.patient.firstName,
                lastName: this.patient.lastName,
                addressLineOne: this.patient.addressLineOne,
                addressLineTwo: this.patient.addressLineTwo,
                city: this.patient.city,
                state: this.patient.state,
                zipCode: this.patient.zipCode,
                phoneNumber: this.patient.phoneNumber,
                emailAddress: this.patient.emailAddress,
            }
        };
    },

    methods: {
        submitPatientForm() {
            
            if (!this.validatePatientForm()) {
                return;
            }

            if (this.createPatient.id === 0) {
                RegisterUserService.registerPatient(this.createPatient)
                .then (response => {
                    if (response.status === 201) {
                        this.$router.push({name: 'login', params: {patientId: this.createPatient.id}});
                    }
                })
                .catch (error => {
                    this.handleErrorResponse(error, 'adding');
                })
            }

        },

        handleErrorResponse(error, verb) {

            if (error.response) {
                if (error.response.status == 404) {
                    this.$router.push({ name: 'NotFoundView' });
                } else {
                    this.$store.commit('SET_NOTIFICATION',
                        `Error ${verb} message. Response received was "${error.response.statusText}".`);
                }
            } else if (error.request) {
                this.$store.commit('SET_NOTIFICATION', `Error ${verb} message. Server could not be reached.`);
            } else {
                this.$store.commit('SET_NOTIFICATION', `Error ${verb} message. Request could not be created.`);
            }
        },

        validatePatientForm() {

            let alert = '';

            this.createPatient.firstName = this.createPatient.firstName.trim();
            if (this.createPatient.firstName.length === 0) {
                alert += "First name is required for registration";
            }

            this.createPatient.lastName = this.createPatient.lastName.trim();
            if (this.createPatient.lastName.length === 0) {
                alert += "Last name is required for registration";
            }

            this.createPatient.addressLineOne = this.createPatient.addressLineOne.trim();
            if (this.createPatient.addressLineOne.length === 0) {
                alert += "Address is required for registration";
            }

            this.createPatient.addressLineTwo = this.createPatient.addressLineTwo.trim();

            this.createPatient.city = this.createPatient.city.trim();
            if (this.createPatient.city.length === 0) {
                alert += "City is required for registration";
            }

            this.createPatient.state = this.createPatient.state.trim();
            if (this.createPatient.state.length === 0) {
                alert += "State is required for registration";
            }

            this.createPatient.zipCode = this.createPatient.zipCode.trim();
            if (this.createPatient.zipCode.length === 0) {
                alert += "Zip code is required for registration";
            }

            this.createPatient.phoneNumber = this.createPatient.phoneNumber.trim();
            if (this.createPatient.phoneNumber.length === 0) {
                alert += "Phone number is required for registration";
            }

            this.createPatient.emailAddress = this.createPatient.emailAddress.trim();
            if (this.createPatient.emailAddress === 0) {
                alert += "Email address is required for registration";
            }

            if (alert.length > 0) {
                this.$store.commit('SET_NOTIFICATION', alert);
                return false;
            }
            return true;
        },


    }
};

</script>


<style></style>