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
    	<li><a href="#">系统管理</a></li>
        <li>数据字典</li>
    </ul>
</div>

<div class="row alert alert-info"  style="margin:0px; padding:3px;" >
<form  action="${pageContext.request.contextPath}/system/datadictionary/list.action" method="post" class="form-horizontal" >
	<div class="col-sm-2">类型:</div>
    <div class="col-sm-3">
    	<input type="text" name="dataType" class="form-control input-sm"/>
    </div>
    <input type="submit"   class="btn btn-danger"     value="查询"/>
    <a  class="btn btn-success"  href="${pageContext.request.contextPath}/view/system/datadictionary/datadictionary_add.jsp"   >添加</a>
    <a  class="btn btn-success"  href="${pageContext.request.contextPath}/system/datadictionary/downloadsql.action"   >下载sql语句</a>
    <a  class="btn btn-success"  href="${pageContext.request.contextPath}/system/datadictionary/downloadsql2.action"   >下载pdm文件</a>
    <a  class="btn btn-success"  href="${pageContext.request.contextPath}/view/system/datadictionary/show.jsp">展示pdm图片</a>
    <a  class="btn btn-success"  href="${pageContext.request.contextPath}/view/system/datadictionary/upload.jsp">添加文件</a>
    </form>
</div>

<div align="center">
	<div class="alert alert-warning" style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
		<button type="button" class="close" data-dismiss="alert">
			<span aria-hidden="true">&times;</span>
			
		</button>
		<p align="center" style="color: red;">数据字典信息-${info}</p>
	</div>	
</div>

<div class="row" style="padding:15px; padding-top:0px; " align="right">
	<table class="table  table-condensed table-striped">
    </table>
    <display:table class="table table-condensed table-striped" name="list" pagesize="10" requestURI="${pageContext.request.contextPath }/system/staffinfo/list.action">
    	<display:column property="dataId" title="编号"></display:column>
    	<display:column property="dataContent" title="内容"></display:column>
    	<display:column property="dataType" title="类型"></display:column>
    	<display:column property="dataDesc" title="描述"></display:column>
    	<display:column href="${pageContext.request.contextPath }/system/datadictionary/load.action" paramId="dataId" paramProperty="dataId" value="修改" title="修改"></display:column>
    	<display:column href="${pageContext.request.contextPath }/system/datadictionary/delete.action" paramId="dataId" paramProperty="dataId" value="删除" title="删除"></display:column>
    	
    </display:table>
    
    
</div>

</body>
</html>
