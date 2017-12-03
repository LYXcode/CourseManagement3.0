function onClick(){	
$.ajax({
		url:'/me',
		type:'PUT',
		contentType: 'application/json',
		data: JSON.stringify({
			var checked="",
			var all=document.getelementsbytagname("input");
			for(var i=0;i<e.length;++i)
				if(all[i].type=="radio"&&all[i].name=="gender"&&all[i].checked)
					checked=all[i].value;
		"phone":$('#phone').val(),
		"gender":$('#gender').val(),
	    "name":$('#name').val(),
	    "gender":checked.val(),
	    "school":$('#university').val(),
	    "type":$('#title').val(),
	    "stuffNum":$('#number').val(),
	    "email":$('#E-Mail').val()
		}),
		success:function(data){
			window.location.href="teacher_index.html";
		}
	});	
}