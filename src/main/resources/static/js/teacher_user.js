// JavaScript Document


$.ajax({
    url:'/me',
    type:'GET',
	beforeSend:function(request){
		request.setRequestHeader("token",localStorage.getItem("token"));
	},
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
function toIndex(){
		window.location.href="teacher_index.html"
		}
			
	
