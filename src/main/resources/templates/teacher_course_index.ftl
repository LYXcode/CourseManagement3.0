<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,height=device-height,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>教师课程首页</title>
    <link href="../../css/teacher_course_index.css" rel="stylesheet" type="text/css"/>    
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="../../js/teacher_course_index.js"></script>
</head>
<body>
    	<div class="top">
        	<div class="font">
        		课堂管理系统
        	</div>
        	<div class="icon">
        		<img src="../../img/home.png" onClick="toIndex()">首页
        		<img src="../../img/help.png">帮助
        		<img src="../../img/exit.png">退出
        	</div>
        	<div class="clear"></div>
    	</div>
        <div class="body">
            <div class="navigation">
                <div class="courseName"><span class="courseNam">J2EE</span></div>
                <div class="line"></div>
                <div class="courseIntroduction"><span class="courseIntroduction">ooad is xxx</span></div>
            </div>
           <div class="content">
                <div class="classInfo">
                    <div class="title">课程班级</div>
                    <div class="returnButton" onclick="onReturn()">返回上一页</div>
                    <div class="line"></div>
                    <div class="blockBody">
                        <div class="block"><div class="blockFont"><span class="classItem">周三1-2节</span></div></div>
                        <div class="block"><div class="blockFont"><span class="classItem">周三3-4节</span></div></div>
                        <div class="block"><div class="blockFont"><span class="classItem">周三5-6节</span></div></div>
                         <div class="block">
                <img class="addImg" onclick="addClass()" src="../../img/smalladd.png" alt="添加">
            </div>

                    </div>
                </div>
                <div class="seminarInfo">
                    <div class="title">讨论课</div>
                    <div class="line"></div>
                    <div class="blockBody">
                       <div class="block"><div class="blockFont"><span class="seminarItem">讨论课1</span></div></div>
                        <div class="block"><div class="blockFont"><span class="seminarItem">讨论课2</span></div></div>
                        <div class="block"><div class="blockFont"><span class="seminarItem">讨论课3</span></div></div>
                        <div class="block"><div class="blockFont"><span class="seminarItem">讨论课4</span></div></div>
                        <div class="block"><div class="blockFont"><span class="seminarItem">讨论课5</span></div></div>
                        <div class="block"><div class="blockFont"><span class="seminarItem">讨论课6</span></div></div>
                       <div class="block">
                <img class="addImg"  onclick="addSeminar()" src="../../img/smalladd.png" alt="添加">
            </div>
                    </div>
                </div>
            </div>
            <div class="clear"></div>
        </div>
</body>
</html>