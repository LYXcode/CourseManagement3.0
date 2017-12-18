function getQueryString(name) { 
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
    var r = window.location.search.substr(1).match(reg); 
    if (r != null) return unescape(r[2]); return null; 
    };

var groupId=5;
var classId=1;
function onClick(){
	$.ajax({
		url:"/class/"+classId+"/student",
	    type:'GET',
        success:function(userData){
            $('.number').html(userData[0].number);
			   $('.name').html(userData[0].name);
        }
	});
};
			
			
       function Add(){
            	$.ajax({
            		url:'/group/'+groupId+'/add',
            		type:'PUT',
					contentType:"application/json",
					data:JSON.stringify({
						"id":247
					}),
					success:function(){
						alert("添加成功");
					},
					success:function(){
						alert("已添加");
					}
            	});
            };
			
					
       function Alt(){
            	$.ajax({
            		url:'/group/'+groupId+'/remove',
            		type:'PUT',
					contentType:"application/json",
					data:JSON.stringify({
						"id":247
					}),
					success:function(){
						alert("删除成功");
					},
					success:function(){
						alert("已删除");
					}
            	});
            }