<template>
    <body>
        <div class="home">
            <div class="form-body">

                <h1 class="main-header">Offices</h1>


                <div>
                    <div v-for="o in this.officeList" v-bind:key="o.officeId">
                        *************
                        **** Hospital Details ****
                        *************
                        <li>{{ o.officeName }}</li>
                        <li>{{ o.addressLine1 }}</li>
                        <li>{{o.addressLine2}}</li>
                        <li>{{ o.city }}, {{ o.state }} {{ o.zipCode }}</li>
                        <!-- <li>{{o.state}}</li> -->
                        <!-- <li>{{o.zipCode}}</li> -->
                        <li>{{ o.phoneNumber }}</li>
                        <li>{{ o.email }}</li>
                        <li>{{ o.officeHours }}</li>

                        <div v-for="d in this.filterDoctors(o.officeId)" v-bind:key="d.doctorId">

                            ****** List of Doctors available ******

                            <li>{{ d.firstName }} {{ d.lastName }}</li>
                            <!-- <li>{{ d.lastName }}</li> -->
                            <li>{{ d.specialization }}</li>
                            <li>${{ d.costPerHour }}.00 per hour</li>

                        </div>
                    </div>

                    <ul id="update-button" v-if="$store.state.user.authorities[0].name === 'ROLE_DOCTOR'">
                        <li v-for="office in officeList" v-bind:key="office.officeId">
                            <router-link v-bind:to="{ path: '/offices/' + office.officeId + '/edit' }">
                                <button v-bind:officeId="office.officeId">Update</button>
                            </router-link>
                        </li>
                    </ul>

                    <!--
        <div v-if="$store.state.user.authorities[0].name === 'ROLE_DOCTOR'">
            <button v-for="office in officeList" v-bind:office="office" v-bind:key="office.officeId" v-on:click.prevent="$router.push('/office/:officeId/edit')">UPDATE</button>
        </div>
        -->

                </div>





            </div>
        </div>
    </body>
</template>

<script>

import OfficeService from '../services/OfficeService';

export default {
    components: {

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


    },
    methods: {
        listOffices() {
            OfficeService.getOffices()
                .then(response => {
                    if (response.status === 200) {
                        this.officeList = response.data;

                        this.officeList.forEach(element => {

                            OfficeService.getDoctorsByOfficeId(element.officeId)
                                .then(response => {
                                    this.doctor = response.data;
                                    this.doctorList.push(this.doctor);



                                })
                        });

                    }
                })
        },
        filterDoctors(officeID) {

            let filterDoctors = this.doctorList;
            let ddd = [];

            for (let i = 0; i < filterDoctors.length; i++) {
                for (let j = 0; j < filterDoctors[i].length; j++) {
                    if (filterDoctors[i][j].officeId === officeID) {
                        ddd.push(filterDoctors[i][j]);
                    }
                }
            }

            return ddd;
        },

        /* THIS IS NONSENSE. IGNORE IT.
        updateOfficeFilter() {
            return this.officeList.filter((office) => {
                return office.officeId === true;
            });
        },
        */


    },
    created() {
        this.listOffices();

    }
}
</script>


<style scoped>
* {
    font-family: Arial, Helvetica, sans-serif;
    color: #000000;
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