// JavaScript Document
function getQueryString(name) { 
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
    var r = window.location.search.substr(1).match(reg); 
    if (r != null) return unescape(r[2]); return null; 
    };

var groupId=getQueryString("id");
var classId=1;
       function onClick(){
            	$.ajax({
            		url:'/class/'+classId+'/student?nameBeginWith=张',
            		type:'GET',
                    success:function(userData){
                      $('.number').html(userData.number);
					   $('.name').html(userData.name);
                       }
            	});
            }
			
			
       function Add(){
            	$.ajax({
            		url:'/group/'+groupId+'/add',
            		type:'PUT',
					contentType:"application/json",
					data:JSON.stringify({
						"id":247
					})
            	});
            }
			
					
       function Alt(){
            	$.ajax({
            		url:'/group/'+groupId+'/remove',
            		type:'PUT',
					contentType:"application/json",
					data:JSON.stringify({
						"id":247
					})
            	});
            }