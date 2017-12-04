//JavaScript Document

$.ajax({
    url:"/class",
    type:'GET',
    success:function(data){
       $('#name').html(data.name);
	   $('#site').html(data.site);
	   //$('#teacher').html(data.name);
	   $('#course').html(data.course.name);
       }
});

$(function(){
	$('.delete_btn').click(function(){
		if(confirm("确定退选此课？"))
		{
			var classid=$(this).attr('name');
			
			$.ajax({
				url:"/course/"+classid,
				method:"DELETE",
				success:function(data){
					alert("删除成功");
					window.location.href="student_index.html";
				},
				error:function(data){
					alert("删除失败");
					window.location.href="student_index.html";
				}
			});
		}
	});
	});

$(function(){
	$('.course').click(function(){
			var classid=$(this).attr('data-course-id');
			window.location.href="../student/course/student_course_index.html?id="+classid;
	});
});
$(function(){
	$('.classinfo').click(function(){
			var classid=$(this).attr('data-course-id');
			window.location.href="../student/course/student_course_index.html?id="+classid;
	});
});