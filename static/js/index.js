// JavaScript Document

     function onClick(){
    	 var user="";
    	 user=document.getElementsByTagName('input')[0].value;
    	 if(user=="teacher")
    		 {
        	 window.location.href="../teacher/teacher_index.html";
    		 }
    	 else
    	 window.location.href="../student/student_index.html";
}