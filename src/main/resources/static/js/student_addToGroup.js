function getQueryString(name) { 
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
    var r = window.location.search.substr(1).match(reg); 
    if (r != null) return unescape(r[2]); return null; 
    };
var classId=getQueryString("classId");
var groupId=getQueryString("groupId");
var numBeginWith="";
var nameBeginWith="";
    $.ajax({
        url:"/class/"+classId+"/student?numBeginWith=null&nameBeginWith=null",
        type:'GET',
        beforeSend:function(request){
            request.setRequestHeader("token",localStorage.getItem("token"));
            
        },
        success:function(userData){
           var stuInfo="";
           for(var i=0;i<userData.length;i++)
           {
               stuInfo+="<tr>"+
                              "<td><span class=\"number\">"+userData[i].number+"</span></td>"+
                             " <td><span class=\"name\">"+userData[i].name+"</span></td>"+
                              "<td><img src=\"../../img/home.png\" class=\"add1\" data-user-id="+userData[i].id+"></td>"+
                            "</tr>";
               
               }
               
               document.getElementById("newMember").innerHTML=stuInfo;
                $('.add1').click(function(){
                var userId=$(this).attr('data-user-id');
                $.ajax({
                    url:'/group/'+groupId+'/add',
                    type:'PUT',
                    beforeSend:function(request){
                        request.setRequestHeader("token",localStorage.getItem("token"));
                    },
                    contentType:"application/json",
                    data:JSON.stringify({
                        "id":userId
                    }),
                    success:function(){
                        alert("添加成功");
                        location.reload();
                    }
                });
            });
        }
    });

	$.ajax({
		url:"/class/"+classId+"/classgroup",
	    type:'GET',
		beforeSend:function(request){
			request.setRequestHeader("token",localStorage.getItem("token"));
		},
        success:function(userData){
        	var leaderInfo="";
			leaderInfo="<tr>"+
                              "<td name=\"leader\">队长</td>"+
							  "<td name=\"number\">"+userData.leader.number+"</td>"+
                              "<td name=\"name\">"+userData.leader.name+"</td>"+
							  "<td></td>"+
                          "</tr>";
						  
			var membersInfo="";
			for(var i=0;i<userData.members.length;i++)	
			{
				membersInfo+="<tr>"+
				             "<td name=\"member\">队员</td>"+
                              "<td><span class=\"number\">"+userData.members[i].number+"</span></td>"+
							 " <td><span class=\"name\">"+userData.members[i].name+"</span></td>"+
							  "<td><img src=\"../../img/home.png\" class=\"delete\" data-user-id="+userData.members[i].id+"></td>"+
                            "</tr>";
				}	
				
				document.getElementById("groupInfo").innerHTML=leaderInfo+membersInfo;	 
				    $('.delete').click(function(){
                var userId=$(this).attr('data-user-id');
                $.ajax({
                    url:'/group/'+groupId+'/remove',
                    type:'PUT',
                    beforeSend:function(request){
                        request.setRequestHeader("token",localStorage.getItem("token"));
                    },
                    contentType:"application/json",
                    data:JSON.stringify({
                        "id":userId
                    }),
                    success:function(){
                        alert("删除成功");
                        location.reload();
                    }
                });
            }); 
        }
	});

function onClick(){
	$.ajax({
        url:"/class/"+classId+"/student?numBeginWith="+$('#numBeginWith').val()+"&nameBeginWith="+$('#nameBeginWith').val(),
	    type:'GET',
		beforeSend:function(request){
			request.setRequestHeader("token",localStorage.getItem("token"));
		},
        success:function(userData){
           var stuInfo="";
		   for(var i=0;i<userData.length;i++)
		   {
			   stuInfo+="<tr>"+
                              "<td><span class=\"number\">"+userData[i].number+"</span></td>"+
							 " <td><span class=\"name\">"+userData[i].name+"</span></td>"+
							  "<td><img src=\"../../img/home.png\" class=\"add1\" data-user-id="+userData[i].id+"></td>"+
                            "</tr>";
			   
			   }
			   
			   document.getElementById("newMember").innerHTML=stuInfo;
			       $('.add1').click(function(){
                var userId=$(this).attr('data-user-id');
                $.ajax({
                    url:'/group/'+groupId+'/add',
                    type:'PUT',
                    beforeSend:function(request){
                        request.setRequestHeader("token",localStorage.getItem("token"));
                    },
                    contentType:"application/json",
                    data:JSON.stringify({
                        "id":userId
                    }),
                    success:function(){
                        alert("添加成功");
                        location.reload();
                    }
                });
            });
        }
	});
};	   				