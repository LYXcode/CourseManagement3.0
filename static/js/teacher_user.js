// JavaScript Document


$.ajax({
    url:'/me',
    type:'GET',
    success:function(data){
       $('#username').html(data.phone);
	   $('#name').html(data.name);
	   $('#university').html(data.school);
	   $('#title').html(data.type);
	   $('#E-mail').html(data.email);
	   $('#phone').html(data.phone);
	   $('#gender').html(data.gender);
	   $('#number').html(data.stuffNum);
       }
});

function onClick(){
	window.location.href="teacher_edit.html";
}
			
	
