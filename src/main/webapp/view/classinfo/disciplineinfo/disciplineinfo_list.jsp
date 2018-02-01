<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib  uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>

<%@ include file="/view/public/common.jspf" %>

<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="${pageContext.request.contextPath }/classinfo/disciplineinfo/list.action">班级管理</a></li>
        <li>学科信息</li>
    </ul>
</div>
<form action="${pageContext.request.contextPath }/classinfo/disciplineinfo/list.action" method="post" class="form-inline">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >
	
     <div class="form-group">
         <label class="" for="activename">学科名称：</label>
          <div class="col-sm-9">
        <input type="text" name="disciplineName" id="activename"  class="form-control input-sm" placeholder="请输入课程表名称"/>
      </div>
      </div>

    <input type="submit"   class="btn btn-danger"     value="查询"/>
    <a  class="btn btn-success"  onClick="javascript:window.location='${pageContext.request.contextPath }/view/classinfo/disciplineinfo/disciplineinfo_add.jsp'">添加学科信息</a>
    
</div>
<div align="center">
	<div class="alert alert-warning" style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
		<button type="button" class="close" data-dismiss="alert">
			<span aria-hidden="true">&times;</span>
			
		</button>
		<p align="center" style="color: red;">学科信息-${info}</p>
	</div>	
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
	<table class="table  table-condensed table-striped">
 </table>
    <display:table class="table table-condensed table-striped" name="list" pagesize="10" requestURI="${pageContext.request.contextPath}/classinfo/discipline/list.action">
    	<display:column property="disciplineId" title="编号"></display:column>
    	
    	<display:column property="disciplineName" title="学科名称"></display:column>
    	
    	<display:column property="disciplineTuition" title="学科费用"></display:column>
    	
    	<display:column property="disciplineBring" title="学科课时"></display:column>
    	    	
    	<display:column href="${pageContext.request.contextPath }/classinfo/disciplineinfo/load.action" paramId="disciplineId" paramProperty="disciplineId" value="修改" title="修改"></display:column>
    	
    	<display:column href="${pageContext.request.contextPath }/classinfo/disciplineinfo/delete.action" paramId="disciplineId" paramProperty="disciplineId" value="删除" title="删除"></display:column>
    	
    </display:table>
	
</div>
</form>
</body>
</html>
