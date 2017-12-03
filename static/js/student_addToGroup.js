// JavaScript Document



       function onClick(){
            	$.ajax({
            		url:'/class/{classId}/student?nameBeginWith=张',
            		type:'GET',
                    success:function(data){
                      $('.number').html(data.number);
					   $('.name').html(data.name);
                      
                       }
            	});
            }
			
			
       function Add(){
            	$.ajax({
            		url:'/me',
            		type:'GET',
                    success:function(data){
                     
                       }
            	});
            }
			
					
       function Alt(){
            	$.ajax({
            		url:'/me',
            		type:'GET',
                    success:function(data){
                     
                       }
            	});
            }