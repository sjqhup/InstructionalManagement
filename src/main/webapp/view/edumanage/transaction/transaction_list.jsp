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
    	<li><a href="#">班级事务</a></li>
        <li>查询班级事务</li>
    </ul>
</div>
<script type="text/javascript">
		function query(condition){
			$("#keyword").attr("name",condition.value);
		}
</script>

<div class="row alert alert-info"  style="margin:0px; padding:3px;" >
<form  action="${pageContext.request.contextPath}/edumanage/transaction/list.action" method="post" class="form-horizontal">
	<div class="col-sm-1" >条件:</div>
    <div class="col-sm-3">
    	<select class="form-control  input-sm" onchange="query(this)" name="condition">
        	<option value="">请选择</option>
        	<option value="classId">班级编号</option>
            <option value="classTransactionTile">主题</option>
        </select>
    </div>
    <div class="col-sm-3">
    	<input type="text"  id="keyword"  class="form-control input-sm"/>
    </div>
    <input type="submit"   class="btn btn-danger"   value="查询"/>
    <input type="button"   class="btn btn-success"   value="添加" onClick="javascript:window.location='${pageContext.request.contextPath}/view/edumanage/transaction/transaction_add.jsp'"/>
 </form>
</div>

<div align="center">
	<div class="alert alert-warning" style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
		<button type="button" class="close" data-dismiss="alert">
			<span aria-hidden="true">&times;</span>
			
		</button>
		<p align="center" style="color: red;">班级事务-${info}</p>
	</div>	
</div>

<!-- ---------------------------------------------------------------------------------------- -->



<div class="row" style="padding:15px; padding-top:0px; " align="right">
	<table class="table  table-condensed table-striped">
    </table>
    <display:table class="table table-condensed table-striped" name="list" pagesize="10" requestURI="${pageContext.request.contextPath}/edumanage/transaction/list.action">
    	<display:column property="classTransactionId" title=" 事务编号"></display:column>
    	<display:column property="classId" title=" 班级编号"></display:column>
    	<display:column property="classTransactionTile" title="主题"></display:column>
    	<display:column property="classTransactionContent" title="内容"></display:column>
    	
    	<display:column property="classTransactionPerson" title="组织人"></display:column>
    	
    	<display:column property="classTransactionTime" title="活动日期" format="{0,date,yyyy年MM月dd日}"></display:column>
    	<display:column property="classTransactionRemar" title="备注"></display:column>
    	<display:column href="${pageContext.request.contextPath }/edumanage/transaction/load.action" paramId="classTransactionId" paramProperty="classTransactionId" value="修改" title="修改"></display:column>
    	<display:column href="${pageContext.request.contextPath }/edumanage/transaction/delete.action" paramId="classTransactionId" paramProperty="classTransactionId" value="删除" title="删除"></display:column>
    	
    </display:table>
    
    
</div>

</body>
</html>

