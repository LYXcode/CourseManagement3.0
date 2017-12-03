// JavaScript Document

$.ajax({
    url:'/seminar/{seminarId}',
    type:'GET',
    success:function(data){
       $('#grouptype').html(data.groupMethod);
	 $('#begintime').html(data.startTime);
	  $('#endtime').html(data.endTime);
	  $('#topic0').html(data.name);
	  
	
	
	
	   
       }
});

function onClick(){
	
}
function uploadReport(){
	
}

function checkScore()
{
	}
	
function jumpToTopic()
{
	}