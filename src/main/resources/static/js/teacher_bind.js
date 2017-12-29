function onClick(){	
$.ajax({
		url:'/me',
		type:'PUT',
		beforeSend:function(request){
			request.setRequestHeader("token",localStorage.getItem("token"));
		},
		contentType: 'application/json',
		data: JSON.stringify({
			var checked="",
			var all=document.getelementsbytagname("input");
			for(var i=0;i<e.length;++i)
				if(all[i].type=="radio"&&all[i].name=="gender"&&all[i].checked)
					checked=all[i].value;
		"phone":$('#phone').val(),
		//"gender":$('#gender').val(),
	    "name":$('#name').val(),
	    //"gender":checked.val(),
	    "school":$('#university').val(),
	    //"title":$('#title').val(),
	    "number":$('#number').val(),
	    "email":$('#E-Mail').val()
		}),
		success:function(data){
			window.location.href="teacher_index.html";
		}
	});	
}
function toIndex(){
		window.location.href="teacher_index.html"
		}