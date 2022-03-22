<template>
  <label :for="uuid" v-if="label">{{ label }}</label>
  <input
    v-bind="$attrs"
    :value="modelValue"
    :placeholder="label"
    @input="$emit('update:modelValue', $event.target.value)"
    :id="uuid"
    :aria-describedby="error ? '${uuid]-error' : null"
    :aria-invalid="error ? true : null"

  >
  <p
      v-if="error"
      class = "errorMessage"
      :id="'${uuid]-error'"
      aria-live="assertive"
  >
   {{ error }}
  </p>
</template>

<script>
import UniqueID from '@/features/UniqueID.js'
export default {
   name: "BaseInput",
  props: {
    label: {
      type: String,
      default: ''
    },
    modelValue: {
      type: [String, Number],
      default: ''
    },
    error:{
        type: String,
        default: ''
    }
  },
  setup(){
      const uuid = UniqueID().getID()
      return{
          uuid
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
    
    .message{
        min-height: 200px;
        vertical-align: top;
        display: block;
        width: 100%;
        padding: 5px;
    }
    .errorMessage{
        color: red;
        font-size: 12px;
    }
</style>