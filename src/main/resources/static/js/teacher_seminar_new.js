function getQueryString(name) { 
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
    var r = window.location.search.substr(1).match(reg); 
    if (r != null) return unescape(r[2]); return null; 
    };
    
var courseId=getQueryString("id");

$.ajax({
	url:"/course/"+courseId,
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
	var groupingMethod=document.getElementById("groupingMethod");
	$.ajax({
		url:"/course/"+courseId+"/seminar",
		type:"POST",
		beforeSend:function(request){
			request.setRequestHeader("token",localStorage.getItem("token"));
		},
		contentType:"application/json",
		data:JSON.stringify({
    		"name":$("#name").val(),
    		"description":$("#description").val(),
    		"startTime":$("startTime").val(),
    		"endTime":$("endTime").val(),
    		//"c":$("#c").val(),
    		//"b":$("#b").val(),
    		//"a":$("#a").val(),
    		//"report":$("#report").val(),
    		//"presentation":$("#presentation").val(),
    		"fixed":$("#groupingMethod").val()
		}),
		success:function(data){
			alert("成功返回");
			window.location.href="../../course/teacher_course_index.html?id="+courseId;
		}
	});
}
function onReturn()
{
	window.location.href="../../course/teacher_course_index.html?id="+courseId;
	}
	function toIndex(){
		window.location.href="../../teacher_index.html"
		}