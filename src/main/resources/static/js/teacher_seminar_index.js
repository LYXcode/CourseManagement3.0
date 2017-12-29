function getQueryString(name) { 
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
    var r = window.location.search.substr(1).match(reg); 
    if (r != null) return unescape(r[2]); return null; 
    };

var topicid=2;
var courseid=2;
var seminarid=getQueryString("id");

$.ajax({
    url:"/course/"+courseid,
    type:"GET",
	beforeSend:function(request){
		request.setRequestHeader("token",localStorage.getItem("token"));
	},
    success:function(courseData){
        $('.courseName').html(courseData.name);
        $('.courseIntroduction').html(courseData.description);
    }
});
$.ajax({
	url:"/seminar/"+seminarid,
	type:'GET',
	beforeSend:function(request){
		request.setRequestHeader("token",localStorage.getItem("token"));
	},
	success:function(seminarData){
		$('.title').html(seminarData.name);
		$('#name').html(seminarData.name);
		$('#presentation').html(seminarData.presentation);
		$('#report').html(seminarData.report);
		$('#a').html(seminarData.a);
		$('#b').html(seminarData.b);
		$('#c').html(seminarData.c);
	}
});
$.ajax({
	url:"/seminar/"+seminarid+"/topic",
	type:'GET',
	beforeSend:function(request){
		request.setRequestHeader("token",localStorage.getItem("token"));
	},
	success:function(topicData){
		var topics="";
		for(var i=0;i<topicData.length;i++)
		{
			topics+="<div class=\"topicBlock\"><div class=\"topicBlockFont\">"+ "话题"+topicData[i].serial +"</div></div>";
			}
		document.getElementById("topics").innerHTML=topics;
	}
});

function onScore(){
	window.location.href="../seminar/teacher_seminar_checkScore.html?id="+seminarid;
};

function onUpdate(){
	window.location.href="../seminar/teacher_seminar_edit.html?id="+seminarid;
};

function onDelete(){
		if(confirm("确定删除此讨论课？"))
		{
			$.ajax({
				url:"/seminar/"+seminarid,
				method:"DELETE",
				beforeSend:function(request){
					request.setRequestHeader("token",localStorage.getItem("token"));
				},
				success:function(deleteData){
					alert("删除成功");
					window.location.href="../teacher_course_index.html?id="+courseid;
				},
				error:function(deleteData){
					alert("删除失败");
					window.location.href="../teacher_course_index.html?id="+courseid;
				}
			});
		}
	};

$(function(){
		$('.topicBlockFont').click(function(){
			window.location.href="../topic/teacher_topic_check.html?id="+topicid;
		});
	});

function addSeminar(){
	window.location.href="../topic/teacher_topic_new.html?id="+courseid;
}

function onReturn(){
	window.location.href="../teacher_course_index.html?id="+courseid;
}
function toIndex(){
		window.location.href="../../teacher_index.html"
		}