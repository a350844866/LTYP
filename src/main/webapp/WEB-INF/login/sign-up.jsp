<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../base.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<script src="${ctx}/staticfile/lib/jquery-1.7.2.min.js" type="text/javascript"></script>
<script type="text/javascript">
    $(function(){
        $("input[name='username']").blur(function () {
            if (!formObj.checkNull("username","用户名不能为空")){
                return;
            }
            var username = $(this).val();
        $.post("${ctx}/login/AjaxCheckUsername",{"username":username},function (result) {
            $("#username_msg").html(result);
        });
        });




        $("input[name=username]").blur(function(){

            var val = $(this).val();

            if(!formObj.checkNull("username","用户名不能为空")){

            }else{

                $("#username_msg").html("<img src='images/right.ico'>");
            }
        });

        $("input[name=password]").blur(function(){
            var val = $(this).val();

            if(!formObj.checkNull("password","密码不能为空")){

            }else{
                if(!formObj.checkPassword("password","两次密码不相同")){

                }else{
                    $("#password_msg")
                        .html("<img src='images/right.ico'>");


                    var pass2 = $("input[name=password2]").val();

                    if(pass2){
                        $("#password2_msg")
                            .html("<img src='images/right.ico'>");
                    }


                }
            }
        });
        $("input[name=password2]").blur(function(){
            if(!formObj.checkNull("password","密码不能为空")){

            }else{
                if(!formObj.checkPassword2("password","两次密码不相同")){

                }else{
                    $("#password2_msg")
                        .html("<img src='images/right.ico'>");
                    $("#password_msg")
                        .html("<img src='images/right.ico'>");
                }
            }

        });
        $("input[name=email]").blur(function(){
            var val = $(this).val();

            if(!formObj.checkNull("email","邮箱不能为空")){

            }else{
                if(!formObj.checkEmail("email","邮箱格式不正确")){
                }else{
                    $("#email_msg")
                        .html("<img src='images/right.ico'>");
                }
            }


        })
        $("input[name=phone]").blur(function(){
            var val = $(this).val();
            if(!formObj.checkNull("phone","手机号码不能为空")){

            }else{
                if(!formObj.checkphone("phone","手机号码格式不正确")){
                }else{
                    $("#phone_msg")
                        .html("<img src='images/right.ico'>");
                }
            }

        });



    });
    var formObj={
        checkForm:function(){
            var flag=true;
            //非空验证
            flag = this.checkNull("username","用户名不能为空!");
            flag = this.checkNull("password","密码不能为空")&&flag;
            flag = this.checkNull("password2","确认密码不能为空")&&flag;

            flag = this.checkNull("email","邮箱不能为空")&&flag;

            //两次输入的密码是否相同
            flag = this.checkPassword("password","两次密码不相同")&&flag;
            //邮箱格式
            flag = this.checkEmail("email","邮箱格式不正确")&&flag;
            //验证电话号码
            flag = this.checkphone("phone", "手机号格式不正确")&&flag;
            //返回flag
            return flag;
        },
        checkNull:function(name,msg){
            var value=$("input[name="+name+"]").val();
            if($.trim(value)==""){
                this.setMsg(name,msg);
                return false;
            }
            return true;
        },
        checkPassword:function(name,msg){
            var pwd=$("input[name="+name+"]").val();
            var pwd2=$("input[name="+name+"2]").val();
            if($.trim(pwd)!=""&&$.trim(pwd2)!=""){
                if(pwd!=pwd2){
                    this.setMsg(name,msg);
                    return false;
                }
            }
            return true;
        },
        checkPassword2:function(name,msg){
            var pwd=$("input[name="+name+"]").val();
            var pwd2=$("input[name="+name+"2]").val();
            if($.trim(pwd)!=""&&$.trim(pwd2)!=""){
                if(pwd!=pwd2){
                    this.setMsg(name+"2",msg);
                    return false;
                }
            }
            return true;
        },

        checkEmail:function(name,msg){
            var value=$("input[name="+name+"]").val();
            var reg=/^\w+@\w+(\.\w+)+$/;
            if(!reg.test(value)){
                this.setMsg(name,msg);
                return false;
            }
            return true;
        },

        checkphone:function(name, msg){
            var value=$("input[name="+name+"]").val();
            var reg = /^1[3|4|5|8][0-9]\d{4,8}$/;
            if(!reg.test(value)){
                this.setMsg(name,msg);
                return false;
            }
            return true;
        },

        setMsg:function(name,msg){
            $("#"+name+"_msg").text(msg);
        }
    };

    function checkbox_1(){
        //获取button
        var butn = $("input[type='checkbox']");
        if($("input[type='checkbox']").is(':checked')){
            //被选中
            alert(butn);


        }else{

        }
    }

</script>
  <head>
    <meta charset="utf-8">
    <title>乐途影评</title>
  
    <link rel="stylesheet" type="text/css" href="${ctx}/staticfile/lib/bootstrap/css/bootstrap.css">
    
    <link rel="stylesheet" type="text/css" href="${ctx}/staticfile/stylesheets/theme.css">
    <link rel="stylesheet" href="${ctx}/staticfile/lib/font-awesome/css/font-awesome.css">

    <script src="${ctx}/staticfile/lib/jquery-1.7.2.min.js" type="text/javascript"></script>
    <!--   -->
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
            <p class="block-heading">Sign Up</p>
            <div class="block-body">
                <form onsubmit="return formObj.checkForm()" action="/login/regist" target="_self">
                    <label>用户名:</label>
                    <input type="text" class="username" name="username">
                    <span id ="username_msg" style="color:red"></span>
                    <label>密  码:</label>
                    <input type="password" class="password" name="password">
                    <span id ="password_msg" style="color:red"></span>

                    <label>确认密码:</label>
                    <input type="password" class="password2" name="password2">
                    <span id="password2_msg" style="color:red"></span>
                    <label>邮  箱:</label>
                    <input type="text" class="email" name="email">
                    <span id="email_msg" style="color:red"></span>
                    <label>手机号:</label>
                    <input type="text" class="phone" name="phone">
                    <span id="phone_msg" style="color:red;"></span>
                    <%--<a href="#" onclick="formSubmit('regist','_self');this.blur();" class="btn btn-primary pull-right">注 册</a>--%>
                    <button type="submit" class="btn btn-primary pull-right">注册</button>
                    <label class="remember-me"><input type="checkbox" name="agree"> I agree with the <a href="terms-and-conditions.html">Terms and Conditions</a></label>
                    <div class="clearfix"></div>
                </form>
            </div>
        </div>
        <p><a href="/login/signin">sign-in</a></p>
    </div>
</div> 


    <script src="${ctx}/staticfile/lib/bootstrap/js/bootstrap.js"></script>

    
  </body>
</html>


