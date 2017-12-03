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
        $('.courseName').html(data.name);
        $('.courseIntroduction').html(data.description);
    }
});

function onClick(){
	var groupingMethod=document.getElementById("groupingMethod");
	$.ajax({
		url:"/course/"+courseid+"/seminar",
		typr:"POST",
		contentType:"application/json",
		data:JSON.stringify({
    		"name":$("#name").val(),
    		"description":$("#description").val(),
    		"c":$("#c").val(),
    		"b":$("#b").val(),
    		"a":$("#a").val(),
    		"report":$("#report").val(),
    		"presentation":$("#presentation").val()
		}),
		success:function(data){
			alert("成功返回");
			window.location.href="../../course/teacher_course_index.html?id="+courseid;
		}
	});
}