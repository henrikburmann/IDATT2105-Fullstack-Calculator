import axios from "axios";

export function sendExpression(num1, num2, op){
    return axios.post("http://localhost:8080/calculation",
    {
        "num1": num1,
        "num2": num2,
        "operator": op
    }).then((answer) => {
        return answer.data;
    })
}

export function getLog(number){
    
    return axios.get("http://localhost:8080/calculation?numberOfEquations=" + number).then((log) =>{
        return log.data;
    });
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

