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
		$('#description').html(seminarData.description);
		$('#presentation').html(seminarData.pro.presentation);
		$('#report').html(seminarData.pro.report);
		$('#a').html(seminarData.pro.a);
		$('#b').html(seminarData.pro.b);
		$('#c').html(seminarData.pro.c);
	}
});

function onClick(){
	$.ajax({
		url:"/seminar/"+seminarid,
		type:"PUT",
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
			window.location.href="../seminar/teacher_seminar_index.html?id="+seminarid;
		}
	});
};
	
function onReturn(){
	window.location.href="../seminar/teacher_seminar_index.html?id="+seminarid;
}