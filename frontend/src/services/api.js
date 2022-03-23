import axios from "axios";

export function sendExpression(num1, num2, op){
    return axios.post("http://localhost:8080/calculation",
    {
        "num1": num1,
        "num2": num2,
        "op": op
    })
}

// export function getLastExporession(){
//     return axios.get("http://localhost:8080/calculation").then((answer) =>
//     {
//         return answer.data;
//     });
// }
// export function getAll(){
//     return axios.get("http://localhost:8080/calculation/all").then((answer) =>
//     {
//         return answer.data;
//     });
// }

