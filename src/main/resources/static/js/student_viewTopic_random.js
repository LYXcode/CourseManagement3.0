// JavaScript Document
function getQueryString(name) { 
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
    var r = window.location.search.substr(1).match(reg); 
    if (r != null) return unescape(r[2]); return null; 
    };
var topicId=getQueryString("id");

$.ajax({
    url:'/topic/'+topicId,
    type:'GET',
	beforeSend:function(request){
		request.setRequestHeader("token",localStorage.getItem("token"));
	},
    success:function(data){
       $('#name').html(data.name);
	 $('#discription').html(data.description);
	  $('#groupLimit').html(data.groupLimit);
	  $('#stuLimit').html(data.groupMemberLimit);	   
       }
});


	  
	
      
	