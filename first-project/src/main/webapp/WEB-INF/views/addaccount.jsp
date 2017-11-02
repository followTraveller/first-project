<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="addM add disappear">
	<h3>添加用户</h3>
	<form class="form-inline"  action="addaccount" method="post" id="submitForm">
		<div class="form-group">
			<label for="exampleInputName2">用户ID：</label> <input type="text"
				class="form-control" id="account.accountId" name="account.accountId" minlength="6" maxlength="16"
				 required>
		</div>
		<div class="form-group">
			<label for="exampleInputEmail2">密码：</label> <input type="password"
				class="form-control" id="password" name="account.password" minlength="6"
				maxlength="16" placeholder="（不少于6位）" required>
		</div>
		<div class="form-group">
			<label for="exampleInputName2">用户名：</label> <input type="text"
				class="form-control" id="accountName" name="account.accountName" >
		</div>
		<div class="form-group">
			<label for="exampleInputName2">手机：</label> <input type="text"
				class="form-control" id="phone" name="account.phone" >
		</div>
		<div class="form-group">
			性别： <input type="radio" name="account.gender" value="男" checked>男 <input
				type="radio" name="account.gender" value="女">女
		</div>

		<div class="form-group">
			部门： <select name="account.department.id" id="accountDepartment">
				<c:forEach var="item" items="${listDepartment }" varStatus="status">
					<option value="${item.id }">${item.departmentName }</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			状态： <input type="radio" name="account.state" value="启用" checked>启用 <input
				type="radio" name="account.state" value="禁用">禁用
		</div>
		<div class="form-group">
			角色： <select name="account.role.id" id="accountRole">
				<c:forEach var="item" items="${listRole }" varStatus="status">
					<option value="${item.id }">${item.roleName }</option>
				</c:forEach>
			</select>
		</div>
	</form>
	<div class="save">
		<button type="button" class="btn btn-info saveAccount"
			id="save-Account">保存</button>
		<button class="btn btn-warning" id="cancel">取消</button>
	</div>
</div>
<script>
	$(function() {

		//取消按钮
		$("#cancel").on("click", function() {
			$(".content_panel").load("accountManage");
		});

		//保存提交按钮
		$(".saveAccount").on("click", function() {
			$.ajax({
				cache : true, 
				type : "POST",
				url :  $('#submitForm').prop("action"),
				data :  $('#submitForm').serialize(), // formid
				async : false,
				success : function() {			
					toastr.success("保存成功！");	
					$(".content_panel").load("accountManage");
				}
			});
		});		
	});
</script>