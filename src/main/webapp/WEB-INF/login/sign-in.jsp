<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../base.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Bootstrap Admin</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="${ctx}/staticfile/lib/bootstrap/css/bootstrap.css">
    
    <link rel="stylesheet" type="text/css" href="${ctx}/staticfile/stylesheets/theme.css">
    <link rel="stylesheet" href="${ctx}/staticfile/lib/font-awesome/css/font-awesome.css">

    <script src="${ctx}/staticfile/lib/jquery-1.7.2.min.js" type="text/javascript"></script>
 

    <link rel="stylesheet" type="text/css" href="${ctx}/staticfile/css/logo.css">
    
   
  </head>
 
  <body class=""> 
  
    
    <div class="navbar">
        <div class="navbar-inner">
                <ul class="nav pull-right">
                    
                </ul>
                <a class="brand" href="index.html"><span class="first">乐途</span> <span class="second">影评</span></a>
        </div>
    </div> 
        <div class="row-fluid">
    <div class="dialog">
        <div class="block">
            <p class="block-heading">Sign In</p>
            <div class="block-body">
                <form>
                    
                    <input type="text" class="span12" placeholder="用户名" name="username">
                     
                    <input type="password" class="span12" placeholder="请输入密码" name="password">
                    <a href="#" onclick="formSubmit('login','_self');this.blur();" class="btn btn-primary pull-right">登 录</a>
                    <label class="remember-me"><input type="checkbox"> Remember me</label>
                    <div class="clearfix"></div>
                </form>
            </div>
        </div>
        <p class="pull-right" style=""><a href="/login/signup" target="_self">注 册</a></p>
        <p><a href="/login/forgetPassword">忘记密码 ?</a></p>
    </div>
</div>
 

    <script src="${ctx}/staticfile/lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip(); //提示框
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
    
  </body>
</html>


