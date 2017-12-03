// JavaScript Document
$.ajax({
    url:'/group/{groupId}/grade',
    type:'GET',
    success:function(data){
       $('#topicID').html(data.presentation.topicId);
	    $('#reportScore').html(data.presentation.reportGrade);
		 $('#grade').html(data.presentation.grade);
       }
});