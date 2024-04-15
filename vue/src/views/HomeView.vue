<template>
  <div class="home">
    <div class="form-body">

      <div id="logo-component">
        <img src="src\assets\logo.png">
      </div>
      <article id="info-component">
        <p>For Patients:</p>

        <br>- Effortless Scheduling: Find the right doctor, view their availability, and book appointments directly - all in one place.
        <br>- Improved Access to Care: Eliminate phone calls and schedule appointments at your convenience.

        <p>For Doctors:</p>

        <br>- Centralized Management: Manage your schedule seamlessly and receive real-time appointment notifications.
        <br>- Increased Patient Satisfaction: Offer convenient online booking, reducing phone traffic and wait times.

        <p>Secure, efficient scheduling for doctors and patients. Sign up and simplify your healthcare experience today!</p>
      </article>

    </div>

  </div>
</template>

<script>
export default {

/*
 * USE THIS MOUNTED LIFECYCLE HOOK TO PUSH USERS TO LOGIN IF THEY AREN'T LOGGED IN*
 * --> TOTALLY OPTIONAL BECAUSE SHELBY TOLD ME SHE DIDN'T WANT THIS (AND THEN PAIGE DEFENDED HER(AND THEY WERE BOTH RIGHT(AS USUAL)))<--
 */

/* mounted() {

    if(this.$store.state.token == ''){
    this.$router.push('login');
    }
  }
*/

}; 
</script>

<style scoped>
.form-body {
    display: grid;
    grid-template-columns: 1fr 1fr;
    grid-template-areas:
      'logo info';
    background-color: rgba(219, 219, 219, 0.5);
    margin-top: 50px;
    margin-bottom: 50px;
    margin-left: 70px;
    margin-right: 70px;
    padding-right: 100px;
    padding-left: 100px;
    padding-top: 50px;
}

#logo-component {
  grid-area: logo;
  padding: 100px;

}

#info-component {
  grid-area: info;
  padding: 20px;
}

</style>
