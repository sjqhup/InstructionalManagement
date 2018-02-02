<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib  uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<%@ include file="/view/public/common.jspf" %>

</head>
<body>
    <!-- 头部的说明标签 -->
	<div style="padding:0px; margin:0px;">
	 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">教务管理</a></li>
        <li>考勤表管理</li>
    </ul>
    </div>
    
    <!-- 查询的部分 -->
    <script type="text/javascript">
		function query(condition){
			$("#keyword").attr("name",condition.value);
		}
	</script>

	<div class="row alert alert-info"  style="margin:0px; padding:3px;" >
		<form  action="${pageContext.request.contextPath}/edumanage/attendance/list.action" method="post" class="form-horizontal">
			<div class="col-sm-1" >条件:</div>
    		<div class="col-sm-3">
    			<select class="form-control  input-sm" onchange="query(this)" name="condition">
        			<option value="">请选择</option>
        			<option value="attendanceId">考勤表编号</option>
            		<option value="studentId">学生编号</option>
        		</select>
   			 </div>
   			 <div class="col-sm-3">
    			<input type="text"  id="keyword"  class="form-control input-sm"/>
    		</div>
    			<input type="submit"   class="btn btn-danger"   value="查询"/>
    			<a  class="btn btn-warning"  href="${pageContext.request.contextPath}/edumanage/attendance/loadadd.action">添加</a>
 		</form>
	</div>
	
	<!--要展示的信息  -->
	<div class="row" style="padding:15px; padding-top:0px; " align="right">
	<table class="table  table-condensed table-striped">
    </table>
    <display:table class="table table-condensed table-striped" name="list" pagesize="10" requestURI="${pageContext.request.contextPath }/edumanage/attendance/list.action">
    	
    	<display:column property="attendanceId" title="考勤表编号"></display:column>
    	<display:column property="studentId" title="学生编号"></display:column>
    	<display:column property="attendanceDesc" title="考勤表描述"></display:column>
    	<display:column property="attendanceTime" title="考勤时间" format="{0,date,yyyy年MM月dd日}"></display:column>
    	<display:column property="attendanceRemark" title="考勤注释"></display:column>
    	
    	<display:column href="${pageContext.request.contextPath }/edumanage/attendance/load.action" paramId="attendanceId" paramProperty="attendanceId" value="修改" title="修改"></display:column>
    	<display:column href="${pageContext.request.contextPath }/edumanage/attendance/delete.action" paramId="attendanceId" paramProperty="attendanceId" value="删除" title="删除"></display:column>
    	
    </display:table>
    </div>
 
    

</body>
</html>