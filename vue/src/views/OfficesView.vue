<template>
    <div>       
         <div v-for="o in this.officeList" v-bind:key="o.id" > "This is a office: "  {{o}}  </div>    
    
         <div v-for="d in this.doctorList" v-bind:key="d.id" >  "This is a doctor: " {{d}}  </div>

         <h1  v-if="$store.state.user.authorities[0].name ===  'ROLE_DOCTOR'"  > Only doctor can Update </h1>
         
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
            },

            officeList:[],
            
            doctorList:[]

        };
    },
    methods: {
        listOffices() {  
            OfficeService.getOffices() 
            .then(response => {
                if (response.status === 200) {
                this.office = response.data;
                this.officeList.unshift( this.office);  

                this.office.forEach(element => { 

                        OfficeService.getDoctorsByOfficeId( element.officeId )
                        .then(response => {
                            this.doctor = response.data;                      
                            this.doctorList.unshift( response.data);         
                         })  
                      
                    });

                  
             
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