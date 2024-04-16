<template>
    <body>
        <div class="home">
            <div class="form-body">
                <div class="doctors-info-row">
                    <doctor v-for="doctor in doctorList" v-bind:key="doctor.doctorId" v-bind:doctor="doctor" />
                </div>






                <!-- <ul id="update-button" v-if="$store.state.user.authorities[0].name === 'ROLE_USER'">
                        ****** For patients to VIEW DOCTORS for OFFICES ******
                        <li v-for="office in officeList" v-bind:key="office.officeId">
                            <router-link v-bind:to="{ path: '/offices/' + office.officeId + '/doctors' }">
                                <button v-bind:officeId="office.officeId">View Doctors for this Office</button>
                            </router-link>
                        </li>
                     -->







                <!--
        <div v-if="$store.state.user.authorities[0].name === 'ROLE_DOCTOR'">
            <button v-for="office in officeList" v-bind:office="office" v-bind:key="office.officeId" v-on:click.prevent="$router.push('/office/:officeId/edit')">UPDATE</button>
        </div>
        -->


            </div>
        </div>
    </body>
</template>

<script>

import OfficeService from '../services/OfficeService';
import Doctor from '../components/Doctor.vue';

export default {
    components: {
        Doctor
    },
    data() {
        return {
            doctorList: [],
        };
    },
    methods: {
        listDoctors(office) {
            //alert(office.officeId);
            OfficeService.getDoctorsDeep(office.officeId).then((response) => {
                if (response.status === 200) {
                    this.doctorList = response.data;
                }
            })
        },
        accessDoctor(officeId) {
            //alert(officeId);
            OfficeService.getDoctorsDeep(officeId)
                .then(response => {
                    if (response.status === 200) {
                        //alert(response.data);
                        this.doctorList = response.data;
                    }
                })
        },
    },
    created() {
        //alert(this.$route.params.officeId)
        //this.listDoctors(this.$route.params.officeId);
        this.accessDoctor(this.$route.params.officeId);
    }
}
</script>


<style scoped>
* {
    font-family: Arial, Helvetica, sans-serif;
    color: #000000;
}

.doctors-info-row {
    display: flex;
    justify-content: space-evenly;
}

body {
    overflow: hidden;
}

.main-header {
    text-transform: uppercase;
    text-justify: center;
    text-align: center;
    padding-top: 25px;
    font-weight: 100;
    font-size: 25pt;
}

.form-body {
    background-color: rgba(219, 219, 219, 0.5);
    margin-top: 75px;
    margin-bottom: 50px;
    margin-left: 30px;
    margin-right: 70px;
    width: 100vh
}
</style>