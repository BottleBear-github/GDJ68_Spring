const join = document.getElementsByClassName("join");
const output = document.getElementsByClassName("output");
const id = document.getElementById("id");
const pw = document.getElementById("pw");
const pw2 = document.getElementById("pw2");
const name1 = document.getElementById("name");
const email = document.getElementById("email");
const birth = document.getElementById("birth");
const btn = document.getElementById("btn");
const frm = document.getElementById("frm")

//idcheck결과
// let idCheckResult = false;
// let pwCheckResult = false;
// let pw2CheckResult = false;
// let nameCheckResult = false;
// let emailCheckResult = false;

let checkResults=[false,false,false,false,false, false];

// for(j of join){
//     j.addEventListener("blur", function(){
//         if(j.value==""){
//             for(o of output){
//                 o.innerText='내용을 입력하세요';
//             }

//         }
//     })
// }

//id check=====================================
//비어있으면 안되고, 최대10글자
id.addEventListener("blur", function(){
    console.log(id.id);
    const idResult = document.getElementById(id.id+"Result");

    if(id.value == "" || id.value.length>10){
        console.log("xxxxx");
        idResult.innerText="ID가 비어있거나, 10글자가 넘는다";
        idResult.className="f";
        checkResults[0] = false;
    }else {
        console.log("ok")
        idResult.innerHTML="잘했다";
        idResult.className="s";
        checkResults[0] = true;
    }
})

//=============================================

//pw check=====================================
//pw : 비어x 6글자 이상 12미만
pw.addEventListener("blur", function(){
    console.log(pw.id);
    const pwResult = document.getElementById(pw.id+"Result");
    if(pw.value.length>5 && pw.value.length<12){
        pwResult.innerText="올바른 비번이다";
        pwResult.className="s";
        checkResults[1] = false;
    }else {
        pwResult.innerText="6자 이상 12자 미만으로 해라";
        pwResult.className="f";
        checkResults[1] = true;
    }

    pws();
})

pw.addEventListener("change", function(){
    pw2.value="";
    checkResults[2]=false;
    pw2Result.innerText="";
})

//=============================================

//pw2 check=====================================
pw2.addEventListener("keyup", function(){
    pws();
})

//=============================================
//pw공통함수
function pws(){
    console.log(pw2.id);
    const pw2Result = document.getElementById(pw2.id+"Result");
    if(pw.value == pw2.value){
        pw2Result.innerText="맞다";
        pw2Result.className="s";
        checkResults[2] = true;
    }else {
        pw2Result.innerText="맞지 않다";
        pw2Result.className="f";
        checkResults[2] = false;
    }
}
//비어있는지 체크하는 공통함수
function emptyCheck(element){
    if(element.value==null || element.value.length==0){
        return true;
    }else {
        return false;
    }

}

//name check=====================================
// name1.addEventListener("blur", function(){
//     console.log(name1.id);
//     const nameResult = document.getElementById(name1.id+"Result");

//     if(name1.value == ""){
//         console.log("xxxxx");
//         nameResult.innerText="이름을 써라";
//         nameResult.className="f";
//     }else {
//         console.log("ok")
//         nameResult.innerHTML="잘했다";
//         nameResult.className="s";
//     }
// })

name1.addEventListener("blur", function(){
    let check = emptyCheck(name1);
    const nameResult = document.getElementById(name1.id+"Result");
    nameResult.innerText="이름을 써라";
    nameResult.className="f";
    checkResults[3] = false;
    
    if(!check){
        nameResult.innerHTML="잘했다";
        nameResult.className="s";
        checkResults[3] = true;
    }
})
//=============================================

//email check=====================================
email.addEventListener("blur", function(){
    console.log(email.id);
    const emailResult = document.getElementById(email.id+"Result");

    if(email.value == ""){
        console.log("xxxxx");
        emailResult.innerText="이메일을 써라";
        emailResult.className="f";
        checkResults[4] = false;
    }else {
        console.log("ok")
        emailResult.innerHTML="잘했다";
        emailResult.className="s";
        checkResults[4] = true;
    }
})
//=============================================

//birth check=====================================
birth.addEventListener("blur", function(){
    console.log(birth.id);
    const birthResult = document.getElementById(birth.id+"Result");

    if(birth.value == ""){
        console.log("xxxxx");
        birthResult.innerText="생일을 입력해라";
        birthResult.className="f";
        checkResults[5] = false;
    }else {
        console.log("ok")
        birthResult.innerHTML="잘했다";
        birthResult.className="s";
        checkResults[5] = true;
    }
})

btn.addEventListener("click", function(){
    let c = checkResults.includes(false);
    if(!c){
        console.log("form 전송");
        frm.submit();
    }else {
        alert("필수정보 입력해라");
    }
})

//=============================================

//button make=====================================






//=============================================