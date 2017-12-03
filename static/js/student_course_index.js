// JavaScript Document

$.ajax({
    url:'/class',
    type:'GET',
    success:function(data){
       $('#name').html(data.name);
	   $('#site').html(data.site);
	   $('#teacher').html(data.name);
	   $('#course').html(data.course.name);
	  
       }
});
