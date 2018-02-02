<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<%@ include file="/view/public/common.jspf"%>
</head>
<body>

<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">招生管理</a></li>
        <li>跟踪记录</li>
    </ul>
</div>

<!-- 提示信息区域 -->
	<div align="center">
		<div class="alert alert-warning"
			style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
			<button type="button" class="close" data-dismiss="alert">
				<span aria-hidden="true">&times;</span>
			</button>
			<p align="center" style="color: red;">追踪记录信息-${info}</p>
		</div>
	</div>
	
<form action="${pageContext.request.contextPath }/recruitstudent/trackrecord/list.action" class="form-inline" method="post">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

     <div class="form-group">
        <label class="" for="activename">学员姓名：</label>
        <input type="text" class="form-control" name="studentName" id="activename" placeholder="请输入学员姓名">
      </div>
    <input type="submit"   class="btn btn-danger"     value="查询"/>
    <input type="button"   class="btn btn-success"   value="添加记录" onClick="javascript:window.location='${pageContext.request.contextPath }/recruitstudent/trackrecord/addload.action'"/>添加纪录</a>
    
    <div class="row" style="padding: 15px; padding-top: 0px;">
		<display:table class="table  table-condensed table-striped" name="list" pagesize="10"
			requestURI="${pageContext.request.contextPath}/recruitstudent/trackrecord/list.action">
			<display:column property="trackRecordId" title="编号"></display:column>
			<display:column property="trackRecordTitle" title="主题"></display:column>
			<display:column property="trackRecordContent" title="具体内容"></display:column>
			<display:column property="trackRecordTime" title="联系时间" format="{0,date,yyy年MM月dd日}"></display:column>
			<display:column property="enrollment" title="意向状态"></display:column>
			<display:column property="nextRecordTime" title="下次联系时间" format="{0,date,yyy年MM月dd日}"></display:column>
			<display:column
				href="${pageContext.request.contextPath }/recruitstudent/trackrecord/load.action"
				paramId="trackRecordId" paramProperty="trackRecordId" value="修改"
				title="修改"></display:column>
			<display:column
				href="${pageContext.request.contextPath }/recruitstudent/trackrecord/delete.action"
				paramId="trackRecordId" paramProperty="trackRecordId" value="删除"
				title="删除"></display:column>
		</display:table>
	
	</div>
    
</div>
</form>
</body>
</html>
