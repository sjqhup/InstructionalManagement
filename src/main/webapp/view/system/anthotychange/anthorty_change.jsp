<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
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
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">系统管理</a></li>
        <li>权限变更</li>
    </ul>
<form action="" class="form-horizontal">

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">角色编号</label>
                <div class="col-sm-9">
                	<p class="form-control-static">10001</p>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">角色名称</label>
                <div class="col-sm-9">
                	<p class="form-control-static">超级管理员</p>
                </div>
            </div>
        </div>

    </div>
  <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">菜单信息</h5> 
  <table class="table">
  	<tr>
    	<th>一级菜单</th>
        <th>二三...级菜单</th>
    </tr>
    <tr>
    	<td>
        	<label class="checkbox-inline">
            	<input type="checkbox" value="">系统管理
             </label>
        </td>
    	<td>
        	 <label class="checkbox-inline">
            	<input type="checkbox" value="">员工管理
             </label>
                	 <label class="checkbox-inline">
            	<input type="checkbox" value="">角色管理管理
             </label>
              <label class="checkbox-inline">
            	<input type="checkbox" value="">角色变更
             </label>        <label class="checkbox-inline">
            	<input type="checkbox" value="">角色变更
             </label>        <label class="checkbox-inline">
            	<input type="checkbox" value="">角色变更
             </label>        <label class="checkbox-inline">
            	<input type="checkbox" value="">角色变更
             </label>        <label class="checkbox-inline">
            	<input type="checkbox" value="">角色变更
             </label>
        </td>
    </tr>    <tr>
    	<td>
        	<label class="checkbox-inline">
            	<input type="checkbox" value="">招生管理
             </label>
        </td>
    	<td>
        	 <label class="checkbox-inline">
            	<input type="checkbox" value="">员工管理
             </label>
                	 <label class="checkbox-inline">
            	<input type="checkbox" value="">角色管理管理
             </label>
              <label class="checkbox-inline">
            	<input type="checkbox" value="">角色变更
             </label>        <label class="checkbox-inline">
            	<input type="checkbox" value="">角色变更
             </label>        <label class="checkbox-inline">
            	<input type="checkbox" value="">角色变更
             </label>        <label class="checkbox-inline">
            	<input type="checkbox" value="">角色变更
             </label>        <label class="checkbox-inline">
            	<input type="checkbox" value="">角色变更
             </label>
        </td>
    </tr>    <tr>
    	<td>
        	<label class="checkbox-inline">
            	<input type="checkbox" value="">教务管理
             </label>
        </td>
    	<td>
        	 <label class="checkbox-inline">
            	<input type="checkbox" value="">员工管理
             </label>
                	 <label class="checkbox-inline">
            	<input type="checkbox" value="">角色管理管理
             </label>
              <label class="checkbox-inline">
            	<input type="checkbox" value="">角色变更
             </label>        <label class="checkbox-inline">
            	<input type="checkbox" value="">角色变更
             </label>        <label class="checkbox-inline">
            	<input type="checkbox" value="">角色变更
             </label>        <label class="checkbox-inline">
            	<input type="checkbox" value="">角色变更
             </label>        <label class="checkbox-inline">
            	<input type="checkbox" value="">角色变更
             </label>
        </td>
    </tr>    <tr>
    	<td>
        	<label class="checkbox-inline">
            	<input type="checkbox" value="">财务管理
             </label>
        </td>
    	<td>
        	 <label class="checkbox-inline">
            	<input type="checkbox" value="">员工管理
             </label>
                	 <label class="checkbox-inline">
            	<input type="checkbox" value="">角色管理管理
             </label>
              <label class="checkbox-inline">
            	<input type="checkbox" value="">角色变更
             </label>        <label class="checkbox-inline">
            	<input type="checkbox" value="">角色变更
             </label>        <label class="checkbox-inline">
            	<input type="checkbox" value="">角色变更
             </label>        <label class="checkbox-inline">
            	<input type="checkbox" value="">角色变更
             </label>        <label class="checkbox-inline">
            	<input type="checkbox" value="">角色变更
             </label>
        </td>
    </tr>
  
  </table>   
       	<div class="row">
    	<div class="col-sm-5 col-sm-offset-4">
          	<input type="submit" class="btn btn-success" value="权限变更"/>
            <a  href="anthorty_changelist.html" class="btn btn-warning">返回上一级</a>
          
        </div>
    </div>
    
</form>        
</div>
</body>
</html>
