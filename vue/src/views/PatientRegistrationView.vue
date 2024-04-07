<template>
    <div class="container">

        <div id="patient-registration-component">
            <h1 id="patient-registration-header">Patient Registration</h1>

            <div id="name-flex-box">
                <div id="first-name">
                    <header>First Name</header>
                    <div class="form-input-group">
                        <input type="text" id="first-name-input-box" v-model="patient.firstName" required autofocus />
                    </div>
                </div>

                <div id="last-name">
                    <header>Last Name</header>
                    <div class="form-input-group">
                        <input type="text" id="last-name-input-box" v-model="patient.lastName" required autofocus />
                    </div>
                </div>
            </div>


            <div id="address-flex-box">
                <header>Address</header>
                <div class="form-input-group">
                    <input type="text" id="address1-input-box" v-model="patient.addressLineOne" required autofocus />
                </div>
                <div class="form-input-group">
                    <input type="text" id="address2-input-box" v-model="patient.addressLineTwo" required autofocus />
                </div>
            </div>


            <div id="city-state-zip-flex-box">
                <div id="city">
                    <header>City</header>
                    <div class="form-input-group">
                        <input type="text" id="city-input-box" v-model="patient.city" required autofocus />
                    </div>
                </div>

                <div id="state">
                    <header>State</header>
                    <div class="form-input-group">
                        <input type="text" id="state-input-box" v-model="patient.state" required autofocus />
                    </div>
                </div>

                <div id="zip-code">
                    <header>Zip Code</header>
                    <div class="form-input-group">
                        <input type="text" id="zipcode-input-box" v-model="patient.zipCode" required autofocus />
                    </div>
                </div>
            </div>


            <div id="contact-flex-box">
                <div id="phone-number">
                    <header>Phone Number</header>
                    <div class="form-input-group">
                        <input type="text" id="phone-number-input-box" v-model="patient.phoneNumber" required autofocus />
                    </div>
                </div>

                <div id="email-address">
                    <header>Email Address</header>
                    <div class="form-input-group">
                        <input type="text" id="email-address-input-box" v-model="patient.emailAddress" required autofocus />
                    </div>
                </div>
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


<style>
.container {
    display: grid;
    grid-template-columns: 1fr;
    grid-template-areas:
        "header"
        "name"
        "address"
        "city-state-zip"
        "contact"
        "button"
    ;
    font-family: Arial, Helvetica, sans-serif;
}

#patient-registration-header {
    grid-area: header;
    display: flex;
    text-transform: uppercase;
}

#patient-registration-component {
    display: flex;
    flex-wrap: wrap;
    background-color: rgb(201, 201, 201, 0.5);
    justify-content: center;
    align-items: center;
}

#name-flex-box {
    grid-area: name;
    display: flex;
    flex-basis: 100%;
    justify-content: space-evenly;
}

#address-flex-box {
    grid-area: address;
    display: flex;
    flex-direction: column;
    flex-basis: 100%;
    justify-content: center;
    align-items: center;
}

#city-state-zip-flex-box {
    grid-area: city-state-zip;
    display: flex;
    flex-basis: 100%;
    justify-content: space-evenly;
    align-items: center;
}

#contact-flex-box {
    grid-area: contact;
    display: flex;
    flex-basis: 100%;
    justify-content: space-evenly;
    align-items: center;
}

#button {
    grid-area: button;
    justify-content: center;
    align-items: center;
}

label {
    padding: 5pt;
    display: block;
}

input {
    height: 15px;
    padding: 7px;
    border-style: none;
    border-radius: 3px;
    outline: none;
}

#first-name-input-box {
    width: 250px;
}

#last-name-input-box {
    width: 250px;
}

#address1-input-box {
    width: 700px;
}
</style>