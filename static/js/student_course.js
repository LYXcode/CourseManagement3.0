// JavaScript Document


$.ajax({
    url:'/class?courseName=*&teacherName=*',
    type:'GET',
    success:function(data){
       $('#name').html(data.name);
	     $('#site').html(data.site);
		   $('#stuNum').html(data.stuNum);
		     $('#time').html(data.time);
       }
});

function onClick(){
            	$.ajax({
					var id="5",
            		url:'/class/{classId}/student',
            		type:'POST',
					contentType: 'application/json',
					data: JSON.stringify({
		"id":id.val();
		),
                    success:function(data){
                       
                      
                       }
            	});
            }