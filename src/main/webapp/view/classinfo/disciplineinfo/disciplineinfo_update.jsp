<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib  uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<%@ include file="/view/public/common.jspf" %>

<body>
<!-- 显示校验的错误信息 -->

<c:if test="${allErrors!=null}">
<c:forEach items="${allErrors}" var="error">
		${error.defaultMessage}</br>
		</c:forEach>
		</c:if>
</p>

<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="${pageContext.request.contextPath }/classinfo/disciplineinfo/list.action">班级管理</a></li>
         <li>学科信息</li>
        <li>修改信息</li>
    </ul>
</div>

<form action="${pageContext.request.contextPath }/classinfo/disciplineinfo/update.action" method="post" class="form-horizontal">

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">编号</label>
                <div class="col-sm-9">
                	<input type="text" name="disciplineId" value="${disciplineInfo.disciplineId}" readonly="readonly" class="form-control input-sm" placeholder="请输入编号"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">学科名称</label>
                <div class="col-sm-9">
                	<input type="text" name="disciplineName" value="${disciplineInfo.disciplineName}" class="form-control input-sm" placeholder="请输入学科名称"/>
                </div>
            </div>
        </div>

    </div>
    	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">学科费用</label>
                <div class="col-sm-9">
               			<input type="text" name="disciplineTuition" value="${disciplineInfo.disciplineTuition}" class="form-control input-sm" placeholder="请输入学科费用"/>
                </div>
            </div>
        </div>
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">学科课时</label>
                <div class="col-sm-9">
               		 <input type="text" name="disciplineBring" value="${disciplineInfo.disciplineBring}" class="form-control input-sm" placeholder="请输入学科课时"/>
                </div>
            </div>
        
        </div>

    </div>

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">描述</h5>
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">描述</label>
                <div class="col-sm-9">
                <textarea name="disciplineDesc"  class="form-control "placeholder="请输入描述"/>${disciplineInfo.disciplineDesc}</textarea>
                	
                </div>
            </div>
        
        </div>

    </div>
 
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="保存"/>

              <a class="btn btn-warning" href="${pageContext.request.contextPath}/classinfo/disciplineinfo/list.action">返回上一级</a>
        </div>
    </div>
</form>

</body>
</html>
