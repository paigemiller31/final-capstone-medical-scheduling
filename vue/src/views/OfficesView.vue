<template>
    <div v-for="o in this.officeList" v-bind:key="o.officeId"> "This is a office: " {{ o.officeName }} </div>
    <!--list of offices, officeName only-->

    <div v-for="d in this.doctorList" v-bind:key="d.doctorId"> "This is a doctor: " {{ d.firstName }} </div>
    <!--one doctor, first name-->

    <div v-for="office in this.officeList" v-bind:key="office.id"> "This is a office: " {{ office }} </div>
    <!--list of offices, all parts-->

    <div v-for="doctor in this.doctorList" v-bind:key="doctor.id"> "This is a doctor: " {{ doctor }} </div>
    <!--one doctor, all parts-->



        <!--<div v-for="office in this.officeList" v-bind:key="office.id"> "this is a LIST of offices: " {{ office }} </div>-->

        <!--<div v-for="office in office" v-bind:key="office.id"> "This is a office: " {{ office }} </div>-->

        <div v-for="office in this.office" v-bind:key="office.id">  {{ office.officeName }} </div> 
        
        <div v-for="office in this.office" v-bind:key="office.id">  {{ office.addressLine1 }} </div>

        <div v-for="doctor in this.doctorList" v-bind:key="doctor.id"> "This is LIST of doctors: " {{ doctor }} </div>






    <h1 v-if="$store.state.user.authorities[0].name === 'ROLE_DOCTOR'"> Only doctor can Update </h1>

    <div>
        <!-- <offices/> -->
        <offices v-bind:office="office" />
    </div>
</template>

<script>

import OfficeService from '../services/OfficeService';
// import Offices from '../components/Offices.vue';

export default {
    components: {
        // Offices,
    },
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

            doctor: {
                doctorId: '',
                officeId: '',
                firstName: '',
                lastName: '',
                specialization: '',
                costPerHour: '',
            },

            officeList: [],

            doctorList: []

        };
    },
    computed: {

        //     addDoctors(id) {
        //         let filterDoctors = this.doctorList.filter ( // filter by office id from line 3  doctorList arry ) )

        //   //      return filterDoctors ;
        //     }

    },
    methods: {


        // VIVEK'S OG
        listOffices() {
            OfficeService.getOffices()
                .then(response => { // 
                    if (response.status === 200) {
                        this.officeList = response.data;
                        this.officeList.forEach(element => {
                            OfficeService.getDoctorsByOfficeId(element.officeId)
                                .then(response => {
                                    this.doctorList = response.data;
                                })
                        });
                    }
                })
        },




        /*  // VIVEK'S OTHER ONE, I GUESS

                listOffices() { 
                    OfficeService.getOffices()
                        .then(response => {
                            if (response.status === 200) {
                                this.office = response.data;
                                this.officeList.unshift(this.office);
                                this.office.forEach(element => {
                                    OfficeService.getDoctorsByOfficeId(element.officeId)
                                        .then(response => {
                                            this.doctor = response.data;
                                            this.doctorList.unshift(response.data);
                                        })
                                });
                            }
                        })
                        .catch(error => {
                            this.handleErrorResponse(error);
                        });
                },
        */



        // PAIGE'S DUMMY
        /*
        listOffices() {
    
                // getting a list of offices
                OfficeService.getOffices()
                    .then(response => {
                        if (response.status === 200) {
                            this.office = response.data;
                            this.officeList.unshift(this.office); // adding office to the beginning of the array
    
                            // getting a list of doctors
                            this.office.forEach(element => {
                                OfficeService.getDoctorsByOfficeId(element.officeId)
                                    .then(response => {
                                        this.doctor = response.data;
                                        this.doctorList.unshift(response.data);
                                    })
                            });
                        }
                    })
                    .catch(error => {
                        this.handleErrorResponse(error);
                    });
            },
        */

        // PAIGE'S DUMMY
        getOfficeByOfficeId(officeId) {
            OfficeService.getOfficeByOfficeId(officeId)
                .then(response => {
                    if (response.status == 200) {
                        this.office.officeId = response.data;
                        this.office.officeName = response.data;
                        this.office.officeAddressLine1 = response.data;
                    }
                    

                })
                .catch(error => {
                    this.handleErrorResponse(error);
                });
        },



        // VIVEK'S
        /*
        getOfficeByOfficeId(officeId) {
            OfficeService.getOfficeByOfficeId(officeId)
                .then(response => {
                    if (response.status == 200) {
                        this.office = response.data;
                    }
                })
                .catch(error => {
                    this.handleErrorResponse(error);
                });

        }, 
        */





        handleErrorResponse(error) {
            if (error.response.status == 404) {
                this.$router.push({ name: 'NotFoundView' });
            } else {
                this.isLoading = false;
                this.$store.commit('SET_NOTIFICATION', `Could not get message data from server.`);
            }
        }

    },
    created() {
        this.listOffices();
        this.getOfficeByOfficeId(this.$route.params.officeId);
    },
}
</script>


<style></style>