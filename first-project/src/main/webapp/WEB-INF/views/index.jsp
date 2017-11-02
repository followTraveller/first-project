<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>用户管理系统</title>
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.css">
<link href="css/toastr.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="jquery/jquery-3.2.1.min.js"></script>
<script src="js/toastr.js"></script>
<script type="text/javascript" src="jquery/jquery.form.js"></script>
<link rel="stylesheet" type="text/css" href="css/indexStyle.css">
</head>

<body>
	<div id="topPanel">
		<div class="logo_panel">
			<div class="logo_content_panel"></div>
			<h3>用户管理系统-UMS</h3>
		</div>
		<div class="help_panel">
			<ul>
				<li><a href="toLogin" onclick="session.invalidate(); "
					class="logout">退出</a></li>
			</ul>
		</div>
		<form id="avatarForm" action="saveAvatar" method="post"
			enctype="multipart/form-data">
			<!-- 把文件框隐藏，在点击图片的时候触发文件框的点击事件 -->
			<span style="display: none"><input type="file"
				onchange="uploadPic()" name="upload"></span>
		</form>
		<div class="avatar1_panel">
			<div class="avatar1_content_panel">
				<img id="avatarImg" src="${administrator.avatarPath }" />
			</div>
		</div>
	</div>
	<div id="bottomPanel">
		<div class="menu_panel">
			<div class="menu_content_panel">
				<ul>
					<li class="active li1" onclick="accountManage()"><a
						href="javascript:;">账号管理</a></li>
					<li class="li2" onclick="roleManage()"><a href="javascript:;">角色管理</a>
					</li>
					<li class="li3" onclick="superManage()"><a href="javascript:;">权限管理</a>
					</li>
					<li class="li4" onclick="departManage()"><a
						href="javascript:;">部门管理</a></li>
				</ul>
			</div>
		</div>
		<div class="content_panel"></div>
	</div>
	<script>
		$(function() {
			
			//提示框属性设置
			toastr.options = {
					//展现时间
					"timeOut": "1000", 
					//消失的动画时间
					"hideDuration": "8000",
			}

			// 点击图片的时候触发上传文件的输入框的点击事件
			$("#avatarImg").on("click", function() {
				 if (confirm("确定要上传头像吗？")) { 
					$("input[type=file]").click();
				}
			});

			//功能跳转
			$(".li1").on("click", function() {
				$(".content_panel").load("accountManage");
			}).first().click();

			$(".li2").on("click", function() {
				$(".content_panel").load("roleManage");
			});

			$(".li3").on("click", function() {
				$(".content_panel").load("jurisdictionManage");
			});

			$(".li4").on("click", function() {
				$(".content_panel").load("departmentManage");
			});

		});

		var activeModule = ".accountM";
		$(activeModule).toggleClass("active");
		var activeLi = ".li1";
		function active(Mid) {
			if (activeLi != Mid) {
				$(activeLi).toggleClass("active");
				$(Mid).addClass("active");
				activeLi = Mid;
			}

		};

		function accountManage() {
			active(".li1")
		};

		function roleManage() {
			active(".li2")
		};

		function superManage() {
			active(".li3")
		};

		function departManage() {
			active(".li4")

		};

		//上传头像
		function uploadPic() {

			var file = $("input[type=file]").val();
			// 文件名
			var filename = file.replace(/.*(\/|\\)/, "");
			// 后缀
			var fileExt = (/[.]/.exec(filename)) ? /[^.]+$/.exec(filename
					.toLowerCase()) : '';
			// 判断文件格式
			if (fileExt != "png" && fileExt != "jpg") {
				alert("上传的文件格式不符合要求，请上传 png 或者 jpg 格式的图片");
				return;
			}
			// 上传设置  
			var options = {
				// 规定把请求发送到那个URL  
				url : "saveAvatar",
				// 请求方式  
				type : "post",
				// 服务器响应的数据类型  
				dataType : "json",
				// 请求成功时执行的回调函数  
				success : function(data, status, xhr) {
					toastr.success("头像修改成功！");
					// 图片显示地址  
					$("#avatarImg").attr("src", data.imgPath);
				}
			}

			$("#avatarForm").ajaxSubmit(options);
		}
	</script>

</body>

</html>