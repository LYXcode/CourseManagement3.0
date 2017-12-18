// JavaScript Document
$.ajax({
    url:'/me',
    type:'GET',
    success:function(data){
    	var inp=new Array();
    	for(var i=0;i<7;++i)
    		inp[i]=document.getElementsByTagName('input')[i];
    	$('#username').html(data.phone);
    	inp[1].value=data.name;
	  	//inp[3].value=data.school;
	  	inp[4].value=data.type;
	  	inp[5].value=data.email;
	  	inp[6].value=data.phone;
	  	inp[2].value=data.gender;
	  	//inp[0].value=data.stuffNum;
       }
});
function onClick(){
	$.ajax({
		url:'/me',
		type:'PATCH',
		contentType: 'application/json',
		data: JSON.stringify({
		"phone":$('#phone').val(),
		//"gender":$('#gender').val(),
	    "name":$('#name').val(),
	    //"school":$('#university').val(),
	    //"type":$('#title').val(),
	    "number":$('#number').val(),
	    "email":$('#E-Mail').val()
		}),
		success:function(data){
			window.location.href="teacher_user.html";
		}
	});	
};
