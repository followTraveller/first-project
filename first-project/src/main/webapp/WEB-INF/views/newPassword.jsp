<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!DOCTYPE html>
<html lang="zh">

<head>
    <meta charset="UTF-8">
    <!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">-->
    <title>重置密码</title>
    <link rel="stylesheet" type="text/css" href="css/loginStyle.css">
</head>

<body>
    <div class="htmleaf-container">
        <div class="wrapper">
            <div class="container">
                <h2>请输入您的新密码</h2>
                <div class="group-forms">
                    <!-- 注册div -->
                    <div class="view  view-newPassword " id="1" data-za-module="newPasswordForm">
                        <form class="newPassword-form" action="updatePassword" id="newPassword-form" autocomplete="off" method="POST" novalidate="novalidate">
                            <div class="group-inputs">
                            <input type="hidden" value="${administratorId}" name="administrator.administratorId" id="administratorId">
                                <div class="pwd input-wrapper">
                                    <input required="" type="password" name="administrator.password" aria-label="密码" placeholder="请输入新密码"  minlength="6" maxlength="16" autocomplete="off">
                                </div>
                                <div class="pwd input-wrapper">
                                    <input required="" type="password" name="confirmPassword" aria-label="密码" placeholder="请重复新密码"  minlength="6" maxlength="16" autocomplete="off">
                                </div>
                            </div>
                            <div class="button-wrapper command">
                                <!--<input  class="sign-button submit" type="button" name="" id="Signup-button" onclick="tosignin()" value="Signup" />-->
                                <button class="newPassword-button submit" type="submit" id="newPassword-button">提交更改</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <ul class="bg-bubbles">
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
            </ul>
        </div>
    </div>
    <script src="jquery/jquery-3.2.1.min.js"></script>
    <script>
    var activeForm = ".view-newPassword";
    $(activeForm).toggleClass("active");
    
    $(function(){
    	
		$("#newPassword-button").click(function(){
		
			var pwd = $("input[name='administrator.password']").val();

			var cpwd = $("input[name='confirmPassword']").val();
			if(pwd != cpwd){
				alert("两次密码不一致!");
				$("input[name='administrator.password']").val("");
				$("input[name='confirmPassword']").val("");
				return false;
			}
		});
	});
    
    
    </script>
    <div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';color:#000000">
        <h1>② 重置密码</h1>
    </div>
</body>

</html>                  
                                
                            
                                
                       