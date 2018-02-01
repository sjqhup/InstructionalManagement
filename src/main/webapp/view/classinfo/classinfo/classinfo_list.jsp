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
    	<li><a href="#">班级管理</a></li>
        <li>班级信息</li>
    </ul>
</div>


<form action="${pageContext.request.contextPath }/classinfo/classinfo/list.action" class="form-inline">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

        <div class="col-sm-2">班级名称:</div>
	    <div class="col-sm-3">
	    	<input type="text" name="className"  class="form-control input-sm"/>
	    </div>
	    <input type="submit"   class="btn btn-danger"   value="查询"/>
	     <a href="${pageContext.request.contextPath }/classinfo/classinfo/loadCross.action" class="btn btn-success" >添加</a>
</div>

<div align="center">
	<div class="alert alert-warning" style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
		<button type="button" class="close" data-dismiss="alert">
			<span aria-hidden="true">&times;</span>
			
		</button>
		<p align="center" style="color: red;">班级信息-${info}</p>
	</div>	
</div>

<div class="row" style="padding:15px; padding-top:0px; ">
   
    <display:table class="table table-condensed table-striped" name="list" pagesize="10" requestURI="${pageContext.request.contextPath }/classinfo/classinfo/list.action">
    	<display:column property="classInfo.classId" title="编号"></display:column>
    	<display:column property="classInfo.className" title="班级名称"></display:column>
    	<display:column property="classInfo.classNumber" title="班级人数"></display:column>
    	<display:column property="classInfo.classStartTime" title="开班日期" format="{0,date,yyyy年MM月dd日}"></display:column>
    	<display:column property="classInfo.classEndTime" title="结束日期" format="{0,date,yyyy年MM月dd日}"></display:column>
    	
        <display:column property="classroomInfo.classroomName" title="教室名称"></display:column>
    	<display:column property="disciplineInfo.disciplineName" title="学科名称"></display:column>
    	<display:column property="syllabusInfo.syllabusName" title="课程名称"></display:column>
    	<display:column property="staffInfo.staffName" title="负责人"></display:column>
   
   
   <display:column href="${pageContext.request.contextPath }/classinfo/classinfo/loadCross1.action" paramId="classId" paramProperty="classInfo.classId" value="修改" title="修改"></display:column>
   <display:column href="${pageContext.request.contextPath }/classinfo/classinfo/delete.action" paramId="classId" paramProperty="classInfo.classId" value="删除" title="删除"></display:column>
    	
    </display:table>
    
</div>
</form>
</body>
</html>
