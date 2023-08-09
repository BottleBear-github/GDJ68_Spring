const add = document.getElementById("add");
const fileList = document.getElementById("fileList");

let max=5;
let count=0;

fileList.addEventListener("click", function(event){
    //console.log(event.target);
    let cl =event.target.classList();
    if(event.target.classList.contains("df")){
        alert("delete")
    }
})



add.addEventListener("click", function(){

    if(count>=max){
        alert("최대 5개만 가능");
        return;
    }
    count++;

    //div
    let d = document.createElement("div");  //<div></div>
    let a = document.createAttribute("class"); //class=
    a.value="input-group mb-3";  //class="input-group mb-3"
    d.setAttributeNode(a);
    a = document.createAttribute("id");
    a.value="file"+idx;
    idx++

    //input
    let i = document.createElement("input");
    a = document.createAttribute("type");
    a.value="file";
    i.setAttributeNode(a);
    a = document.createAttribute("class");
    a.value="form-control";
    i.setAttributeNode(a);

    a = document.createAttribute("id");
    a.value="photos";
    i.setAttributeNode(a);

    a = document.createAttribute("name");
    a.value="photos";
    i.setAttributeNode(a);
        
    d.appendChild(i);

    let s = document.createElement("span")
    let t = document.createTextNode("X")
    a = document.createAttribute("class")
    a.value="df";
    s.setAttribute(a);
    s.appendChild(t);

    d.appendChild(s);



    fileList.appendChild(d);


})

// fileList.addEventListener("click", function(event){
//     // alert("fileList");
//     console.log("event : ", event);
//     //event.target  => getElementById();
//     // if(event.target.id=="b1"){
//     //     alert("button");
//     // }
// });


