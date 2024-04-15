<template>
  <div class="home">
    
    <div class="form-body">

      <h1 class="main-header">Medical Scheduling Group</h1>
      
      <div id="logo-component">
        <img src="src\assets\home.JPG">
      </div>
      <article id="info-component">
        <h2 class="header">For Patients:</h2>

        <section class="info">
          - Effortless Scheduling: Find the right doctor, view their availability, and book appointments directly -
          all in one place.
          <br>- Improved Access to Care: Eliminate phone calls and schedule appointments at your convenience.
        </section>

          <h2 class="header">For Doctors:</h2>

        <section class="info">
          - Centralized Management: Manage your schedule seamlessly and receive real-time appointment notifications.
          <br>- Increased Patient Satisfaction: Offer convenient online booking, reducing phone traffic and wait times.
        </section>
        <p>Secure, efficient scheduling for doctors and patients. Sign up and simplify your healthcare experience today!
        </p>
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
* {
  font-family: Arial, Helvetica, sans-serif;
  color: black;
}

.main-header {
  grid-area: header;
  text-transform: uppercase;
  text-justify: center;
  text-align: center;
  padding-top: 10px;
  font-weight: 100;
  font-size: 25pt;
}

.header {
  font-size: 18px;
  font-weight: 500;
}

.info {
  font-size: 14px;
}

.form-body {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas:
    'header header'
    'logo info';
  background-color: rgba(219, 219, 219, 0.5);
  margin-top: 50px;
  margin-bottom: 50px;
  margin-left: 30px;
  margin-right: 70px;
  height: 90vh;
  
}

#logo-component {
  grid-area: logo;
  padding: 50px;

}

#info-component {
  grid-area: info;
  padding: 50px;
}

img {
 max-height: 45%;
}
</style>
