function getQueryString(name) { 
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
    var r = window.location.search.substr(1).match(reg); 
    if (r != null) return unescape(r[2]); return null; 
    };
var courseid=2;
var classid=getQueryString("id");
$.ajax({
    url:"/course/"+courseid,
    type:"GET",
    success:function(courseData){
        $('.courseName').html(courseData.name);
        $('.courseIntroduction').html(courseData.description);
    }
});
$.ajax({
	url:"/class/"+classid,
	type:'GET',
	success:function(classData){
		$('.title').html(classData.name);
		$('#name').html(classData.name);
		$('#site').html(classData.site);
		$('#time').html(classData.time);
		$('#presentation').html(classData.pro.presentation);
		$('#report').html(classData.pro.report);
		$('#a').html(classData.pro.a);
		$('#b').html(classData.pro.b);
		$('#c').html(classData.pro.c);
	}
});

function onUpdate(){
	window.location.href="../class/teacher_class_edit.html?id="+classid;
};

function onDelete(){
		if(confirm("确定删除此班？"))
		{
			$.ajax({
				url:"/class/"+classid,
				method:"DELETE",
				success:function(deleteData){
					alert("删除成功");
					window.location.href="../teacher_course_index.html?id="+courseid;
				},
				error:function(deleteData){
					alert("删除失败");
					window.location.href="../teacher_course_index.html?id="+courseid;
				}
			});
		}
	};

function onReturn(){
	window.location.href="../teacher_course_index.html?id="+courseid;
}