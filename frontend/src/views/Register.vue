<template>
  <form>
      <h1> Register </h1>
      <BaseInput
      label="Full Name"
      type= "text"
      >
      </BaseInput>

      <BaseInput
      label="Address"
      type= "text"
      >
      </BaseInput>

      <BaseInput
      label="Username"
      type= "text"
      >
      </BaseInput>

      <BaseInput
      label="Password"
      type= "password"
      >
      </BaseInput>

      <BaseInput
      label="Email"
      type= "email"
      >
      </BaseInput>

      <BaseInput
      label="Phone"
      type= "text"
      >
      </BaseInput>

      <div class="submit" id="sub-button">
          <button 
          type="submit"
          >
          Register
          </button>
      </div>
  </form>
</template>

<script>
import BaseInput from '@/components/BaseInput.vue' 
export default {
    components:{
        BaseInput
    }
}
</script>

<style>
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