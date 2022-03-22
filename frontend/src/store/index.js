import { createStore } from "vuex";

export default createStore({
  state: {
    name: '',
    email: '',
    sendt: false,
    logName:'',
    logPassword: ''
  },
  mutations: {
    SET_NAME(state, name){
      state.name = name;
    },
    SET_EMAIL(state, email){
      state.email = email;
    },
    SET_SENDT(state, sendt){
      state.sendt = sendt
    },
    SET_LOGINNAME(state, name){
      state.logName = name
    },
    SET_LOGINPASSWORD(state, password){
      state.logPassword = password
    }
  },
  actions: {},
  modules: {},
});
