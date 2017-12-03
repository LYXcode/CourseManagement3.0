function getQueryString(name) { 
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
	var r = window.location.search.substr(1).match(reg); 
	if (r != null) return unescape(r[2]); return null; 
	};
var courseid=getQueryString("id");
$.ajax({
	url:"/course/"+courseid,
	type:"GET",
	success:function(data){
		$('.courseNam').html(data.name);
		$('.courseIntroduction').html(data.description);
	}
});


$.ajax({
	url:"/course/"+courseid+"/class",
	type:"GET",
	success:function(data1){
		$('.classItem').html(data1.name);
	}
});

$.ajax({
	url:"/course/"+courseid+"/seminar",
	type:"GET",
	success:function(data2){
		$('.seminarItem').html(data2.name);
	}
});

function addClass(){
	window.location.href="../../teacher/course/class/teacher_class_new.html?id="+courseid;
}

function addSeminar(){
	window.location.href="../../teacher/course/seminar/teacher_seminar_new.html?id="+courseid;
}

$(function(){
	$('.classItem').click(function(){
		window.loction.href="../../course/class/teacher_class_index?id="+courseid;
	});
});

