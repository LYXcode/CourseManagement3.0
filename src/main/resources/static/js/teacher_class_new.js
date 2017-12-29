function getQueryString(name) { 
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
    var r = window.location.search.substr(1).match(reg); 
    if (r != null) return unescape(r[2]); return null; 
    };
    
var courseid=getQueryString("id");
$.ajax({
    url:"/course/"+courseid,
    type:"GET",
	beforeSend:function(request){
		request.setRequestHeader("token",localStorage.getItem("token"));
	},
    success:function(data){
        $('.courseName').html(data.name);
        $('.courseIntroduction').html(data.description);
    }
});

function onClick(){
	var site=document.getElementById("site");
	var time=document.getElementById("time");
    $.ajax({
    	url:"/course/"+courseid+"/class",
    	type:"POST",
    	beforeSend:function(request){
    		request.setRequestHeader("token",localStorage.getItem("token"));
    	},
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
    		window.location.href="../../course/teacher_course_index.html?id="+courseid;
    	}
    });
}
function onReturn(){
	window.location.href="../../course/teacher_course_index.html";
}
function toIndex(){
		window.location.href="../../teacher_index.html"
		}