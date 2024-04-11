<template>

    <div class="main-grid-container">
      
        <div class="transparent-box-grid"> 
  
            <div id="patient-registration-component"  class="container  transparent-box-grid"> 
               
                <div class="header-grid">

                      <h2 id="patient-registration-header">Patient &nbsp; Registration</h2>
        
                 </div>

                <form class="row g-6"  >

                     <div class="col-md-6">
                            <label for="firstName" class="form-label">First name</label>
                            <input type="text" class="form-control" id="firstName" v-model="patient.firstName" required>
                     </div>

                     <div class="col-md-6">
                            <label for="lastName" class="form-label">Last name</label>
                            <input type="text" class="form-control" id="lastName" v-model="patient.lastName" required>
                     </div>
                 
                     <div class="col-md-6">
                            <label for="phoneNumber" class="form-label">PhoneNumber</label>
                            <input type="text" class="form-control" id="phoneNumber" v-model="patient.phoneNumber" required>
                     </div>

                     <div class="col-md-6">
                            <label for="Email" class="form-label">Email</label>
                            <input type="text" class="form-control" id="Email" v-model="patient.email" required>
                     </div>

                     <div class="col-md-6">
                            <label for="Address1" class="form-label"> Address Line 1 </label>
                            <input type="text" class="form-control" id="Address1"  v-model="patient.addressLine1" required>
                     </div>

                     <div class="col-md-6">
                            <label for="Address2" class="form-label"> Address Line 2 </label>
                            <input type="text" class="form-control" id="Address2" v-model="patient.addressLine2" required>
                     </div>

                     <div class="col-md-4">
                            <label for="City" class="form-label">City</label>
                            <input type="text" class="form-control" id="City"  v-model="patient.city"  required>
                     </div>

                     <div class="col-md-4">
                            <label for="State" class="form-label">State</label>
                            <input type="text" class="form-control" id="State"  v-model="patient.state"  required>
                     </div> 

                     <div class="col-md-4">
                            <label for="ZipCode" class="form-label">ZipCode</label>
                            <input type="text" class="form-control" id="ZipCode" v-model="patient.zipCode"  required>
                     </div>
                   
                     <div class="col-md-12" id = "submit-button">
                            <h1> </h1>   
      
                            <button class="btn btn-primary" type="submit" v-on:click.prevent="submitPatientForm()" > Submit form  </button>                         
                     </div>
                              
                 </form>

            </div>  

        </div> 

  </div> 
 
</template>

<script>

import RegisterUserService from '../services/RegisterUserService';

export default {
    components: {
        //RegisterUserService,
    },
    data() {
        return {
            patient: {
                patientId: this.$store.state.user.id,
                firstName: '',
                lastName: '',
                addressLine1: '',
                addressLine2: '',
                city: '',
                state: '',
                zipCode: '',
                phoneNumber: '',
                email: '',
            },


        };
    },
    methods: {

        submitPatientForm() {

       
            // if (!this.validatePatientForm()) {
            //     return;
            // }
            // ^^^ FIX VALIDATE PATIENT FORM later (OR) implement in BOOTSTRAP
 

            if (this.$store.state.user.id !== 0) {
                
                RegisterUserService.registerPatient(this.patient)
                    .then(response => {
                        if (response.status === 201) { 
                   
                            this.$router.push('/');
                            alert( "test sucess");                          
                        }
                    })
                    .catch(error => {
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

            this.patient.firstName = this.patient.firstName.trim();
            if (this.patient.firstName.length === 0) {
                alert += "First name is required for registration";
            }

            this.patient.lastName = this.patient.lastName.trim();
            if (this.patient.lastName.length === 0) {
                alert += "Last name is required for registration";
            }

            this.patient.addressLineOne = this.patient.addressLineOne.trim();
            if (this.patient.addressLineOne.length === 0) {
                alert += "Address is required for registration";
            }

            this.patient.addressLineTwo = this.patient.addressLineTwo.trim();

            this.patient.city = this.patient.city.trim();
            if (this.patient.city.length === 0) {
                alert += "City is required for registration";
            }

            this.patient.state = this.patient.state.trim();
            if (this.patient.state.length === 0) {
                alert += "State is required for registration";
            }

            this.patient.zipCode = this.patient.zipCode.trim();
            if (this.patient.zipCode.length === 0) {
                alert += "Zip code is required for registration";
            }

            this.patient.phoneNumber = this.patient.phoneNumber.trim();
            if (this.patient.phoneNumber.length === 0) {
                alert += "Phone number is required for registration";
            }

            this.patient.emailAddress = this.patient.emailAddress.trim();
            if (this.patient.emailAddress === 0) {
                alert += "Email address is required for registration";
            }

            if (alert.length > 0) {
                this.$store.commit('SET_NOTIFICATION', alert);
                return false;
            }
            return true;
        }
    }
};
</script>

<style >
.main-grid-container {
    display: grid;
    grid-template-columns: 1fr 40fr 1fr;
    grid-template-rows: 1fr 1fr 1fr;
    grid-template-areas:
        ". . ."
        ". transparent-box-grid ."
        ". . ."
    ;
    font-family: Arial, Helvetica, sans-serif;
    height: 90vh;
}

.transparent-box-grid {
    grid-area: transparent-box-grid;
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    grid-template-rows: 1fr 1fr 1fr;
    grid-template-areas:
        ". header ."
        ". input-container ."
        ". submit ."
    ;
}

#input-container {
    grid-area: input-container;
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    align-items: center;
    padding: 50px;
}

.button-grid {
    grid-area: submit;
}

.header-grid {
    grid-area: header;
}

/* #patient-registration-header {
    display: flex;
    text-transform: uppercase;
    margin-top: 30px;
} */

#patient-registration-header {
    display: flex;
    text-transform: uppercase;
    margin-top: 30px;
    padding: 5pt;
    display: block;
}


#patient-registration-component {
    display: grid;
    grid-area: transparent-box-grid;
    display: flex;
    flex-wrap: wrap;
    background-color: rgb(201, 201, 201, 0.5);
    justify-content: center;
    width: 60%;
    justify-self: center;
}

