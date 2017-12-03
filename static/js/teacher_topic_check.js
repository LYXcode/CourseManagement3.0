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
	url:"/topic/"+topicid,
	type:'GET',
	success:function(topicData){
		$('#name').html(topicData.name);
		$('#description').html(topicData.description);
		$('#groupLimit').html(topicData.groupLimit);
		$('#groupMemberLimit').html(topicData.groupMemberLimit);
		$('#groupLeft').html(topicData.groupLeft);
	}
});

function onUpdate(){
	window.location.href="../topic/teacher_topic_edit.html?id="+topicid;
};

function onDelete(){
		if(confirm("确定删除此话题？"))
		{
			$.ajax({
				url:"/topic/"+topicid,
				method:"DELETE",
				success:function(deleteData){
					alert("删除成功");
					window.location.href="../seminar/teacher_seminar_index.html?id="+seminarid;
				},
				error:function(deleteData){
					alert("删除失败");
					window.location.href="../seminar/teacher_seminar_index.html?id="+seminarid;
				}
			});
		}
	};
	
function onReturn(){
	window.location.href="../seminar/teacher_seminar_index.html?id="+seminarid;
}