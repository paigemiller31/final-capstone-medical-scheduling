<template>
    <div>

        <div v-for="office in this.officeList" v-bind:key="office.id"> "This is a office: " {{ office }} </div>

        <div v-for="doctor in this.doctorList" v-bind:key="doctor.id"> "This is a doctor: " {{ doctor }} </div>

        <h1 v-if="$store.state.user.authorities[0].name === 'ROLE_DOCTOR'"> Only doctor can Update </h1>
        
        
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
    methods: {
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
        // we need this method to get itemized/separated office things, like office.officeName, office.phoneNumber, etc.
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