// JavaScript Document

$.ajax({
    url:'/class/{classId}/classgroup',
    type:'GET',
    success:function(data){
       $('#leadername').html(data.leader.name);
	    $('#leadernumber').html(data.leader.number);
		 $('#name').html(data.members.name);
		  $('#number').html(data.membbers.number);
	   
       }
});

function onClick(){
	
	window.location.href="student_addToGroup.html";
	}