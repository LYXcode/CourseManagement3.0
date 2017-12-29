// JavaScript Document
function getQueryString(name) { 
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
    var r = window.location.search.substr(1).match(reg); 
    if (r != null) return unescape(r[2]); return null; 
    };
var topicId=getQueryString("topicId");
var classId=getQueryString("classId");

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
            var selectInfo="";
      if(data.groupLeft>0){
          selectInfo+="<div class=\"modifyButton\" id=\"selectTopic\" onclick=\"onClick()\"> 选择话题 </div>";
          }
          
          document.getElementById("selectTopic").innerHTML=selectInfo;
           
       }
});

function onClick(){
$.ajax({
    url:'/group/'+groupId+'/topic',
    type:'POST',
    beforeSend:function(request){
        request.setRequestHeader("token",localStorage.getItem("token"));
    },
    success:function(data){
        "id":topicId
    }
});
};


      
    
      
    