function getQueryString(name) { 
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
    var r = window.location.search.substr(1).match(reg); 
    if (r != null) return unescape(r[2]); return null; 
    };
    
var courseid=getQueryString("id")[0];
var classid=getQueryString("id")[1];
$.ajax({
    url:"/course/"+courseid,
    type:"GET",
    success:function(data){
        $('.courseName').html(data.name);
        $('.courseIntroduction').html(data.description);
    }
});
$.ajax({
	url:"/class"+classid,
	type:'GET',
	success:function(data){
		$('.title').html(data.name);
		$('#name').html(data.name);
		$('#site').html(data.site);
		$('#time').html(data.time);
		$('#presentation').html(data.pro.presentation);
		$('#report').html(data.pro.report);
		$('#a').html(data.pro.a);
		$('#b').html(data.pro.b);
		$('#c').html(data.pro.c);
	}
});

function onUpdate(){
	window.location.href="../class/teacher_class_edit?id="+classid;
};

function onDelete(){
	
}
