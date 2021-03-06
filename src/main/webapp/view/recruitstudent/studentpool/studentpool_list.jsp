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
        <li>查询学员</li>
    </ul>
</div>

<form action="${pageContext.request.contextPath}/recruitstudent/studentpool/list.action" method="post" class="form-horizontal">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

    <div class="col-sm-2">学员名字:</div>
	    <div class="col-sm-3">
	    	<input type="text" name="studentName"  class="form-control input-sm"/>
	    </div>
    

    <input type="submit"   class="btn btn-danger"     value="查询"/>
    <input type="button"   class="btn btn-success"   value="添加" onClick="javascript:window.location='${pageContext.request.contextPath }/recruitstudent/studentpool/addload.action'"/>
    
</div>

<div align="center">
	<div class="alert alert-warning" style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
		<button type="button" class="close" data-dismiss="alert">
			<span aria-hidden="true">&times;</span>
			
		</button>
		<p align="center" style="color: red;">学生信息-${info}</p>
	</div>	
</div>


<div class="row" style="padding:15px; padding-top:0px; ">
	  <display:table class="table table-condensed table-striped" name="list" pagesize="10" requestURI="${pageContext.request.contextPath }/recruitstudent/studentpool/list.action">
    	<display:column property="studentId" title="编号"></display:column>
    	<display:column property="studentName" title="姓名" paramId="studentName" paramProperty="studentName"></display:column>
    	<display:column property="studentSex" title="性别"></display:column>
    	<display:column property="studentAge" title="年龄"></display:column>
    	<display:column property="studentTellphone" title="手机号"></display:column>
    	<display:column property="studentEmail" title="邮箱"></display:column>
    	<display:column property="studentBirthday" title="出生日期" format="{0,date,yyyy年MM月dd日}"></display:column>
        <display:column property="studentSchool" title="学校"></display:column>
    	<display:column property="studentQq" title="qq"></display:column>
    	<%-- <display:column property="studentParentsName" title="父母名字"></display:column>
    	<display:column property="studentParentsPhone" title="父母电话"></display:column>  --%>
    	<display:column href="${pageContext.request.contextPath }/recruitstudent/studentpool/load.action" paramId="studentId" paramProperty="studentId" value="修改" title="修改"></display:column>
    	<display:column href="${pageContext.request.contextPath }/recruitstudent/studentpool/register.action" paramId="studentId" paramProperty="studentId" value="领取学员" title="领取学员"></display:column>
    	<display:column href="${pageContext.request.contextPath }/recruitstudent/studentpool/delete.action" paramId="studentId" paramProperty="studentId" value="删除" title="删除"></display:column>
    	
    </display:table>
</div>
</form>
</body>
</html>
