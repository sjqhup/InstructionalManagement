<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a href="#">系统管理</a></li>
        <li>权限变更</li>
    </ul>
</div>
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >
<form class="form-horizontal">
	<div class="col-sm-2">角色名称:</div>
    <div class="col-sm-3">
    	<input type="text"  class="form-control input-sm"/>
    </div>
    <input type="button"   class="btn btn-danger"   value="查询"/>

    </form>
</div>
<div class="row" style="padding:15px; padding-top:0px; ">
	<table class="table  table-condensed table-striped">
    	<tr>
        	<th>角色编号</th>
            <th>角色名称</th>
            <th>角色描述</th>
             <th>操作</th>
        </tr>
       	<tr>
        	<td>1001</td>
            <td>java工程师</td>
            <td>天天编写代码的</td>
            <th><a href="anthorty_change.html">权限变更</a></th>
        </tr>       	<tr>
        	<td>1001</td>
            <td>java工程师</td>
            <td>天天编写代码的</td>
            <th><a href="anthorty_change.html">权限变更</a></th>
        </tr>       	<tr>
        	<td>1001</td>
            <td>java工程师</td>
            <td>天天编写代码的</td>
            <th><a href="anthorty_change.html">权限变更</a></th>
        </tr>
          
    </table>
</div>

</body>
</html>
