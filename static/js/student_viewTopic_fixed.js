// JavaScript Document

$.ajax({
    url:'/seminar/{seminarId}',
    type:'GET',
    success:function(data){
       $('#name').html(data.name);
	 $('#discription').html(data.startTime);
	  $('#groupLimit').html(data.NOFOUND);
	  $('#stuLimit').html(data.NOFOUND);
	  
	
	
	
	   
       }
});

function onClick()
{
	var id="23",
	$.ajax({
    url:'/group/{groupId}/topic',
    type:'POST',
	contentType: 'application/json',
		data: JSON.stringify({
		"id":id.val(),
		
		}),
    success:function(data){
      
	  
	
	}
	$.ajax({
    url:'/group/{groupId}/topic',
    type:'POST',
	contentType: 'application/json',
		data: JSON.stringify({
		"id":id.val(),
		
		}),
    success:function(data){
      
	  
	
	}
	}