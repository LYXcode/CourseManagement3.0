// JavaScript Document

$.ajax({
    url:'/course/{courseId}',
    type:'GET',
    success:function(data){
       $('#courseInfo').html(data.discription);
	   $('#course').html(data.name);
	
       }
});
$.ajax({
    url:'/course/{courseId}/seminar',
    type:'GET',
    success:function(data){
       $('#name').html(data.name);
       }
});

function onClick()
{
	window.location.href="student_group.html";
	}