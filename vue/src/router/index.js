import { createRouter as createRouter, createWebHistory } from 'vue-router'
import { useStore } from 'vuex'

// Import components
import HomeView from '../views/HomeView.vue';
import LoginView from '../views/LoginView.vue';
import LogoutView from '../views/LogoutView.vue';
import RegisterView from '../views/RegisterView.vue';
import PatientRegistrationView from '../views/PatientRegistrationView.vue';
import DoctorRegistrationView from '../views/DoctorRegistrationView.vue';
import OfficesView from '../views/OfficesView.vue';
import ScheduleAppointmentView from '../views/ScheduleAppointmentView.vue';
import MyAppointmentsView from '../views/MyAppointmentsView.vue';
import UpdateOfficeView from '../views/UpdateOfficeView.vue';
import DoctorsView from '../views/DoctorsView.vue';

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */


const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
    meta: {
      /* changed requires authorization to false in order to view home page */
      requiresAuth: false
    }
  },
  {
    path: "/login",
    name: "login",
    component: LoginView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/login",
    name: "logout",
    component: LogoutView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/register",
    name: "register",
    component: RegisterView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/patientRegistration",
    name: "patient-registration",
    component: PatientRegistrationView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/doctorRegistration",
    name: "doctor-registration",
    component: DoctorRegistrationView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/offices",
    name: "offices",
    component: OfficesView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/offices/:officeId/edit",
    name: "update-office",
    component: UpdateOfficeView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/offices/:officeId/doctors",
    name: "doctors",
    component: DoctorsView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/scheduleAppointment",
    name: "schedule-appointment",
    component: ScheduleAppointmentView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/myAppointments",
    name: "my-appointment",
    component: MyAppointmentsView,
    meta: {
      requiresAuth: true
    }
  },
];

// Create the router
const router = createRouter({
  history: createWebHistory(),
  routes: routes
});

router.beforeEach((to) => {

  // Get the Vuex store
  const store = useStore();

  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    return { name: "login" };
  }
  // Otherwise, do nothing and they'll go to their next destination
});

export default router;
