<template>
  <div class="container">
    <label class="tekstfelt"> {{ displayValue }}</label>
    
    <button v-for="val in buttonValues" :key="val" @click="append(val)"> {{ val }}</button> 
    <button @click="equals" class="equals">=</button>
    <button @click="clear" class="clear">C</button>
  </div>
  <ul class="log">
    <li v-for="e in log" :key="e">{{ e }}</li>
  </ul>
  <select @change="getNumberOfEquationsValue" name="Number of equations" id="selectNumberOfEquations" >
      <option value="5" selected="selected"> 5 </option>
      <option value="10"> 10 </option>
      <option value="15"> 15 </option>
 
  </select>
</template>

<script>
import { sendExpression } from "@/services/api.js"
import { getLog } from "@/services/api.js"

export default {
  name: "calculator",

  data() {
    return {
      displayValue: "",
      buttonValues: [
        7, 8, 9, '+', 4, 5, 6, '-', 1, 2, 3, '*', 0, '.', '/'
      ],
      log: [],
      operator: null,
      prevValue: "",
      currentValue: "",
      equationd: "",
      operators: ["+", "-", "*", "/"],
      ops: [],
      values: [],
      numberOfEquationsShown: null,
      newEq: true,
      lastIsDot: false,
      
    };
  },
  mounted(){
    this.getNumberOfEquationsValue()
  },
  methods: {
    getValue(button) {
      this.$emit("target-value", button.target.value);
    },
    async getNumberOfEquationsValue(){
      this.numberOfEquationsShown = document.getElementById("selectNumberOfEquations").value
      this.log = await getLog(this.numberOfEquationsShown);
    },

    clear() {
      (this.displayValue = ""),
        (this.prevValue = ""),
        (this.currentValue = ""),
        (this.operator = "");
      this.newEq = true;
      this.clearValues();
    },
    clearValues() {
      (this.values = []), (this.ops = []);
    },
    append(number) {
      if (this.newEq) {
        this.clear();
      }
      this.newEq = false;

      if (number == "." && this.lastIsDot) {
        this.clearValues;
        this.displayValue = "Syntax Error";
      }
      if (this.operators.includes(number)) {
        this.displayValue += number + "";
        if (
          !this.operators.includes(
            this.displayValue.charAt(this.displayValue.length - 2)
          )
        ) {
          this.values.push(this.currentValue), this.ops.push(number);
        }
        (this.currentValue = ""),
          (this.operator = number),
          console.log(this.prevValue);
      } else if (!this.operators.includes(number)) {
        this.displayValue += number + "";
        this.currentValue += number + "";

        console.log(this.currentValue);
      }
      if (number == ".") {
        this.lastIsDot = true;
      } else this.lastIsDot = false;
    },
    async equals() {
      this.getNumberOfEquationsValue(),

      this.values.push(this.currentValue);

      let num1 = this.values[0];
      let num2 = this.values[1];
      let op = this.ops[0];

      let ex = await sendExpression(num1, num2, op);
      console.log(ex);
      this.log.push(num1 + " " + op + " " + num2)

      this.displayValue = ex;
      this.clearValues()
      this.newEq = true
    
      
    },
  },
};
</script>

<style scoped>
.container {
  display: grid;
  width: 70%;
  background-color: rgb(168, 168, 168);
  height: 300px;
  grid-auto-columns: 1fr 1fr 1fr 1fr;
  grid-auto-rows: 1fr 1fr 1fr 1fr;
  margin: auto;
}

button {
  font-size: 25px;
}
.tekstfelt {
  padding-top: 10px;
  font-size: 30px;
  grid-area: tekstfelt;
  width: 100%;
  text-align: center;
  grid-row: 1 / 2;
  grid-column: 1/5;
}
button {
  margin: 1px;
}
.equals {
  grid-area: equals;
  grid-row: 6/7;
  grid-column: 1/5;
}
</style>
