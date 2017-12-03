function getQueryString(name) { 
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
    var r = window.location.search.substr(1).match(reg); 
    if (r != null) return unescape(r[2]); return null; 
    };

var topicid=getQueryString("id");
var courseid=2;
var seminarid=2;

$.ajax({
    url:"/course/"+courseid,
    type:"GET",
    success:function(courseData){
        $('.courseName').html(courseData.name);
        $('.courseIntroduction').html(courseData.description);
    }
});
$.ajax({
	url:"/topic/"+topicid,
	type:'GET',
	success:function(topicData){
		$('#name').html(topicData.name);
		$('#description').html(topicData.description);
		$('#groupLimit').html(topicData.groupLimit);
	}
});

function onClick(){
	$.ajax({
		url:"/topic/"+topicid,
		type:'PUT',
		contentType:"application/json",
		data:JSON.stringify({
			"name":$("#name").val(),
			"description":$('#description').val(),
			"groupLimit":$('#groupLimit').val()
		}),
		success:function(topicData){
			window.location.href="../topic/teacher_topic_check.html?id="+topicid;
		}
	});
};

function onReturn(){
	window.location.href="../topic/teacher_topic_check.html?id="+topicid;
}