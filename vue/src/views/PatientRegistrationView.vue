<template>
    <div class="container">

        <div id="patient-registration-component">
            <h1 id="patient-registration-header">Patient Registration</h1>

            <label>First Name</label>
            <div class="form-input-group">
                <input type="text" id="first-name-input-box" v-model="patient.firstName" required autofocus />
            </div>

            <label>Last Name</label>
            <div class="form-input-group">
                <input type="text" id="last-name-input-box" v-model="patient.lastName" required autofocus />
            </div>

            <label>Address</label>
            <div class="form-input-group">
                <input type="text" id="address1-input-box" v-model="patient.addressLineOne" required autofocus />
            </div>
            <div class="form-input-group">
                <input type="text" id="address2-input-box" v-model="patient.addressLineTwo" required autofocus />
            </div>

            <label>City</label>
            <div class="form-input-group">
                <input type="text" id="city-input-box" v-model="patient.city" required autofocus />
            </div>

            <label>State</label>
            <div class="form-input-group">
                <input type="text" id="state-input-box" v-model="patient.state" required autofocus />
            </div>

            <label>Zip Code</label>
            <div class="form-input-group">
                <input type="text" id="zipcode-input-box" v-model="patient.zipCode" required autofocus />
            </div>

            <label>Phone Number</label>
            <div class="form-input-group">
                <input type="text" id="phone-number-input-box" v-model="patient.phoneNumber" required autofocus />
            </div>

            <label>Email Address</label>
            <div class="form-input-group">
                <input type="text" id="email-address-input-box" v-model="patient.emailAddress" required autofocus />
            </div>

            <button id="button" type="submit" v-on:click="submitPatientForm()">Submit</button>

        </div>
    </div>
    <patient-registration v-bind:patient="patient" />
</template>


<script>

import PatientRegistration from '../components/PatientRegistration.vue'

export default {
    components: {
        PatientRegistration
    },
    data() {
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