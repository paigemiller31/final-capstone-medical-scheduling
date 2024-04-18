<template>
    <body>
        <div class="home">

            <div class="form-body">

                <h1 class="main-header">Reviews</h1>

                <ul id="update-button">
                    <div class="doctors-info-column">
                        <review v-for="review in reviewsList" v-bind:key="review.reviewId" v-bind:review="review" />
                    </div>

                    <div id="appointment-button">
                        <button class="btn" type="submit" v-on:click.prevent="submitForm()">Back to
                            Offices</button>
                    </div>

                </ul>

                <!-- <div class="appointment-button">
      
      <router-link class= "router-link"
       v-bind:to="{ name: 'addReview', params: { officeId: this.$route.params.officeId } }">
       <button id="update-office-btn" v-bind:officeId="office.officeId">Add review</button>
 
      </router-link>
</div> -->

                <!-- <ul id="update-button" v-if="$store.state.user.authorities[0].name === 'ROLE_USER'">
        ****** For patients to VIEW DOCTORS for OFFICES ******
        <li v-for="office in officeList" v-bind:key="office.officeId">
            <router-link v-bind:to="{ path: '/offices/' + office.officeId + '/doctors' }">
                <button v-bind:officeId="office.officeId">View Doctors for this Office</button>
            </router-link>
        </li>

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
import Review from '../components/Review.vue';

export default {
    components: {
        Review
    },
    data() {
        return {
            reviewsList: [],
        };
    },
    methods: {

        accessReviews(officeId) {
            //alert(officeId);
            OfficeService.getReviewsByOfficeId(officeId)
                .then(response => {
                    if (response.status === 200) {
                        // alert(response.data);
                        this.reviewsList = response.data;
                    }
                })
        },

        submitForm() {

            this.$router.push({ name: 'offices' });

        }
    },
    created() {
        //alert(this.$route.params.officeId)
        //this.listDoctors(this.$route.params.officeId);
        this.accessReviews(this.$route.params.officeId);
    }
}
</script>


<style scoped>
* {
    font-family: Arial, Helvetica, sans-serif;
    color: #000000;
}

.main-header {
    text-transform: uppercase;
    text-justify: center;
    text-align: center;
    padding-top: 40px;
    font-weight: 100;
    font-size: 26pt;
    margin-bottom: 40px;
    letter-spacing: .1rem;
}

.doctors-info-column {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-right: 50px;
}

/* .router-link {
    text-decoration: none;
    color: black;
    border: solid 1px rgb(190, 189, 189);
    border-radius: 4px;
    font-size: 13px;
    text-align: center;
    padding: 5px;
    background-color: rgb(207, 207, 207);
    letter-spacing: .05rem;
    height: 30px;
    width: 125px;
} */

.btn {
    font-family: Arial, Helvetica, sans-serif;
    font-size: 8pt;
    text-transform: uppercase;
    letter-spacing: 3pt;
    background-color: transparent;
    border-style: none;
    border-bottom: solid 1px #000000;
    margin-top: 50px;
    margin-bottom: 70px;
    cursor: pointer;
}

#appointment-button {
    display: flex;
    justify-content: center;
    align-items: center;
}

body {
    overflow: hidden;
}

.home {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    grid-template-areas:
        ". reviews ."
    ;
}

.form-body {
    grid-area: reviews;
    background-color: rgba(219, 219, 219, 0.5);
    margin-top: 75px;
    margin-bottom: 50px;
    margin-left: 30px;
    margin-right: 70px;
    width: 100vh;
    padding-left: 100px;
    padding-right: 100px;
}

.bio-section {
    display: flex;
}
</style>