#name-flex-box {
    display: flex;
    flex-basis: 100%;
    justify-content: space-evenly;
}

#address-flex-box {
    display: flex;
    flex-direction: column;
    flex-basis: 100%;
    justify-content: center;
    align-items: center;

}

#city-state-zip-flex-box {
    display: flex;
    flex-basis: 100%;
    justify-content: space-evenly;
    align-items: center;
}

#contact-flex-box {
    display: flex;
    flex-basis: 100%;
    justify-content: space-evenly;
    align-items: center;
}

#button {
    justify-content: center;
    align-items: center;
    margin-bottom: 50px;
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
</style>












<!--

<template>
    <body>
    <div class="container">

        <div class="patient-registration-component">

            <h1 id="header">Patient Registration</h1>

            <div id="input-container">

                    <header>First Name</header>
                    <div class="form-input-group">
                        <input type="text" class="register-input-box" v-model="patient.firstName" required autofocus />
                    </div>


                    <header>Last Name</header>
                    <div class="form-input-group">
                        <input type="text" class="register-input-box" v-model="patient.lastName" required autofocus />
                    </div>


                    <header>Address</header>
                    <div class="form-input-group">
                        <input type="text" class="register-input-box" v-model="patient.addressLineOne" required autofocus />
                    </div>
                    <div class="form-input-group">
                        <input type="text" class="register-input-box" v-model="patient.addressLineTwo" required autofocus />
                    </div>


                    <header>City</header>
                    <div class="form-input-group">
                        <input type="text" class="register-input-box" v-model="patient.city" required autofocus />
                    </div>

                    <header>State</header>
                    <div class="form-input-group">
                        <input type="text" class="register-input-box" v-model="patient.state" required autofocus />
                    </div>


                    <header>Zip Code</header>
                    <div class="form-input-group">
                        <input type="text" class="register-input-box" v-model="patient.zipCode" required autofocus />
                    </div>
   

                    <header>Phone Number</header>
                    <div class="form-input-group">
                        <input type="text" class="register-input-box" v-model="patient.phoneNumber" required autofocus />
                    </div>


                    <header>Email Address</header>
                    <div class="form-input-group">
                        <input type="text" class="register-input-box" v-model="patient.emailAddress" required autofocus />
                    </div>

            </div>

        </div>

        <div class="submit-button-component">

            <button id="button" type="submit" v-on:click="submitPatientForm()">Submit</button>

        </div>

    </div>

    
</body>

    <patient-registration v-bind:patient="patient" />
</template>

<style scoped>
.container {
    display: grid;
    grid-template-columns: 1fr 2fr 1fr;
    grid-template-rows: 1fr 2fr 1fr;
    grid-template-areas:
        ". . ."
        ". register ."
        ". login ."
    ;
    height: 90vh;
}

.patient-registration-component {
    grid-area: register;
    justify-content: center;
    align-items: center;
    display: flex;
    flex-direction: column;
    margin-bottom: 150px;
}

.submit-button-component {
    grid-area: login;
    align-items: center;
    justify-content: end;
    display: flex;
    flex-direction: column;
}

body {
    font-family: Arial, Helvetica, sans-serif;
    font-size: 11pt;
    letter-spacing: .2pt;
    text-shadow: 0.1px 0.1px 0.1px;
}

.form-input-group {
    margin-bottom: 2rem;
}

#header {
    margin-bottom: 2rem;
    font-family: Arial, Helvetica, sans-serif;
    font-weight: 100;
    font-size: 22pt;
    text-transform: uppercase;
}

input::placeholder {
    font-family: Arial, Helvetica, sans-serif;
    font-size: 7pt;
    color: rgb(210, 210, 210);
}

#button {
    font-family: Arial, Helvetica, sans-serif;
    font-size: 8pt;
    text-transform: uppercase;
    letter-spacing: 3pt;
    background-color: transparent;
    border-style: none;
    border-bottom: solid 1px #000000;
    padding: .1rem;
}

#button:hover {
    cursor: pointer;
}

.button-alignment {
    display: flex;
    justify-content: center;
    align-items: center;
}

.register-input-box {
    width: 250px;
    height: 20px;
    padding: 7px;
    border-style: none;
    border-radius: 3px;
    outline: none;
}

#invalid-entry {
    justify-content: center;
    align-items: center;
    display: flex;
    flex-direction: column;
}
</style>

-->