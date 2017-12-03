// JavaScript Document


$.ajax({
    url:'/me',
    type:'GET',
    success:function(data){
       $('#username').html(data.number);
	   $('#name').html(data.name);
	   $('#universiity').html(data.school);
	   $('#title').html(data.title);
	   $('#E-mail').html(data.email);
	   $('#phone').html(data.phone);
	   $('#gender').html(data.gender);
	  
       }
});

 function onClick(){
            	$.ajax({
            		url:'/me',
            		type:'GET',
                    success:function(data){
                       //$('.username').html(data.name);
                      window.location.href='edit.html';
                       }
            	});
            }
			
	
