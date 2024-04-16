<template>
    <body>
        <section id="registration-page">
            <form class="signup-form">

                <div class="form-body">
                    <div class="row">

                        <div class="input-group">
                            <label>ADD review</label>
                            <input type="text" id="email-address-input-box" v-model="editOffice.review" required
                                autofocus />
                        </div>
                    </div>

                    <div id="submit-button">
                        <button class="btn" type="submit" v-on:click.prevent="submitForm()">Submit</button>
                    </div>

                </div>

            </form>
        </section>
    </body>
</template>

<script>

import OfficeService from '../services/OfficeService.js';

export default {
    data() {
        return {
            office: {
                officeId: '',
                officeName: '',
                addressLine1: '',
                addressLine2: '',
                city: '',
                state: '',
                zipCode: '',
                phoneNumber: '',
                email: '',
                officeHours: '',
            },
            editOffice: {
                officeId: '',
                review:'',
            },

        }
    },
    methods: {

        accessOffice(officeId) {

            this.editOffice.officeId = this.$route.params.officeId;
    
            // OfficeService.getOfficeByOfficeId(officeId)
            //     .then(response => {
            //         this.editOffice = response.data
            //     })
        },

        submitForm() {
                 this.editOffice.officeId = this.$route.params.officeId;
                OfficeService.addNewReviewByOfficeId(this.editOffice)
                    .then(response => {
                        if (response.status === 201) {
                            this.$router.push({ name: 'offices' });
                        }
                    })
        }
    },
    created() {

        this.accessOffice(this.$route.params.officeId);
    }
}
</script>

<style scoped>
* {
    margin: 0;
    font-family: Arial, Helvetica, sans-serif;
}

html,
body {
    height: 90vh;
}

#registration-page {
    /* background-color: lightcoral; */
    max-height: 500px;
    display: flex;
    justify-content: center;
    align-items: center;
}

.signup-form {
    flex: 1;
    max-height: 500px;
    max-width: 900px;
    /* background-color: aliceblue; */
    margin-top: 350px;
    margin-bottom: 300px;
}

.form-header {
    padding: 20px 0;
}

.form-header h1 {
    font-size: 28px;
    text-align: center;
    color: #000000;
    font-family: Arial, Helvetica, sans-serif;
    font-weight: 100;
    font-size: 22pt;
    text-transform: uppercase;
    padding-left: 20px;
}

.form-body {
    margin-top: 50px;
    margin-bottom: 50px;
    margin-left: 70px;
    margin-right: 70px;
    padding-right: 100px;
    padding-left: 100px;
    padding-top: 50px;
    background-color: rgba(219, 219, 219, 0.5);
}

.row {
    display: flex;
    flex-direction: row;
}

.input-group {
    flex: 1;
    display: flex;
    flex-direction: column;
    height: 10px;
    margin: 10px 5px;
    padding-bottom: 30px;
    padding-left: 17px;
    padding-right: 17px;
}

label {
    font-size: 11px;
    font-weight: 500;
    color: #000000;
    padding-bottom: 6px;
}

input[type="text"] {
    font-size: 12px;
    font-family: Arial, Helvetica, sans-serif;
    padding-left: 10px;
    padding-right: 10px;
    color: #4e4e4e;
    height: 15px;
    padding: 7px;
    border-style: none;
    border-radius: 3px;
    outline: none;
}

#city-input-box,
#state-input-box,
#zip-code-input-box {
    width: 128px;
}

@media only screen and (max-width: 500px) {
    .row {
        flex-direction: column;
    }
}

.btn {
    font-family: Arial, Helvetica, sans-serif;
    font-size: 8pt;
    text-transform: uppercase;
    letter-spacing: 3pt;
    background-color: transparent;
    border-style: none;
    border-bottom: solid 1px #000000;
    margin-top: 50px;
    margin-bottom: 70px;
    cursor: pointer;
}

#submit-button {
    display: flex;
    justify-content: center;
}

@media only screen and (max-width: 500px) {
    .row {
        flex-direction: column;
    }

    .btn {
        flex: 1;
    }
}</style>