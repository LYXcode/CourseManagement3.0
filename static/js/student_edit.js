// JavaScript Document

     function onClick(){
            	$.ajax({
            		url:'/me',
            		type:'GET',
                    success:function(data){
                       //$('.username').html(data.name);
                       window.location.href='user.html';
                       }
            	});
            }