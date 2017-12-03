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
    success:function(courseData){
        $('.courseName').html(courseData.name);
        $('.courseIntroduction').html(courseData.description);
    }
});
$.ajax({
	url:"/seminar/"+seminarid,
	type:'GET',
	success:function(seminarData){
		$('.title').html(seminarData.name);
		$('#name').html(seminarData.name);
		$('#presentation').html(seminarData.pro.presentation);
		$('#report').html(seminarData.pro.report);
		$('#a').html(seminarData.pro.a);
		$('#b').html(seminarData.pro.b);
		$('#c').html(seminarData.pro.c);
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
		$('.bottomButton').click(function(){
			window.location.href="../topic/teacher_topic_check.html?id="+topicid;
		});
	});

function addSeminar(){
	window.location.href="../topic/teacher_topic_new.html?id="+courseid;
}

function onReturn(){
	window.location.href="../teacher_course_index.html?id="+courseid;
}