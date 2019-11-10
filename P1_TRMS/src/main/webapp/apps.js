
function getapps(){
let vgid=document.getElementById("user").value;
var xhr= new XMLHttpRequest();
 xhr.onreadystatechange= function() {
    console.log("in ORSC "+ xhr.readyState );
    if(xhr.readyState==4 && xhr.status==200){
       console.log(xhr.responseText);
      var apps= JSON.parse(xhr.responseText);
      date = document.querySelectorAll("#submitDate")
    start = document.querySelectorAll("#sDate")
    end = document.querySelectorAll("#eDate")
    end = document.querySelectorAll("#status")
    let index = 0;
    if(appArray.length==0){}
else if (appArray.length<5){
    index =5;
}
else{
    index = appArray.length;
}
      for(var i = 0; i < index; i++){
        date[i].innerHTML = appArray[i].submitDate;
        start[i].innerHTML = appArray[i].sDate;
        end[i].innerHTML = appArray.eDate[i];
        status[i].innerHTML = appArray.status[i];
      }
  
    }
}}
function getapp(){
    console.log( "in get VG bananaphone!");
    let vgid=document.getElementById("appId").value;
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

 window.onload = function() {
    getapps();
    document.getElementById("getapp").addEventListener("click",getapp,false);
 }