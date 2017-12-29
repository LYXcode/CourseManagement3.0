//JavaScript Document

$.ajax({
    url:"/class",
    type:'GET',
        beforeSend:function(request){
        request.setRequestHeader("token",localStorage.getItem("token"));
    },
    success:function(data){
       var courseInfo="";
	   
	   for(var i=0;i<data.length;i++)
	   {
		   courseInfo+="<div class=\"main_box_right_content\">"+
                "<h3 class=\"classtitle\"><span name=\"course\" data-course-id="+data[i].courseId+ "data-class-id="+data[i].id+">"+data[i].courseName+"</span>"+
                    "<button name="+data[i].id+" class=\"delete_btn\">退选课程</button>"+
                "</h3>"+
                "<div class=\"divideline\"></div>"+
                "<div  class=\"classinfo\" data-course-id="+data[i].courseId+" data-class-id="+data[i].id+">"+
                        "<table class=\"table\">"+
                           " <tr>"+
                               " <td class=\"tabletext\">班级：<span name=\"classname\">"+data[i].name+"</span></td>"+
                               " <td class=\"tabletext\" name=\"site\">课程地点："+data[i].site+"</td>"+
                            "</tr>"+
                           "<tr>"+
                               "<td class=\"tabletext\" name=\"teacher\">教师："+data[i].courseTeacher+"</td>"+
                               "<td class=\"tabletext\"></td>"+
                            "</tr>"+
                        "</table>"+
                "</div>"+
              "</div>";
		   }
		   document.getElementById("courses").innerHTML=courseInfo;
	           $('.course').click(function(){
            var courseId=$(this).attr('data-course-id');
            var classId=$(this).attr('data-class-id');
            window.location.href="../student/course/student_course_index.html?courseId="+courseId+"&classId="+classId;
    });
    $('.classinfo').click(function(){
            var courseId=$(this).attr('data-course-id');
            var classId=$(this).attr('data-class-id');
            window.location.href="../student/course/student_course_index.html?courseId="+courseId+"&classId="+classId;
    });
        $(".delete_btn").click(function(){
        if(confirm("确定退选此课？"))
        {
            var classid=$(this).attr('name');
            alert(classid);
            $.ajax({
                url:"/class/"+classid+"/student/"+2,
                method:"DELETE",
                beforeSend:function(request){
                    request.setRequestHeader("token",localStorage.getItem("token"));
                },
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
       }

});

$(function(){
	$(".delete_btn").click(function(){
		if(confirm("确定退选此课？"))
		{
			var classid=$(this).attr('name');
			alert(classid);
			$.ajax({
				url:"/class/"+classid+"/student/"+2,
				method:"DELETE",
				beforeSend:function(request){
					request.setRequestHeader("token",localStorage.getItem("token"));
				},
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
			var courseId=$(this).attr('data-course-id');
			var classId=$(this).attr('data-class-id');
			window.location.href="../student/course/student_course_index.html?courseId="+courseId+"&classId="+classId;
	});
});
$(function(){
	$('.classinfo').click(function(){
			var courseId=$(this).attr('data-course-id');
			var classId=$(this).attr('data-class-id');
			window.location.href="../student/course/student_course_index.html?courseId="+courseId+"&classId="+classId;
	});
});