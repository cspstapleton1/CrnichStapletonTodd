a = document.querySelectorAll("#picker")
b = document.querySelector("#education_type")
c = document.querySelector("#reinbursment_percentage")
d = document.querySelectorAll("#gradeFormat")

a[0].addEventListener("click", function(){
c.value = 80
b.value = 'University Crouses'
d[0].type="radio"
});

a[1].addEventListener("click", function(){
c.value = 60
b.value = 'Seminars'
d[0].type="hidden"
});

a[2].addEventListener("click", function(){
c.value = 80
b.value = 'Certification Preparation'
d[0].type="radio"
});

a[3].addEventListener("click", function(){
c.value = 100
b.value = 'Certification'
d[0].type="hidden"
});

a[4].addEventListener("click", function(){
c.value = 90
b.value = 'Technical Training'
d[0].type="radio"
});

a[5].addEventListener("click", function(){
c.value = 30
b.value = 'Other'
d[0].type="radio"
});


function submitApp(){
 let vg=document.getElementById("reinbursmentForm").submit;
 var xhr= new XMLHttpRequest();
 xhr.onreadystatechange= function() {
if(xhr.readyState==4 && xhr.status==200){
 console.log(xhr.responseText);
 }
 }
xhr.open("POST","http://localhost:8080/review/app",true);
 var payload=jsonBuilder();
 xhr.send(payload);

}
function jsonBuilder() {
var elements = document.getElementById("reinbursmentForm").elements;
 var obj ={};
 for(var i = 0 ; i < elements.length-1; i++){
    var item = elements.item(i);
    obj[item.name] = item.value;
    console.log(obj);   
 }
var json= JSON.stringify(obj);
console.log(json);
return json;
}

window.onload= function() {
 document.getElementById("reinbursmentSubmit").addEventListener("click",submitApp,false);
// document.getElementById("vgFormSubmit").addEventListener("click", postVG,false);

// document.getElementById("vgFormSubmit").addEventListener("click", postVG,false);
}