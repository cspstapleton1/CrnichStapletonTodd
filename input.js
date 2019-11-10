a = document.querySelectorAll("#picker")
b = document.querySelector("#education_type")
c = document.querySelector("#reinbursment_percentage")
d = document.querySelectorAll("#grade_type")

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
