function getQueryString(name) { 
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
	var r = window.location.search.substr(1).match(reg); 
	if (r != null) return unescape(r[2]); return null; 
	};
var courseid=getQueryString("id");
var classid=2;
$.ajax({
	url:"/course/"+courseid,
	type:"GET",
	beforeSend:function(request){
		request.setRequestHeader("token",localStorage.getItem("token"));
	},
	success:function(data){
		$('.courseNam').html(data.name);
		$('.courseIntroduction').html(data.description);
	}
});


$.ajax({
	url:"/course/"+courseid+"/class",
	type:"GET",
	beforeSend:function(request){
		request.setRequestHeader("token",localStorage.getItem("token"));
	},
	success:function(data1){
		var classes="";
		for(var i=0;i<data1.length;i++)
		{
			/*vo.class*/
			classes+="<div class=\"block\"><div class=\"blockFont\"><span class=\"classItem\">"+data1[i].name+"</span></div></div>";
			}
			document.getElementById("classes").innerHTML=classes;
	}
});

$.ajax({
	url:"/course/"+courseid+"/seminar",
	type:"GET",
	beforeSend:function(request){
		request.setRequestHeader("token",localStorage.getItem("token"));
	},
	success:function(data2){
		var seminars="";
		for(var i=0;i<data2.length;i++)
		{
			/*vo.seminar*/
			
			seminars+="<div class=\"block\"><div class=\"blockFont\"><span class=\"seminarItem\">讨论课"+i+"</span></div></div>";
			}
			document.getElementById("seminars").innerHTML=seminars;
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
		window.location.href="../../teacher/course/class/teacher_class_index.html?id="+classid;
	});
});

$(function(){
	$('.seminarItem').click(function(){
		window.location.href="../../teacher/course/seminar/teacher_seminar_index.html?id="+classid;
	});
});

function onReturn(){
	window.location.href="../teacher_index.html";
	}
	
	function toIndex(){
		window.location.href="../teacher_index.html"
		}