<template>
    <div>       
         <div v-for="o in this.officeList" v-bind:key="o.officeId" > "This is a office: "  {{o.officeName}}    
    
         <div v-for="d in this.doctorList" v-bind:key="d.doctorId" >  "This is a doctor: " {{d.firstName }} </div>  </div>   

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
    computed:{

    //     addDoctors(id) {
    //         let filterDoctors = this.doctorList.filter ( // filter by office id from line 3  doctorList arry ) )
            
    //   //      return filterDoctors ;
    //     }

    },
    methods: {
        listOffices() {  
            OfficeService.getOffices() 
            .then(response => {
                if (response.status === 200) {
                this.officeList = response.data;
            
                this.officeList.forEach(element => { 

                        OfficeService.getDoctorsByOfficeId( element.officeId )
                        .then(response => {
                            this.doctorList = response.data;                      
                               
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