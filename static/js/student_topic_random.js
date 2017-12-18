// JavaScript Document
function getQueryString(name) { 
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
    var r = window.location.search.substr(1).match(reg); 
    if (r != null) return unescape(r[2]); return null; 
    };

var seminarId=getQueryString("id");
$.ajax({
    url:'/seminar/'+seminarId,
    type:'GET',
    success:function(data){
       $('#grouptype').html(data.groupMethod);
	 $('#begintime').html(data.startTime);
	  $('#endtime').html(data.endTime);
	  $('#topic0').html(data.name);   
       }
});

function uploadReport() 
{ 
document.getElementById("btn_file").click(); 
} 
function checkScore()
{
	window.location.href="student_grade.html";
}
	
function jumpToTopic()
{
	window.location.href="student_viewTopic_random.html";
	}