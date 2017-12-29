function getQueryString(name) { 
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
    var r = window.location.search.substr(1).match(reg); 
    if (r != null) return unescape(r[2]); return null; 
    };
    var courseId=getQueryString("id");
function onClick(){
	$.ajax({
		url:"/course"+courseId,
		type:"PUT",
		beforeSend:function(request){
			request.setRequestHeader("token",localStorage.getItem("token"));
		},
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
function toIndex(){
		window.location.href="../teacher_index.html"
		}