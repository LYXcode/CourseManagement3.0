// JavaScript Document
$.ajax({
	url:'/course',
	type:'GET',
	   beforeSend:function(request){
        request.setRequestHeader("token",localStorage.getItem("token"));
    },
	contentType: 'application/json',
	success:function(data){
		var courses="";
		for(var i=0;i<data.length;i++)
		{
			courses+="<div class=\"main_box_right_content\">"+
				"<h3 class=\"classtitle\">"+
				    "<span id=\""+data[i].id+"\"  data-course-id=\""+data[i].id+"\" onclick=\"onSelect()\">" +  
					data[i].name  +"</span>"+
					"<button class=\"delete_btn\" name=\"2\" id=\""+data[i].id+"\">删除课程</button>"+
					"<button class=\"update_btn\" name=\"2\" id=\""+data[i].id+" \">修改课程</button>"+
				"</h3>"+
				"<div class=\"divideline\"></div>"+
				"<div class=\"classinfo\" data-course-id=\" "  +data[i].id+ " \" onclick=\"onSelect()\">"+
				
			  
			  
			    "<table class=\"table\">"+
                "<tr>"+
                "<td class=\"tabletext\">班级数：<span name=\"classNum\">"+data[i].numClass +"</span></td>"+
                "<td class=\"tabletext\">学生人数：<span name=\"stuNum\" id=\" "+ data[i].numStudent +"\">"+test[0].age +
				" </span></td>"+
                "</tr>"+
                 "<tr>"+
               "<td class=\"tabletext\">开始时间：<span name=\"beginTime\">"+ data[i].startTime+ "</span></td>"+
               " <td class=\"tabletext\">结束时间:<span name=\"endTime\"> "+ data[i].endTime+ "</span></td>"+
                "</tr>"+
                "</table>"+			  
			  
                "</div>"+
				"</div>"
				;
			
			}
			document.getElementById("courses").innerHTML=courses; 
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
			beforeSend:function(request){
				request.setRequestHeader("token",localStorage.getItem("token"));
			},
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
		var courseid=$(this).attr('name');
		window.location.href="../course/teacher_course_edit.html?id="+courseid;
	});
});

$(function(){
	$('.title').click(function(){
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
function toIndex(){
		window.location.href="teacher_index.html"
		}
