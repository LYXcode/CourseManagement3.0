// JavaScript Document


$.ajax({
    url:'/class?courseName=*&teacherName=*',
    type:'GET',
	beforeSend:function(request){
		request.setRequestHeader("token",localStorage.getItem("token"));
	},
    success:function(data){
       var courses="";
	   for(var i=0;i<data.length;i++)
	   {
		 courses+=" <div class=\"main_box_right_content\"> "+
				"<h3 class=\"classtitle\">"+  data[i].courseName +
					"<button name=\"choose\" onClick=\"onClick()\">选择课程</button>"+
                "</h3>"+
			 "<div class=\"divideline\"></div>"+
			
			
			"<div  class=\"classinfo\">"+
			
					         "<table class=\"table\">"+
               
			   
			    "<tr>"+
                    "<td class=\"tabletext\">班级:"+
                        "<span name=\"name\">"+data[i].name+"</span>"+
                   " </td>"+  
                    "<td class=\"tabletext\">课程地点："+
                        "<span name=\"site\">"+  data[i].site +"</span>"+
                    "</td>"+
                "</tr>"+
                "<tr>"+
                    "<td class=\"tabletext\">班级人数："+
                    "<span name=\"stuNumber\">"+data[i].numStudent+"</span>"+
                "</td>"+
                    "<td class=\"tabletext\">时间："+
                    "<span name=\"time\">"+data[i].time+"</span>"+
                "</td>"+
                "</tr>"+
                "</table>"+
			
			
			
				"</div>"+
		    "</div>";
			
			
		   }
		 document.getElementById("courses").innerHTML=courses;  
		   
       }
});

function onClick(){
	var id="5";
            	$.ajax({				
            		url:'/class/'+id+'/student',
            		type:'POST',
            		beforeSend:function(request){
            			request.setRequestHeader("token",localStorage.getItem("token"));
            		},
					contentType: 'application/json',
					data: JSON.stringify({
						"id":id
					}),
                    success:function(data){
                       alert("选课成功");
                      window.location.href="student_course.html";
                       },
                       error:function(data){
                           alert("选课失败");
                          window.location.href="student_course.html";
                           }
        });
};

function onSearch(){
	$.ajax({
	    url:"/class?courseName="+$('#course')+"&teacherName="+$('teacher'),
	    type:'GET',
		beforeSend:function(request){
			request.setRequestHeader("token",localStorage.getItem("token"));
		},
	    success:function(data){
	       $('#name').html(data.name);
		     $('#site').html(data.site);
			   $('#stuNum').html(data.numStudent);
			     $('#time').html(data.time);
	       }
	});
}