<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!--  需要用到fore循环-->
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
        <li>添加记录</li>
    </ul>
</div>

<!--
       <!-- 显示错误信息 -->
		<c:if test="${allErrors!=null }">
			 <c:forEach items="${allErrors}" var="error">
			 	${error.defaultMessage }<br/>
			 </c:forEach>
		</c:if>

<form action="${pageContext.request.contextPath}/recruitstudent/auditioninfo/add.action" class="form-horizontal">

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">编号</label>
                <div class="col-sm-9">
                	<input type="text" name="auditionId" value="${auditionInfo.auditionId}" readonly="readonly" class="form-control input-sm" placeholder="请输入编号"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            <!-- 课程固定只能由课程那边获得 -->
            	<label class="col-sm-3 control-label">试听课程</label>
                <div class="col-sm-9">
                	<select name="auditionCourse" class="form-control input-sm">
							<option></option>
							<c:forEach items="${disciplineAuditionInfolist}" var="disciplineAudition">
								<option value="${disciplineAudition.disciplineName}" ${disciplineAudition.disciplineName==auditionInfo.auditionCourse?'selected':'' }>${disciplineAudition.disciplineName }</option>
							</c:forEach>
							<!-- 第一个$代表这个下拉列表每个选项的value（value不是选项 显示的字符）  第二个$表示选中和学生ID一致的选项  这个选项只是匹配对应的value   第三个$表示下拉列表显示的东西 -->
							<!--循环装着discipline对象的disciplineList-->
							</select>
                </div>
            </div>
        </div>

    </div>
    	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">试听学员</label>
                <div class="col-sm-9">
                <input type="text" placeholder="请输入学员名字">
                
                
                </div>
            </div>
        </div>
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">试听时间</label>
                <div class="col-sm-9">
               		 <input type="text" name="auditionTime" 
						value="<fmt:formatDate value="${auditionInfo.auditionTime }" type="both" pattern="yyyy-MM-dd"/>"
						onclick="WdatePicker()" readonly="readonly" class="form-control input-sm" />
					
                </div>
            </div>
        
        </div>

    </div>
       	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">试听地点</label>
                <div class="col-sm-9">
               		 <input type="text" name="auditionAddr" value="${auditionInfo.auditionAddr }"  class="form-control input-sm" placeholder="请输入试听地点"/>
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
                	<textarea name="auditionDesc" class="form-control">${auditionInfo.auditionDesc }</textarea>
                </div>
            </div>
        
        </div>

    </div>
 
   <div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="保存"/>
            <input  type="reset" class="btn  btn-danger" value="取消"/>
        </div>
    </div>
</form>

</body>
</html>