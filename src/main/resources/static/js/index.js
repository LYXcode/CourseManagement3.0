function onClick(){
	var userName=document.getElementsByTagName("input")[0].value;
    $.ajax({
        type:"POST",
        url:"/signin",
    	beforeSend:function(request){
    		request.setRequestHeader("token",localStorage.getItem("token"));
    	},
        contentType:"application/json",
        data:JSON.stringify({
            "user":$("#username").val(),
            "password":$("#password").val()
        }), 
        success:function(data){
            alert("欢迎");
            localStorage.setItem("token",data[1]);
            if(data[0]==1)
            {
                window.location.href="../teacher/teacher_index.html";
            }
            else
            window.location.href="../student/student_index.html";
        },
        error:function(data){
            alert("用户名或密码错误");
        }
    });
    }