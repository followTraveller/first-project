<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="addM add disappear">
	<h3>编辑用户</h3>
	<form class="form-inline" action="updateAccount" method="post"
		id="submitForm">
		<div class="form-group">
			<input type="hidden" value="${account.id}" name="id"> <label
				for="exampleInputName2">用户ID：</label> <input type="text"
				class="form-control" id="exampleInputName2" minlength="6"
				maxlength="16" value="${account.accountId}" name="account.accountId"
				required>
		</div>
		<div class="form-group">
			<label for="exampleInputEmail2">密码：</label> <input type="email"
				class="form-control" id="exampleInputEmail2" minlength="6"
				maxlength="16" placeholder="（不少于6位）" value="${account.password}"
				name="account.password" required>
		</div>
		<div class="form-group">
			<label for="exampleInputName2">姓名：</label> <input type="text"
				class="form-control" id="exampleInputName2"
				value="${account.accountName}" name="account.accountName" required>
		</div>
		<div class="form-group">
			<label for="exampleInputName2">手机：</label> <input type="text"
				class="form-control" id="exampleInputName2" value="${account.phone}"
				name="account.phone" required>
		</div>
		<div class="form-group" id="gender">
			<c:if test="${account.gender eq '男'}">
		性别： <input type="radio" name="account.gender" value="男"
					checked="checked">男 <input type="radio"
					name="account.gender" value="女">女
		</c:if>
			<c:if test="${account.gender eq '女'}">
		性别： <input type="radio" name="account.gender" value="男">男 <input
					type="radio" name="account.gender" value="女" checked="checked">女
		</c:if>

		</div>
		<div class="form-group">
			部门： <select name="account.department.id">
				<c:forEach var="item" items="${listDepartment }" varStatus="status">
					<option value="${item.id }">${item.departmentName }</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">

			<c:if test="${account.state eq '启用'}">
		状态： <input type="radio" name="account.state" value="启用"
					checked="checked">启用
			  <input type="radio" name="account.state" value="禁用">禁用
		</c:if>
			<c:if test="${account.state eq '禁用'}">
		状态： <input type="radio" name="account.state" value="启用">启用
		      <input type="radio" name="account.state" value="禁用"
					checked="checked">禁用
		</c:if>
		</div>
		<div class="form-group">
			角色： <select name="account.role.id">
				<c:forEach var="item" items="${listRole }" varStatus="status">
					<c:if test="${account.role.id eq item.id }">
						<option value="${item.id }" selected="selected">${item.roleName }</option>
					</c:if>
					<c:if test="${account.role.id ne item.id  }">
						<option value="${item.id }">${item.roleName }</option>
					</c:if>
				</c:forEach>
			</select>
		</div>
	</form>
	<div class="save">
		<button class="btn btn-info updateAccount">保存</button>
		<button class="btn btn-warning" id="cancel">取消</button>
	</div>
</div>
<script>
	$(function() {

		//取消
		$("#cancel").on("click", function() {
			$(".content_panel").load("accountManage");
		});

		//保存更新用户信息
		$(".updateAccount").on("click", function() {
			$.ajax({
				url : $("#submitForm").prop("action"),
				type : "post",
				data : $("#submitForm").serialize(),
				async : false,
				success : function(data) {
					if(data.message="success"){
						toastr.success("更新成功！");
						$(".content_panel").load("accountManage");	
					}
					else{
						toastr.error("出现错误，请更改！");
					}
				},
			});
		});
	});
</script>