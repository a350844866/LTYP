<%--
  Created by IntelliJ IDEA.
  User: 胡佳豪
  Date: 2017/10/21
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    <!-- Demo page code -->

    <style type="text/css">
        #line-chart {
            height: 300px;
            width: 800px;
            margin: 0px auto;
            margin-top: 1em;
        }

        .brand {
            font-family: georgia, serif;
        }

        .brand .first {
            color: #ccc;
            font-style: italic;
        }

        .brand .second {
            color: #fff;
            font-weight: bold;
        }
    </style>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="${ctx}/staticfile/shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="${ctx}/staticfile/apple-touch-icon-precomposed" sizes="144x144"
          href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="${ctx}/staticfile/apple-touch-icon-precomposed" sizes="114x114"
          href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="${ctx}/staticfile/apple-touch-icon-precomposed" sizes="72x72"
          href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="${ctx}/staticfile/apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
</head>

<!--[if lt IE 7 ]>
<body class="ie ie6"> <![endif]-->
<!--[if IE 7 ]>
<body class="ie ie7 http-error"> <![endif]-->
<!--[if IE 8 ]>
<body class="ie ie8 http-error"> <![endif]-->
<!--[if IE 9 ]>
<body class="ie ie9 http-error"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<body class="http-error">
<!--<![endif]-->


<div class="row-fluid">
    <div class="http-error">
        <div class="http-error-message">
            <div class="error-caption">
                <p>友情提示：</p>
            </div>
            <div class="error-message">
                <p>${msg}<p>
                <p class="return-home"><a href="${ctx}/movie/showmovie">返回到主页</a></p>
            </div>
        </div>
    </div>
</div>


<script src="${ctx}/staticfile/lib/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
    $("[rel=tooltip]").tooltip();
    $(function () {
        $('.demo-cancel-click').click(function () {
            return false;
        });
    });
</script>

</body>
</html>
