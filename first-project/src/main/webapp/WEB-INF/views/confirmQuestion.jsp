<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="zh">

<head>
<meta charset="UTF-8">
<!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">-->
<title>验证密保问题</title>
<link rel="stylesheet" type="text/css" href="css/loginStyle.css">
</head>

<body>
	<div class="htmleaf-container">
		<div class="wrapper">
			<div class="container">
				<h2>请输入您的密保问题</h2>
				<div class="group-forms">
					<!-- 注册div -->
					<div class="view  view-confirmQuestion " id="1"
						data-za-module="confirmQuestionForm">
						<form class="confirmQuestion-form" action="checkQuestion"
							id="confirmQuestion-form" autocomplete="off" method="POST"
							novalidate="novalidate">
							<div class="group-inputs">
								<div class="name input-wrapper">
									<input required="" type="text" id="administratorId"
										name="administrator.administratorId" aria-label="用户名"
										maxlength="16" placeholder="用户名"> <label
										class="error is-visible">请填写姓名</label>
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
									<input required="" type="text" name="administrator.answer"
										placeholder="密保答案">

								</div>
							</div>
							<div class="button-wrapper command">
								<!--<input  class="sign-button submit" type="button" name="" id="Signup-button" onclick="tosignin()" value="Signup" />-->
								<button class="confirmQuestion-button submit" type="submit"
									id="confirmQuestion-button">提交验证</button>
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
		var activeForm = ".view-confirmQuestion";
		$(activeForm).toggleClass("active");

		
		

		// //登录验证大块
		// // function loginForm() {
		// //     var $groupforms = $(".group-forms");
		// //     var $username=$groupforms.find(".view-signin .signin-form .group-inputs .account input").val();
		// //     var $password=$groupforms.find(".view-signin .signin-form .group-inputs .pwd input").val();
		// //     //判断是否输入值
		// //     if ($username=="" || $password="") {
		// //         alert("用户名或密码不能为空");
		// //         return;
		// //     } else {
		// //         alert("登录成功")

		// //     }
		// // }
	</script>
	<div
		style="text-align: center; margin: 50px 0; font: normal 14px/24px 'MicroSoft YaHei'; color: #000000">
		<h1>① 验证密保问题</h1>
	</div>
</body>

</html>























