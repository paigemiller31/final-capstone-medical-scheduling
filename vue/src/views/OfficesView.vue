<template>
    <div>
        
         <div  v-for="o in this.office" v-bind:key="o.id" > "This is a office: {{o.officeName}}"  {{o}}  </div>    
    
         <div  v-for="d in this.doctor" v-bind:key="d.id" > "This is a doctor: {{d.doctorId}}"   {{d}}  </div> 
 <!-- role doctor only see update button
    it take them to new office update view
  -->

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

            doctor:{
                doctorId : '',
                officeId : '',
                firstName : '',
                lastName : '',
                specialization: '',
                costPerHour : '',
            }

        };
    },
    methods: {
        listOffices() {  
            OfficeService.getOffices() 
            .then(response => {
                if (response.status === 200) {
                this.office = response.data;
          ///  for loop office 
                OfficeService.getDoctorsByOfficeId( this.office[0].officeId )
                .then(response => {
                        this.doctor = response.data;            
                    })               
                }
            })                      
        }, 
        
        
    },
     created() {
        this.listOffices();
      
     },



}
</script>


<style>


</style>