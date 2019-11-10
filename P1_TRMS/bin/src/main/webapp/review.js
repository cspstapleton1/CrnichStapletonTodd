function loadVG(app){	
    document.getElementById("form_id").innerHTML=app.form_id;
    document.getElementById("urgent").innerHTML=app.urgent;
    document.getElementById("event_type").innerHTML=app.event_type;
    document.getElementById("fName").innerHTML=app.fName;
    document.getElementById("lName").innerHTML=app.lName;
    document.getElementById("dept").innerHTML=app.dept;
    document.getElementById("email").innerHTML=app.email;
    document.getElementById("location").innerHTML=app.location;
    document.getElementById("justification").innerHTML=app.justification;
    document.getElementById("sDate").innerHTML=app.sDate;
    document.getElementById("eDate").innerHTML=app.eDate;
    document.getElementById("sTime").innerHTML=app.sTime;
    document.getElementById("eTime").innerHTML=app.eTime;
    document.getElementById("gradeFormat").innerHTML=app.gradeFormat;
    document.getElementById("gradeCutoff").innerHTML=app.gradeCutoff;
    document.getElementById("cost").innerHTML=app.cost;
    document.getElementById("reimbursement").innerHTML=app.reimbursement;
    document.getElementById("presentation").innerHTML=app.presentation;
    document.getElementById("attachment").innerHTML=app.attachment;
    document.getElementById("sAccept").innerHTML=app.sAccept;
    document.getElementById("dhAccept").innerHTML=app.dhAccept;
    document.getElementById("sAccept").innerHTML=app.sAccept;
    document.getElementById("failDesc").innerHTML=app.dhAccept;
}
function getapp(){
console.log( "in get VG bananaphone!");
// let vgid=document.getElementById("vgIDInput").value;
var xhr= new XMLHttpRequest();
 xhr.onreadystatechange= function() {
    console.log("in ORSC "+ xhr.readyState );
    if(xhr.readyState==4 && xhr.status==200){
       console.log(xhr.responseText);
      var app= JSON.parse(xhr.responseText);
        loadVG(app);
    }
}
xhr.open("GET","http://localhost:8080/JSONDemo/vg?vgid=" + vgid,true);
 xhr.send();
 }
