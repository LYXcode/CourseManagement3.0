// JavaScript Document
$.ajax({
	url:'/course',
	type:'GET',
	contentType: 'application/json',
	success:function(data){
		$('#cour1').html(data.name);
		$('#classNum').html(data.classNum);
		$('#stuNum').html(data.stuNum);
		$('#beginTime').html(data.beginTime);
		$('#endTime').html(data.endTime);
	}
});

function onPlus(){
	window.location.href="course/teacher_course_new.html";
};
$(function(){
$('.delete_btn').click(function(){
	if(confirm("确定删除此课？"))
	{
		var courseid=$(this).attr('name');
		
		$.ajax({
			url:"/course/"+courseid,
			method:"DELETE",
			content:"application/json",
			success:function(data){
				alert("删除成功");
				window.location.href="teacher_index.html";
			},
			error:function(data){
				alert("删除失败");
				window.location.href="teacher_index.html";
			}
		});
	}
});
});

$(function(){
	$('.update_btn').click(function(){
		alert("还没做");
	});
});

$(function(){
	$('.classtitle').click(function(){
		var courseid=$(this).attr('data-course-id');
		window.location.href="../teacher/course/teacher_course_index.html?id="+courseid;
	});
});

$(function(){
	$('.classinfo').click(function(){
		var courseid=$(this).attr('data-course-id');
		window.location.href="../teacher/course/teacher_course_index.html?id="+courseid;
	});
});
