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
    	<li><a href="#">招生管理</a></li>
        <li>试听记录</li>
    </ul>
</div>
<form action="${pageContext.request.contextPath}/recruitstudent/auditioninfo/list.action" class="form-inline">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

     <div class="form-group">
         <label class="" for="activename">学员姓名：</label>
        <input type="text" class="form-control" name="studentName" placeholder="请输入学员姓名">
      </div>
    <div class="form-group">
         <label class="" for="activename">试听课程：</label>
		   <input type="text" class="form-control" name="disciplineName" placeholder="请输入试听课程">	
      </div>
    <input type="submit"   class="btn btn-danger"     value="查询"/>
    <input type="button"   class="btn btn-success"   value="添加试听记录" onClick="javascript:window.location='${pageContext.request.contextPath}/view/recruitstudent/auditioninfo/auditioninfo_add.jsp'"/>
    
    <!-- 提示信息  显示是否添加失败或者成功 -->
    <div align="center">
	<div class="alert alert-warning" style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
		<button type="button" class="close" data-dismiss="alert">
			<span aria-hidden="true">&times;</span>
		</button>
		<p align="center" style="color: red;">试听记录-${info}</p>
	</div>
	</div>	
</div>



<div class="row" style="padding:15px; padding-top:0px; " align="right">
	<table class="table  table-condensed table-striped">
    </table>
    <display:table class="table table-condensed table-striped" name="list" pagesize="10" requestURI="${pageContext.request.contextPath }/recruitstudent/auditioninfo/list.action">
    	<display:column property="studentId" title="学员编号"></display:column>
    	<display:column property="auditionCourse" title="试听课程"></display:column>
    	<display:column property="auditionTime" title="试听时间" format="{0,date,yyy年MM月dd日}"></display:column>
    	<display:column property="auditionAddr" title="地点"></display:column>
    	<display:column href="${pageContext.request.contextPath }/recruitstudent/auditioninfo/load.action" paramId="auditionId" paramProperty="auditionInfo.auditionId" value="修改" title="修改"></display:column>
    	<display:column href="${pageContext.request.contextPath }/recruitstudent/auditioninfo/delete.action" paramId="auditionId" paramProperty="auditionInfo.auditionId" value="删除" title="删除"></display:column>
    	
    </display:table>
    
    
</div>
</form>
</body>
</html>