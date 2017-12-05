// JavaScript Document
function getQueryString(name) { 
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
    var r = window.location.search.substr(1).match(reg); 
    if (r != null) return unescape(r[2]); return null; 
    };

var courseId=getQueryString("id");
$.ajax({
    url:'/course/'+courseId,
    type:'GET',
    success:function(courseData){
       $('#courseInfo').html(courseData.discription);
	   $('#courseIn').html(courseData.name);
	
       }
});
$.ajax({
    url:'/course/'+courseId+'/seminar',
    type:'GET',
    success:function(seminarData){
       $('#name').html(seminarData.name);
       }
});

function onClick()
{
	window.location.href="student_group.html";
}

function onReturn(){
	window.location.href="../../student/student_index.html";
}

$(function(){
	$('.blockFont').click(function(){
			var seminarId=$(this).attr('id');
			$.ajax({
				url:"/seminar/"+seminarId,
				method:"GET",
				content:"application/json",
				success:function(data){
					window.location.href="student_topic_random.html?id="+seminarId;
					//window.location.href="student_topic_fixed.html?id="+seminarId;
				},
			});
	});
});