<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>创建班级</title>
    <link href="../css/teacher_class_new.css" rel="stylesheet" type="text/css"/>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    //<script src="../js/teacher_class_new.js"></script>
</head>
<body>
        <div class="top">
          <div class="font">
            课堂管理系统
          </div>
          <div class="icon">
           <img src="../img/home.png" onClick="toIndex()">首页
            <img src="../img/help.png">帮助
            <img src="../img/exit.png">退出
          </div>
          <div class="clear"></div>
        </div>
        <div class="body">
            <div class="navigation">
                <div class="courseName">OOAD</div>
                <div class="line"></div>
                <div class="courseIntroduction">ooad is xxx</div>
            </div>
            <div class="content">
                <div class="block">
                    <div class="title">创建班级</div>
                    <div class="returnButton" onClick="onReturn()">返回上一页</div>
                    <div class="line"></div>
                    <div class="itemBody">
                        <div class="item">
                          <label class="itemName">班级名称:</label>
                          <input type="text" id="className" class="bigInput">
                        </div>
                        <div class="item">
                          <label class="itemName">班级代号:</label>
                          <input type="text" id="classNickname" class="bigInput">
                        </div>
                        <div class="item">
                          <label class="itemName">上课时间:</label>
                          <select class="bigSelect"><option class="itemName">单周</option><option class="itemName">双周</option><option class="itemName">每周</option></select>
                          <select class="smallSelect"><option class="itemName">周一</option><option class="itemName">周二</option><option class="itemName">周三</option><option class="itemName">周四</option><option class="itemName">周五</option></select>
                          <select class="smallSelect"><option class="itemName">12节</option><option class="itemName">34节</option><option class="itemName">56节</option><option class="itemName">78节</option><option class="itemName">910节</option><option class="itemName">11节</option></select>
                          <button id="btn" class="addButton" onclick="showHide()">添加</button>
                        </div>
                        <div id="yuansu" class="item" style="display:none">
                          <label class="itemName">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                          <select class="bigSelect"><option class="itemName">单周</option><option class="itemName">双周</option><option class="itemName">每周</option></select>
                          <select class="smallSelect"><option class="itemName">周一</option><option class="itemName">周二</option><option class="itemName">周三</option><option class="itemName">周四</option><option class="itemName">周五</option></select>
                          <select class="smallSelect"><option class="itemName">12节</option><option class="itemName">34节</option><option class="itemName">56节</option><option class="itemName">78节</option><option class="itemName">910节</option><option class="itemName">11节</option></select>
                          
                        </div>
                        <script>
function showHide(){
    var btn = document.getElementById('btn');
    var yuansu = document.getElementById('yuansu');
    if(yuansu.style.display == "block"){
        yuansu.style.display = "none";
    }else{
        yuansu.style.display = "block";
    }
}
</script>
                        <div class="item">
                          <label class="itemName">评分规则:</label>
                          <label class="itemName">讨论课分数占比</label>
                          <input type="text" onchange="if(/\D/.test(this.value)){alert('只能输入数字');this.value='';}" id="presentation" class="smallInput">
                          <label class="itemName">报告分数占比</label>
                          <input type="text" onchange="if(/\D/.test(this.value)){alert('只能输入数字');this.value='';}" id="report" class="smallInput">
                        </div>
                        <div class="item" style="margin-left: 18%">
                          <label class="itemName">5分占比</label>
                          <input type="text" onchange="if(/\D/.test(this.value)){alert('只能输入数字');this.value='';}" id="a" class="smallInput">
                          <label class="itemName">4分占比</label>
                          <input type="text" onchange="if(/\D/.test(this.value)){alert('只能输入数字');this.value='';}" id="b" class="smallInput">
                          <label class="itemName">3分占比</label>
                          <input type="text" onchange="if(/\D/.test(this.value)){alert('只能输入数字');this.value='';}" id="c" class="smallInput">
                        </div>
                        <form method="POST" action="/upload/classroster" enctype="multipart/form-data">
                        <div class="item">
                          <label class="itemName">导入学生名单:</label>
                          <label class="itemName">文件名</label>
                         <input type="file" name="btn_file" id="btn_file" style="display:none">
                          <button class="selectFile" type="button" onClick="uploadReport()">选择文件</button>
                        </div>
                        <div class="item">
                        
                          <button class="submit" type="submit">提交</button>
                          <button class="reset">重置</button>
                          
                          <div class="clear"></div>
                        
                        </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="clear"></div>
        </div>
</body>
</html>