// JavaScript Document
function getQueryString(name) { 
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
    var r = window.location.search.substr(1).match(reg); 
    if (r != null) return unescape(r[2]); return null; 
    };
var classId=getQueryString("id");
var groupId;
$.ajax({
    url:'/class/'+classId+'/classgroup',
    type:'GET',
	beforeSend:function(request){
		request.setRequestHeader("token",localStorage.getItem("token"));
	},
    success:function(data){
        groupId=data.id;
      var leaderInfo="";
	  
	  leaderInfo=" <tr>"+
                              "<td name=\"role\">队长</td>"+
							  "<td name=\"number\">"+data.leader.number+"</td>"+
                             " <td name=\"leadername\">"+data.leader.name+"</td>"+
                            "</tr>";
							
		var membersInfo="";
		for(var i=0;i<data.members.length;i++)	
		{  var x1 =2;
		if(i%x1!=0)
			{membersInfo+=" <tr >"+
                              "<td  name=\"role\">队员</td>"+
							  "<td name=\"number\">"+data.members[i].number+"</td>"+
                             " <td name=\"memberrname\">"+data.members[i].name+"</td>"+
                            "</tr>";}
							
							else
							{
								membersInfo+=" <tr class=\"alt\">"+
                              "<td  name=\"role\">队员</td>"+
							  "<td name=\"number\">"+data.members[i].number+"</td>"+
                             " <td name=\"memberrname\">"+data.members[i].name+"</td>"+
                            "</tr>";
								}
							
			}	
			
			var groupInfo=leaderInfo+membersInfo;
			document.getElementById("groupInfo").innerHTML= groupInfo;			
	   
       }
});

function onClick(){
	
	window.location.href="student_addToGroup.html?classId="+classId+"&groupId="+groupId;
	}