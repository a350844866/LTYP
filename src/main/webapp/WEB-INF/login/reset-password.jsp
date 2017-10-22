<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../base.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>乐途影评</title>
    

    <link rel="stylesheet" type="text/css" href="${ctx}/staticfile/lib/bootstrap/css/bootstrap.css">
    
    <link rel="stylesheet" type="text/css" href="${ctx}/staticfile/stylesheets/theme.css">
    <link rel="stylesheet" href="${ctx}/staticfile/lib/font-awesome/css/font-awesome.css">

    <script src="${ctx}/staticfile/lib/jquery-1.7.2.min.js" type="text/javascript"></script>
     
   <link rel="stylesheet" type="text/css" href="${ctx}/staticfile/css/logo.css">
   
    <!-- Demo page code -->

  
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
            <p class="block-heading">Reset your password</p>
            <div class="block-body">
                <form>
                    <label>邮箱地址</label>
                    <input type="text" name="email" class="span12"/>
                    <a href="#" class="btn btn-primary pull-right"
                       onclick="formSubmit('${ctx}/sendForgetMail', '_self')">发 送</a>
                    <div class="clearfix"></div>
                </form>
            </div>
        </div>
        <a href="${ctx}/login/signin">登录账户</a>
    </div>
</div>


    


    <script src="${ctx}/staticfile/lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
    
  </body>
</html>


