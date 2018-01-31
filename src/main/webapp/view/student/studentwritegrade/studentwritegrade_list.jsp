<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib  uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>

<%@ include file="/view/public/common.jspf" %>

</head>

<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">学员管理</a></li>
        <li>学生成绩</li>
    </ul>
</div>

<form action="${pageContext.request.contextPath}/student/studentwritegrade/list.action " method="post" class="form-horizontal">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

    <div class="col-sm-2">学员名字:</div>
	    <div class="col-sm-3">
	    	<input type="text" name="studentName"  class="form-control input-sm"/>
	    </div>

    <input type="submit"   class="btn btn-danger"     value="查询"/>
    <a  class="btn btn-success"  href="${pageContext.request.contextPath }/student/studentwritegrade/addload.action">添加成绩记录</a>
    
</div>

<div align="center">
	<div class="alert alert-warning" style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
		<button type="button" class="close" data-dismiss="alert">
			<span aria-hidden="true">&times;</span>
			
		</button>
		<p align="center" style="color: red;">学员成绩信息-${info}</p>
	</div>	
</div>

<div class="row" style="padding:15px; padding-top:0px; ">
	  <display:table class="table table-condensed table-striped" name="list" pagesize="10" requestURI="${pageContext.request.contextPath }/student/communicateinfo/list.action">
    	<display:column property="studentWriteGrade.writeGradeId" title="成绩编号"></display:column>
    	<display:column property="studentName" title="学生姓名"></display:column>
    	<display:column property="teacherName" title="监考人和阅卷人姓名"></display:column>
    	<display:column property="studentWriteGrade.writeGradeSubject" title="科目" ></display:column>
    	<display:column property="studentWriteGrade.writeGrade" title="成绩"></display:column>
    	<display:column property="studentWriteGrade.writeGradeTime" title="考试时间" format="{0,date,yyyy年MM月dd日}"></display:column>
    	<display:column href="${pageContext.request.contextPath }/student/studentwritegrade/load.action" paramId="writeGradeId" paramProperty="studentWriteGrade.writeGradeId" value="修改" title="修改"></display:column>
    	<display:column href="${pageContext.request.contextPath }/student/studentwritegrade/delete.action" paramId="writeGradeId" paramProperty="studentWriteGrade.writeGradeId" value="删除" title="删除"></display:column>
    	
    </display:table>
</div>
</form>
</body>
</html>
