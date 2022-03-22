<template>
  <form @submit.prevent = "submit">

      <fieldset>
          <legend>Fyll inn din ting</legend>
      <BaseInput 
        v-model="name"
        type="text"
        label="Title"
        :error = "errors.name"
     
      >
      </BaseInput>
        <BaseInput
        :modelValue="email"
        @change="handleChange"
        label="email"
        type="email"
        :error = "errors.email"
        >
        </BaseInput>

        <BaseInput
            v-model="message"
            type="text"
            label= "Message"
            :error="errors.message"
        >
        </BaseInput>
      </fieldset>
  
    
      <div class="submit" id="sub-button">
          <button 
          type="submit"

          >
          Bekreft</button>
      </div>

  </form>

<p>Name: {{ this.$store.state.name }} </p>
<p>Sent: {{ this.$store.state.sendt }}</p>
 

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
        return{
            validInput: false,
        }
    },
   
    setup(){
      
   
      const validationSchema = object({
          name: string().required(),
          email: string().email().required(),
          message: string().required(),

      })
          
      const { handleSubmit, errors } = useForm({
          validationSchema
      })
      const { value: email, handleChange} = useField('email'); 
        const { value: name} = useField('name');
        const { value: message} = useField('message')

        const store = useStore();
        
        let sendt = false;
        

        const submit = handleSubmit(() => {
            alert("Sendes...");
            sendt = true
            store.commit('SET_SENDT', sendt) 
    
            setTimeout(() =>{
                alert("Sendt!")
                store.commit('SET_NAME', name);
                store.commit('SET_EMAIL', email)
            }, 1000)
        })

      return {
        email,
        name,
        message,
        errors,
        handleChange,
        submit
      }
    },
    methods:{
        isValidInput: function(){
            if(!this.errors){
                this.validInput = true
                return true
            }
            return false;
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