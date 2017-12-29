function getQueryString(name) { 
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
    var r = window.location.search.substr(1).match(reg); 
    if (r != null) return unescape(r[2]); return null; 
    };
var courseid=2;
var classid=getQueryString("id");
$.ajax({
	url:"/class/"+classid,
	type:'GET',
	beforeSend:function(request){
		request.setRequestHeader("token",localStorage.getItem("token"));
	},
	success:function(classData){
		$('#name').html(classData.name);
		$('#presentation').html(classData.presentation);
		$('#report').html(classData.report);
		$('#a').html(classData.a);
		$('#b').html(classData.b);
		$('#c').html(classData.c);
	}
});

function onClick(){
	var site=document.getElementById("site");
	var time=document.getElementById("time");
    $.ajax({
    	url:"/class/"+classid,
    	type:"PUT",
    	contentType:"application/json",
    	data:JSON.stringify({
    		"name":$("#className").val(),
    		"classTime":$("#bigSelect").val()+$("#smallSelect").val(),
    		"c":$("#c").val(),
    		"b":$("#b").val(),
    		"a":$("#a").val(),
    		"report":$("#presentation").val(),
    		"presentation":$("#report").val()
    	}),
    	success:function(data){
    		window.location.href="../class/teacher_class_index.html?id="+classid;
    	}
    });
}
function onReturn(){
	window.location.href="teacher_class_index.html?id="+classid;
}
function toIndex(){
		window.location.href="../../teacher_index.html"
		}