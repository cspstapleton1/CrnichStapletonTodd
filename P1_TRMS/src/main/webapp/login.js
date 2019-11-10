function userLogin(){
    let vg=document.getElementById("login").submit;
    var xhr= new XMLHttpRequest();
    xhr.onreadystatechange= function() {
   if(xhr.readyState==4 && xhr.status==200){
      console.log(xhr.responseText);
    }
    }
   xhr.open("POST","http://localhost:9998/P1_TRMS/login",true);
   var payload=jsonBuilder();
   xhr.send(payload);
   
   }
   
   function jsonBuilder() {
   var elements = document.getElementById("login").elements;
    var obj ={};
    for(var i = 0 ; i < elements.length; i++){
       var item = elements.item(i);
       obj[item.name] = item.value;
       console.log(obj);   
    }
   var json= JSON.stringify(obj);
   console.log(json);
   return json;
   }
   
   window.onload= function() {
    document.getElementById("loginSubmit").addEventListener("click",userLogin,false);
   }