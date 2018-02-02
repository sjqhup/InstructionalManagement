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
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">教务管理</a></li>
        <li>考勤表</li>
        <li>修改</li>
    </ul>
</div>

<form action="${pageContext.request.contextPath }/edumanage/attendance.action" class="form-horizontal">

<h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
			<div class="row">
    			<div class="col-sm-5">
        			<div class="form-group">
            			<label class="col-sm-3 control-label">考勤表编号</label>
                		<div class="col-sm-9">
                			<input type="text" name="attendanceId"  value="${attendanceInfo.attendanceId}" readonly="readonly" class="form-control input-sm" placeholder="请输入考勤表编号"/>
                		</div>
           		 </div>
        
       		 </div>
       		 <div class="col-sm-5">
            	<div class="form-group">
            		<label class="col-sm-3 control-label">学生编号</label>
                	<div class="col-sm-9">
                	<select class="form-control input-sm" name="studentId" >
                		 <c:forEach items="${studentList}" var="studentList">
                            	<option value="${studentList.studentId}"}>${studentList.studentId}</option>
                        </c:forEach>
                    </select>
                		
                	</div>
            	</div>
       		 </div>

    		</div>
    		
    		<div class="row">
    			<div class="col-sm-5">
        			<div class="form-group">
            			<label class="col-sm-3 control-label">考勤表时间</label>
                		<div class="col-sm-9">
                			<input type="text" name="attendanceTime" onclick="WdatePicker()" readonly="readonly"  value="${attendanceInfo.attendanceTime}" class="form-control input-sm" placeholder="请选择考勤表时间"/>
                		</div>
           		 </div>
        
       		 </div>
       		 
       		 <div class="col-sm-5">
            	<div class="form-group">
            		<label class="col-sm-3 control-label">状态</label>
                	<div class="col-sm-9">
                	<input type="text" name="attendanceState"  value="${attendanceInfo.attendanceState}" class="form-control input-sm" placeholder="请输入"/>
                	
                		
                	</div>
            	</div>
       		 </div>
    		
    
    
    			<div class="row">

        			<div class="form-group">
            			<label class="col-sm-2 control-label">考勤内容描述</label>
                		<div class="col-sm-9">
                			<textarea class="form-control" value="${attendanceInfo.attendanceDesc}" name="attendanceDesc"></textarea>
                		</div>
       		 		</div>
       		 	</div>

				<div class="row">
            	<div class="form-group">
            		<label class="col-sm-2 control-label">考勤注释</label>
                	<div class="col-sm-9">
                		<textarea class="form-control" value="${attendanceInfo.attendanceRemark}" name="attendanceRemark"></textarea>
                	</div>
            	</div>
       		 </div>
       		 <div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="修改"/>
            <a href="${pageContext.request.contextPath }/edumanage/attendance/list.action">返回上一级</a>
        </div>
    </div>
</form>
</body>
</html>