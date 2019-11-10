function loadVG(app){	
    date = document.querySelectorAll("#submitDate")
    start = document.querySelectorAll("#sDate")
    end = document.querySelectorAll("#eDate")

    for(var i = 0; i < 5; i++){
        date[i].innerHTML = app.submitDate;
        start[i].innerHTML = app.sDate;
        end[i].innerHTML = app.eDate;
    }
    
}
function getapp(){
console.log( "in get VG bananaphone!");
let vgid=document.getElementById("vgIDInput").value;
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
