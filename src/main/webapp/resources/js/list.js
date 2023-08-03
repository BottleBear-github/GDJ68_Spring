const kind = document.getElementsByClassName("kind");
const ki = document.getElementById("k");
const move = document.getElementsByClassName("move");
const page = document.getElementById("page");
const frm = document.getElementById("frm")

//  jsp에 있는 이엘의 값을 js로 가져오기


// let data='';

// //1. 함수를 사용
// function setData(d){
//     data=d;
//     for(k of kind){
//         if(k.value==data){
//             k.seleted==true;
//             break;
//         }
//     }
// }

//2.속성을 이용, element에서 속성의 값으로 가져오기
let data = ki.getAttribute("data-kind");
    for(k of kind){
        if(k.value==data){

            k.seleted==true;
            break;
        }
    }


for(m of move){
    m.addEventListener("click", function(){
        page.value = this.getAttribute("data-num");
        frm.submit;
    });
}