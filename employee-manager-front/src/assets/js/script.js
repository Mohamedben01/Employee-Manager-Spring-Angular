window.onload=()=>{
    
let addIcon = document.querySelector(".nav .addIcon #addEmpl");
let addForm = document.querySelector(".employeeForm");
let close = document.querySelector("#close");

addIcon.onclick=()=>{
    addForm.classList.add("active");
}
close.onclick=()=>{
    addForm.classList.remove("active");
}

}