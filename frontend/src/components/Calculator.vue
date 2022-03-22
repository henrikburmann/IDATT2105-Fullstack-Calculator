<template>
  <div class="container">
    <label class="tekstfelt"> {{ displayValue }}</label>
    <button @click="append(1)" class="one">1</button>
    <button @click="append(2)" class="two">2</button>
    <button @click="append(3)" class="three">3</button>
    <button @click="append(4)" class="four">4</button>
    <button @click="append(5)" class="five">5</button>
    <button @click="append(6)" class="six">6</button>
    <button @click="append(7)" class="seven">7</button>
    <button @click="append(8)" class="eight">8</button>
    <button @click="append(9)" class="nine">9</button>
    <button @click="append(0)" class="zero">0</button>
    <button @click="append('.')" class="comma">.</button>
    <button @click="append('+')" class="pluss">+</button>
    <button @click="append('-')" class="minus">-</button>
    <button @click="append('*')" class="times">*</button>
    <button @click="append('/')" class="divided">/</button>
    <button @click="equals" class="equals">=</button>
    <button @click="clear" class="clear">C</button>
  </div>
  <ul class="log">
    <li v-for="e in log" :key="e">{{ e }}</li>
  </ul>
</template>

<script>
import { sendExpression } from "@/services/api.js"
import { getLastExporession } from "@/services/api.js"
import { getAll } from "@/services/api.js"

export default {
  name: "calculator",

  data() {
    return {
      displayValue: "",
      log: [],
      operator: null,
      prevValue: "",
      currentValue: "",
      equationd: "",
      operators: ["+", "-", "*", "/"],
      ops: [],
      values: [],
      newEq: true,
      lastIsDot: false,
    };
  },
  methods: {
    getValue(button) {
      this.$emit("target-value", button.target.value);
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
      this.values.push(this.currentValue), 
      console.log(this.values.length);
      // let equation = this.displayValue;
      let num1 = this.values[0];
      let num2 = this.values[1];
      let op = this.ops[0];
      let ex = await sendExpression(num1, num2, op);
      console.log(ex);
      let result = await getLastExporession();
      console.log(result)
      this.displayValue = result
      this.clearValues()
      this.currentValue = result
      this.log = await getAll();
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
  grid-template-areas:
    "tekstfelt tekstfelt tekstfelt tekstfelt"
    "seven eight nine pluss"
    "four five six minus"
    "one two three time"
    "nill times divided clear"
    "equals equals equals equals";
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
}
button {
  margin: 1px;
}
.one {
  grid-area: one;
}
.two {
  grid-area: two;
}
.three {
  grid-area: three;
}
.four {
  grid-area: four;
}
.five {
  grid-area: five;
}
.six {
  grid-area: six;
}
.seven {
  grid-area: seven;
}
.eight {
  grid-area: eight;
}
.nine {
  grid-area: nine;
}
.pluss {
  grid-area: pluss;
}
.zero {
  grid-area: nill;
}
.dot {
  grid-area: comma;
}

.minus {
  grid-area: minus;
}
.times {
  grid-area: time;
}
.equals {
  grid-area: equals;
}
</style>
