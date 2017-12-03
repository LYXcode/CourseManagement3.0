function onClick(){
	$.ajax({
		url:"/course",
		type:"POST",
		contentType:"application/json",
		data: JSON.stringify({
			"name":$("#name").val(),
			"description":$("#description").val(),
			"startTime":$("#startTime").val(),
			"pro":{
				"c":$("#c").val(),
				"b":$("#b").val(),
				"a":$("#a").val(),
				"report":$("#report").val(),
				"presentation":$("#presentation").val()
			}
		}),
		success:function(data){
			window.location.href="../teacher_index.html";
		}
	});
}