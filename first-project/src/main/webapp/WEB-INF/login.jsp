<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh">

<head>
<meta charset="UTF-8">
<!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">-->
<title>用户管理系统——请登录</title>
<link rel="stylesheet" type="text/css" href="css/loginStyle.css">
<link rel="stylesheet" type="text/css" href="css/iconfont.css">
</head>

<body>
	<div class="htmleaf-container">
		<div class="wrapper">
			<div class="container">
				<h1>Welcome</h1>
				<div class="group-forms">
					<!-- 注册div -->
					<div class="view  view-signup " id="1" data-za-module="SignUpForm">
						<form class="signup-form" action="register" id="sign-form-1"
							autocomplete="off" method="POST" novalidate="novalidate">
							<div class="index-tab-navs">
								<div class="navs-slider">
									<ul>
										<li><a href="#" class="li1" onclick="signup()">注册</a></li>
										<li><a href="#" class="li2" onclick="signin()">登录</a></li>
									</ul>
								</div>
							</div>
							<div class="group-inputs">
								<div class="name input-wrapper">
									<input required type="text"
										name="administrator.administratorId" aria-label="用户名"
										maxlength="16" placeholder="用户名"> <label
										class="error is-visible">请填写姓名</label>
								</div>
								<div class="pwd input-wrapper">
									<input required type="password"
										name="administrator.password" aria-label="密码"
										placeholder="密码（不少于 6 位）" minlength="6" maxlength="16"
										autocomplete="off"> <label class="error is-visible">请填写密码</label>
								</div>
								<div class="question input-wrapper">
									<select name="administrator.question" required
										placeholder="请选择密保问题">
										<option value="您的生日？？">您的生日？？</option>
										<option value="您父亲/母亲的名字？？">您父亲/母亲的名字？？</option>
										<option value="您父亲/母亲的生日？？">您父亲/母亲的生日？？</option>
										<option value="您小学班主任的名字？？">您小学班主任的名字？？</option>
										<option value="您高中班主任的名字？？">您高中班主任的名字？？</option>
									</select>
								</div>
								<div class="answer input-wrapper">
									<input required type="text" name="administrator.answer"
										placeholder="密保答案">
								</div>
							</div>
							<div class="button-wrapper command">
								<!--<input  class="sign-button submit" type="button" name="" id="Signup-button" onclick="tosignin()" value="Signup" />-->
								<button class="sign-button submit" type="submit"
									id="Signup-button">Signup</button>
							</div>
						</form>
					</div>
					<!-- 登录div -->
					<div class="view view-signin " id="2" data-za-module="SignInForm">
						<form class="signin-form"
							action="${pageContext.request.contextPath }/login" method="POST"
							novalidate="novalidate" id="sign-form-2">
							<div class="index-tab-navs">
								<div class="navs-slider">
									<ul>
										<li><a href="#" class="li1" onclick="signup()">注册</a></li>
										<li><a href="#" class="li2" onclick="signin()">登录</a></li>
									</ul>
								</div>
							</div>
							<div class="group-inputs">
								<div class="account input-wrapper">
									<input type="text" name="administrator.administratorId"
										aria-label="用户名" placeholder="用户名" maxlength="16" required="">
									<label class="error is-visible">请填写手机号或邮箱</label> <label
										class="error is-visible">账号或密码错误</label>
								</div>
								<div class="pwd input-wrapper">
									<input type="password" name="administrator.password"
										aria-label="密码" placeholder="密码" minlength="6" maxlength="16"
										required=""> <label class="error is-visible">请填写密码</label>
								</div>
							</div>
							<div class="button-wrapper command">
								<button class="sign-button submit" type="button"
									id="login-button">Login</button>
							</div>
							<div class="signin-misc-wrapper clearfix">
								<a class="unable-login" href="toCheckQuestion">无法登录？</a>
								<div>${message }</div>
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
		var activeForm = ".view-signin";
		$(activeForm).toggleClass("active");
		var activeLi = ".li2";
		$(activeLi).toggleClass("selected");
		//登录跳转过度动画
		$("#login-button").click(function(event) {
			$(".wrapper").addClass("form-success");
			$(".group-forms").fadeOut(1000, function() {
				$("#sign-form-2").submit();
			});

		});

		//form标签添加active
		function toggle(Mid) {
			if (activeForm != Mid) {
				$(activeForm).toggleClass("active");
				$(Mid).addClass("active");
				activeForm = Mid;
			}

		};

		//li标签添加selected
		function active(Mid) {
			if (activeLi != Mid) {
				$(activeLi).toggleClass("selected");
				$(Mid).addClass("selected");
				activeLi = Mid;
			}
		};

		function tosignin(ooo) {
			ooo.preventDefault();
			toggle(".view-signin");
			active(".li2");
		}

		function signup() {
			toggle(".view-signup");
			active(".li1");
		};

		function signin() {
			toggle(".view-signin");
			active(".li2");
		};
	</script>
	<div class="title-panel">
		<span class="span-font" id="ifont-1">6S</span>
		<div class="title-font">&nbsp; 用户管理系统</div>
	</div>
</body>

</html>