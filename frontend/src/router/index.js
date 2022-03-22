import { createRouter, createWebHashHistory } from "vue-router";
import Calculator from "../views/Calculator.vue";

const routes = [
  {
    path: "/",
    name: "Calculator",
    component: Calculator,
  },
  {
    path: "/review",
    name: "Review",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/Review.vue"),
  },
  {
    path:"/logIn",
    name: "LogIn",
    component: () =>
      import( "../views/LogIn.vue"),
  },
  {
  path:"/register",
  name: "Register",
  component: () =>
    import( "../views/Register.vue"),
},
  
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

export default router;
