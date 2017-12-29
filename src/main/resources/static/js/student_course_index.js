// JavaScript Document
function getQueryString(name) { 
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
    var r = window.location.search.substr(1).match(reg); 
    if (r != null) return unescape(r[2]); return null; 
    };
var courseId=getQueryString("courseId");
var classId=getQueryString("classId");
$.ajax({
    url:'/course/'+courseId,
    type:'GET',
	beforeSend:function(request){
		request.setRequestHeader("token",localStorage.getItem("token"));
	},
    success:function(courseData){
       $('#courseInfo').html(courseData.discription);
	   $('#courseName').html(courseData.name);
	
       }
});
$.ajax({
    url:'/course/'+courseId+'/seminar',
    type:'GET',
	beforeSend:function(request){
		request.setRequestHeader("token",localStorage.getItem("token"));
	},
    success:function(seminarData){
      var seminarInfo="";
	  for(var i=0;i<seminarData.length;i++)
	  {
		  seminarInfo+="<div class=\"block\"><div class=\"blockFont\" id="+seminarData[i].id+" data-seminar-type="+seminarData[i].groupingMethod+">"+seminarData[i].name+"</div></div>";
		  }
		  
		  document.getElementById("seminars").innerHTML=seminarInfo;
       }
});

function onClick()
{
	window.location.href="student_group.html?id="+classId;
}

function onReturn(){
	window.location.href="../../student/student_index.html";
}

$(function(){
	$('.blockFont').click(function(){
			var seminarId=$(this).attr('id');
			var seminarType=$(this).attr('data-seminar-type');
			$.ajax({
				url:"/seminar/"+seminarId,
				method:"GET",
				beforeSend:function(request){
					request.setRequestHeader("token",localStorage.getItem("token"));
				},
				content:"application/json",
				success:function(data){
				if(seminarType=="random")
					window.location.href="student_topic_random.html?id="+seminarId;
				else if(seminarType=="fixed")
				    window.location.href="student_topic_fixed.html?seminarId="+seminarId+"&classId="+classId;
				},
			});
	});
});