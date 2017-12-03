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
	success:function(classData){
		$('#name').html(classData.name);
		$('#presentation').html(classData.pro.presentation);
		$('#report').html(classData.pro.report);
		$('#a').html(classData.pro.a);
		$('#b').html(classData.pro.b);
		$('#c').html(classData.pro.c);
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
    		"name":$("#name").val(),
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