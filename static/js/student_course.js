// JavaScript Document


$.ajax({
    url:'/class?courseName=*&teacherName=*',
    type:'GET',
    success:function(data){
       $('#name').html(data.name);
	     $('#site').html(data.site);
		   $('#stuNum').html(data.numStudent);
		     $('#time').html(data.time);
       }
});

function onClick(){
	var id="5";
            	$.ajax({				
            		url:'/class/{classId}/student',
            		type:'POST',
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
	    success:function(data){
	       $('#name').html(data.name);
		     $('#site').html(data.site);
			   $('#stuNum').html(data.numStudent);
			     $('#time').html(data.time);
	       }
	});
}