<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib  uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>

<%@ include file="/view/public/common.jspf" %>
</head>

<body>
<!-- 显示错误信息 -->
		<c:if test="${allErrors!=null }">
			 <c:forEach items="${allErrors}" var="error">
			 	${error.defaultMessage }<br/>
			 </c:forEach>
		</c:if>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">学员管理</a></li>
        <li>添加评价</li>
    </ul>
</div>

<form action="${pageContext.request.contextPath }/student/evaluationinfo/add.action" class="form-horizontal">

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">评价编号</label>
                <div class="col-sm-9">
                	<input type="text" name="evaluationId" value="${evaluationInfo.evaluationId}" readonly="readonly" eclass="form-control input-sm" placeholder="请输入评价编号"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">主题</label>
                <div class="col-sm-9">
                	<input type="text" name="evaluationTile" value="${evaluationInfo.evaluationTile}" class="form-control input-sm" placeholder="请输入主题"/>
                </div>
            </div>
        </div>

    </div>
    
    <div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">课程名称</label>
                <div class="col-sm-9">
               			<input type="text" name="evaluationCourse" value="${evaluationInfo.evaluationCourse}" class="form-control input-sm" placeholder="请输入课程名称"/>
                </div>
            </div>
        </div>
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">教师</label>
                <div class="col-sm-9">
               		 <input type="text" name="evaluationTeacher" value="${evaluationInfo.evaluationTeacher}" class="form-control input-sm" placeholder="请输入教师"/>
                </div>
            </div>
        
        </div>

    </div>
        <div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">评价时间</label>
                <div class="col-sm-9">
               			<input type="text" name="evaluationTime" value="<fmt:formatDate value="${evaluationInfo.evaluationTime}" type="both" pattern="yyyy-MM-dd"/>" onclick="WdatePicker()" readonly="readonly" class="form-control input-sm" placeholder="请输入出生日期"/>
                </div>
            </div>
        </div>


       <div class="col-sm-5">
            <div class="form-group">
            		<label class="col-sm-3 control-label">学生</label>
                <div class="col-sm-6">
                		<select class="form-control input-sm" name="studentId" >
                        	<option>请选择</option>
                        	<c:forEach items="${studentlist}" var="studentInfo">
                            	<option value="${studentInfo.studentId}" ${studentInfo.studentId==evaluationInfo.studentId?'selected':''}>${studentInfo.studentName}</option>
                            </c:forEach>
                        </select>
                </div>
            </div>
        </div>

 
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">评价内容</label>
                <div class="col-sm-9">
                	<textarea class="form-control" name="evaluationContent">${evaluationInfo.evaluationContent}</textarea>
                </div>
            </div>
        
        </div>

    </div>
 
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="保存"/>

              <a class="btn btn-warning" href="${pageContext.request.contextPath}/student/evaluationinfo/list.action">返回上一级</a>
        </div>
    </div>
</form>

</body>
</html>
