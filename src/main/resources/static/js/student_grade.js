// JavaScript Document
function getQueryString(name) { 
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
    var r = window.location.search.substr(1).match(reg); 
    if (r != null) return unescape(r[2]); return null; 
    };
var seminarId=getQueryString("id");
$.ajax({
    url:'/seminar/'+seminarId+'/grade',
    type:'GET',
	beforeSend:function(request){
		request.setRequestHeader("token",localStorage.getItem("token"));
	},
    success:function(data){
      var gradeInfo="";
	  for(var i=0;i<data.length;i++)
	  {
		  var average;
		  var total =0;
		  
		  //for(var j=0;j<data.presentationGrade.length();i++)
			  //total+=data.presentationGrade[i];
			 // average = total/data.presentationGrade.length;
			 /*计算平均得分*/
			  
		  gradeInfo+="<tr>"+
                             " <td name=\"seminarId\">"+  data[i].seminarName   +"</td>"+
							  "<td  name=\"group\">"+ data[i].groupName +"</td>"+
                              "<td name=\"leader\">"+data[i].leaderName+"</td>"+
							  "<td name=\"presentation\">"+ data[i].presentationGrade +"</td>"+
							 " <td name=\"report\">"+  data[i].reportGrade  +"</td>"+
							  "<td name=\"score\">"+ data[i].grade  +"</td>"+
                           " </tr>";
						   
		  }
		  document.getElementById("gradeList").innerHTML=gradeInfo;

       }
});