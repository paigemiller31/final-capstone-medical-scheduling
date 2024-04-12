<template>
    <div>
        {{ this.office }}
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
            }
        };
    },
    methods: {
        listOffices() {
            OfficeService.getOffices() 
            .then(response => {
                this.office = response.data;
            })
        },
    },
    created() {
        this.listOffices();
    }

}
</script>


<style></style>