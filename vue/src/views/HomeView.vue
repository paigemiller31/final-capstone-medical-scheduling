<template>
  <body>
    <div class="home">
      <div class="form-body">

        <h1 class="main-header">Medical Scheduling Company</h1>

        <div id="logo">
          <img src="src\assets\home.JPG">
        </div>

        <article id="info">
          <li class="header-2">For Patients:</li>
          
          <li class="description">Effortless Scheduling: Find the right doctor, view their availability, and book appointments directly - all in one place.</li>
          <li class="description">Improved Access to Care: Eliminate phone calls and schedule appointments at your convenience.</li>

          <li class="header-2">For Doctors:</li>

          <li class="description">Centralized Management: Manage your schedule seamlessly and receive real-time appointment notifications.</li>
          <li class="description">Increased Patient Satisfaction: Offer convenient online booking, reducing phone traffic and wait times.</li>

          <li class="foot-text">Secure, efficient scheduling for doctors and patients. Sign up and simplify your healthcare experience today!</li>
        </article>

      </div>
    </div>
  </body>
</template>

<script>
export default {

  /*
   * USE THIS MOUNTED LIFECYCLE HOOK TO PUSH USERS TO LOGIN IF THEY AREN'T LOGGED IN*
   * --> TOTALLY OPTIONAL BECAUSE SHELBY TOLD ME SHE DIDN'T WANT THIS (AND THEN PAIGE DEFENDED HER(AND THEY WERE BOTH RIGHT(AS USUAL))) <--
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
  color: #000000;
}

body {
  overflow: hidden;
}

.main-header {
  grid-area: header;
  text-transform: uppercase;
  text-justify: center;
  text-align: center;
  padding-top: 25px;
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
  margin-top: 75px;
  margin-bottom: 50px;
  margin-left: 30px;
  margin-right: 70px;
  height: 60vh;
  width: 100vh
}

#logo {
  grid-area: logo;
  display: flex;
  justify-content: center;
  padding-top: 60px;
  padding-bottom: 30px;
  padding-left: 20px;

}

#info {
  grid-area: info;
  padding-top: 60px;
  padding-right: 65px;
}

#footer {
  grid-area: footer;
}

img {
  max-height: 45%;
}

li {
  margin-bottom: 5px;
  list-style: none;
}

.header-2 {
  text-transform: uppercase;
  font-weight: bold;
  font-size: 13pt;
  padding-top: 15px;
  padding-bottom: 5px;
}

.description {
  font-size: 10pt;
}

.foot-text {
  margin-top: 13px;
  font-size: 11.5pt;
  font-style: italic;
  padding-top: 7px;
}</style>
