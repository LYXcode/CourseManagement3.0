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


	  
	
      
	