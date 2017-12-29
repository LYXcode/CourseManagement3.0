// JavaScript Document
function getQueryString(name) { 
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
    var r = window.location.search.substr(1).match(reg); 
    if (r != null) return unescape(r[2]); return null; 
    };

var seminarId=getQueryString("seminarId");
var classId=getQueryString("classId");
$.ajax({
    url:'/seminar/'+seminarId,
    type:'GET',
	beforeSend:function(request){
		request.setRequestHeader("token",localStorage.getItem("token"));
	},
    success:function(data){
        $('#description').html(data.description);
       $('#grouptype').html(data.groupMethod);
	 $('#begintime').html(data.startTime);
	  $('#endtime').html(data.endTime);
	  $('#topic0').html(data.name);
       }
});
$.ajax({
    url:'/seminar/'+seminarId+'/topic',
    type:'GET',
    beforeSend:function(request){
        request.setRequestHeader("token",localStorage.getItem("token"));
    },
    success:function(data){
      var topicsInfo="";
      for(var i=0;i<data.length;i++)
      {
          topicsInfo+="<div class=\"smallblock\">"+
                "<div class=\"blockFont\" id=\""+data[i].id+"\">"+"话题 "+data[i].serial+"</div>"+
                "</div>";
                
          }
      document.getElementById("topics").innerHTML=topicsInfo;
       }
});

function uploadReport() 
{ 
document.getElementById("btn_file").click(); 
} 

function checkScore()
{
    window.location.href="student_grade.html?id="+seminarId;
}
	
$(function(){
    $('.blockFont').click(function(){
            var topicId=$(this).attr('id');
            $.ajax({
                url:"/topic/"+topicId,
                method:"GET",
                beforeSend:function(request){
                    request.setRequestHeader("token",localStorage.getItem("token"));
                },
                content:"application/json",
                success:function(data){
                window.location.href="student_viewTopic_fixed.html?topicId="+topicId+"&classId="+classId;
                },
            });
    });
});