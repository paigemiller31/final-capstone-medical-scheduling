<template>

<h1 v-if="$store.state.user.authorities[0].name === 'ROLE_DOCTOR'"> Only doctor can Update </h1>

    <div>       
        <div v-for="o in this.officeList" v-bind:key="o.officeId" >
            *************
            **** Hospital Details ****
            *************
            <li>{{o.officeName}}</li>
            <li>{{o.addressLine1}}</li>
            <!-- <li>{{o.addressLine2}}</li> -->
            <li>{{o.city}}, {{o.state}} {{o.zipCode}}</li>
            <!-- <li>{{o.state}}</li> -->
            <!-- <li>{{o.zipCode}}</li> -->
            <li>{{o.phoneNumber}}</li>
            <li>{{o.email}}</li>
            <li>{{o.officeHours}}</li>
                   
        <div v-for="d in this.filterDoctors(o.officeId)" v-bind:key="d.doctorId" > 
            
            ****** List of Doctors available ******

            <li>{{d.firstName}} {{d.lastName}}</li>
            <!-- <li>{{ d.lastName }}</li> -->
            <li>{{d.specialization}}</li>
            <li>${{d.costPerHour}}.00 per hour</li>

          </div>    </div> 
             
        
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
    computed:{

        
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
                            this.doctor = response.data;  
                            this.doctorList.push(this.doctor);
                            
                        
                               
                         })                       
                    });             
             
                }
            })                      
        },
        filterDoctors(officeID) {

            let filterDoctors = this.doctorList;
            let  ddd = [];
          
             for (let i = 0; i <  filterDoctors.length; i++) {
                for (let j = 0; j < filterDoctors[i].length; j++) {
                        if(  filterDoctors[i][j].officeId === officeID ){
                            ddd.push(filterDoctors[i][j] );
                        }
                    }
                } 
            
         return ddd ;
        }
        
        
    },
    created() {
        this.listOffices();
    
    }
}
</script>


<style> </style>