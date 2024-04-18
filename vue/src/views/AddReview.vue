<template>
    <body>
        <section id="registration-page">
            <form class="signup-form">

                <div class="form-body">

                    <div class="row">

                       
                            <header class="add-a-review">Add a Review</header>
                            <textarea class="review-input-box" v-model="editOffice.review" autocomplete="off"
                                required autofocus></textarea>
                        
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
                review: '',
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

.add-a-review {
    font-size: 17px;
    margin-bottom: 15px;
}

#registration-page {
    /* background-color: lightcoral; */
    max-height: 500px;
    display: flex;
    justify-content: center;
    align-items: center;
}

.form-body {
    margin-top: 220px;
    margin-bottom: 20px;
    margin-left: 70px;
    margin-right: 70px;
    padding-right: 100px;
    padding-left: 100px;
    padding-top: 70px;
    background-color: rgba(219, 219, 219, 0.5);
}

.review-input-box {
    display: flex;
    justify-content: center;
    width: 500px;
    height: 100px;
    border-style: none;
    border-radius: 3px;
    outline: none;
}

input[type="text"] {
    display: flex;
    flex-wrap: wrap;
    justify-content: flex-start;
    align-items: start;
    font-size: 12px;
    font-family: Arial, Helvetica, sans-serif;
    padding-left: 10px;
    padding-right: 10px;
    color: #4e4e4e;
    padding: 10px;
    border-style: none;
    border-radius: 3px;
    outline: none;
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
}

@media only screen and (max-width: 500px) {
    .row {
        flex-direction: column;
    }

    .btn {
        flex: 1;
    }
}
</style>