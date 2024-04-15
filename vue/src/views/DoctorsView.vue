<template>
    <div class="">

        ****** List of Doctors available ******

<li>{{ d.firstName }} {{ d.lastName }}</li>
<!-- <li>{{ d.lastName }}</li> -->
<li>{{ d.specialization }}</li>
<li>${{ d.costPerHour }}.00 per hour</li>

    </div>
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
    },
    created() {
        this.listOffices();
    }
}
</script>
    
<style></style>