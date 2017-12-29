// JavaScript Document
$.ajax({
    url:'/seminar/{seminarId}/grade',
    type:'GET',
	beforeSend:function(request){
		request.setRequestHeader("token",localStorage.getItem("token"));
	},
    success:function(data){
     var gradeInfo="";
	 /* vo.SeminarGradeDetail*/
	 for(var i=0;i<data.length;i++)
	 {
		 var reportInfo ="已提交";
		 if(data[i].reportGrade===null)
		 {
			 reportInfo ="未提交";
			 }
		gradeInfo+="<tr>"+
                    "<td>"+  test[0].name         +"</td>"+
                   " <td>"+ data[i].groupName  +"</td>"+
                    "<td>"+  data[i].leaderName       +"</td>"+
                    "<td>"+  data[i].presentationGrade        +"</td>"+
                    "<td>"+  reportInfo   +"</td>"+
                    "<td>"+   data[i].reportGrade       +"</td>"+
                    "<td>"+  data[i].grade       +"</td>"+
                    "<td>"+
                        "<img src=\"../../../Img/view.png\" alt=\"预览\">"+
                        "<img src=\"../../../Img/download.png\" alt=\"下载\">"+
                    "</td>"+
                "</tr>";
		 }
		 
		  document.getElementById("grades").innerHTML=gradeInfo; 
       }
});