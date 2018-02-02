<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

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
    	<li><a href="#">教务管理</a></li>
        <li>班级事务</li>
        <li>修改事务</li>
    </ul>
</div>

<form action="${pageContext.request.contextPath }/edumanage/transaction/update.action" class="form-horizontal">
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="保存"/>
            <a href="${pageContext.request.contextPath }/edumanage/transaction/list.action" class="btn btn-success">返回上一级</a>
        </div>
    </div>
    
  <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">事务</h5>
  
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">事务编号</label>
                <div class="col-sm-9">
                	<input type="text" name="classTransactionId" readonly="readonly" class="form-control input-sm" placeholder="请输入编号"/>
                </div>
            </div>
          </div>
            
           <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">班级编号</label>
                <div class="col-sm-9">
                	<select class="form-control input-sm" name="classId" >
                		<%-- <c:forEach items="${classList}" var="classList">
                            	<option value="${classList.classId}"}>${classList.classId}</option>
                        </c:forEach> --%>
                    </select>
                </div>
            </div>
        </div>
    </div>
        
      <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">主题</label>
                <div class="col-sm-9">
                	<input type="text" name="classTransactionTile" class="form-control input-sm" placeholder="请输入主题"/>
                </div>
            </div>
        </div>
        
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">内容</label>
                <div class="col-sm-5">
                	<input type="text" name="classTransactionContent" class="form-control input-sm" placeholder="请输入内容"/>
                </div>
            </div>
        
        </div>
        
       </div>
       
      <div class="row">
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">组织人</label>
                <div class="col-sm-4">
                		<input type="text" name="classTransactionPerson" class="form-control input-sm" placeholder="请输入组织人"/>
                </div>
            </div>
        </div>
  
   
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">活动日期</label>
                <div class="col-sm-9">
                	<input type="text" name="classTransactionTime" onclick="WdatePicker()" readonly="readonly" class="form-control input-sm" placeholder="请输入活动日期"/>
                </div>
            </div>
        
       </div>
      </div>
     
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">备注信息</h5>
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">备注</label>
                <div class="col-sm-9">
                	<textarea class="form-control" name=" classTransactionRemar"></textarea>
                </div>
            </div>
        
        </div>
       </div>


   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="保存"/>
             <a href="${pageContext.request.contextPath }/edumanage/transaction/list.action" class="btn btn-success">返回上一级</a>
        </div>
    </div>
</form>


</body>
</html>