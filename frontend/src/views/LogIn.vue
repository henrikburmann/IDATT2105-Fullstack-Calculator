<template>
<form @submit.prevent="submit">
    <fieldset>
  <BaseInput
  v-model="name"
  label= "name"
  type = "text"
  :error = "errors.name"
  > 
  
  </BaseInput>
    
  <BaseInput
  v-on:keyup="isValid"
  v-model="password"
  label="Passord"
  type="password"
  :error = "errors.name"
  >
  </BaseInput>

  <div class="submit" id="sub-button">
          <button
          type="submit"
          v-if="validInput"
          >
          Log In
          </button>
      </div>
    
        <router-link to="/register">Register</router-link>
    </fieldset>
</form>
</template>
<script>

import BaseInput from '@/components/BaseInput.vue'
import { useField, useForm } from 'vee-validate';
import { object, string } from 'yup'
import { useStore } from 'vuex'
export default {

     components:{
        BaseInput
    },
    data(){
        return {
            validInput: false,
        }
    },

    setup(){
      
   
      const validationSchema = object({
          name: string().required(),
          password: string().required(),
    

      })
          
      const { handleSubmit, errors } = useForm({
          validationSchema
      })
        const { value: name} = useField('name');

        const { value: password} = useField('password')

        const store = useStore();
        
        

        const submit = handleSubmit(() => { 
                if(name.value == "Henrik" && password.value == "pass"){
                    alert("yey")
                    
                }
                else{
                    alert(password.value)

                }
                
                store.commit('SET_LOGINNAME', name);
                store.commit('SET_LOGINPASSWORD', password)
        })

        
      return {
        name,
        password,
        errors,
        submit
      }
    
    },
    methods:{
        isValid: function(){
            if(!this.errors){
                this.validInput = true
                return true
            }
            return false
        },
    },
    
    computed:{
        
        isCorrectLogin(navn){
            if(this.name == "Henrik" && this.password == "password"){
                console.log(navn)
                return "Nydelig"
            }
            else{
                return "Elending"
            }

        }
    }

}
</script>

<style scoped>
   form{
        max-width: 420px;
        margin: 30px auto;
        background-color: white;
        text-align: left;
        padding: 40px;
        border-radius: 10px;
    }

    label{
        color: #aaa;
        display: inline-block;
        margin: 25px 0 15px;
        font-size: 0.6em;
        text-transform: uppercase;
        letter-spacing: 1px;
        font-weight: bold;
    }
    input, select{
        display: block;
        padding: 10px  6px;
        width: 100%;
        box-sizing: border-box;
        border: none;
        border-bottom: 1px solid #ddd;
        color: #555;
    }
  

    button{
        background: #0b6dff;
        border: 0;
        padding: 10px 20px;
        margin-top: 20px;
        color: white;
        border-radius: 20px;
    }
    .submit{
        text-align: center;
    }
    .error{
        color: #ff0062;
        margin-top: 10px;
        font-size: 0.8em;
        font-weight: bold;
    }
    .message{
        min-height: 200px;
        vertical-align: top;
        display: block;
        width: 100%;
        padding: 5px;
    }

    fieldset{
        border: 0;
        padding: 0;
        margin: 0;
    }
</style>