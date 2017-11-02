<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="addR add disappear">
	<h3>编辑角色</h3>
	<form class="form-inline" action="updateRole" method="post"
		id="submitForm">
		<div class="form-group">
			<input type="hidden" value="${role.id}" name="id"> <label
				for="">名称：</label> <input type="text" class="form-control"
				name="role.roleName" value="${role.roleName}">
		</div>
		<div class="form-group">
			<label for="">描述：</label>
			<textarea name="role.description" cols="60" rows="10"
				style="resize: none">${role.description}</textarea>
		</div>
		<div class="form-group">
			<label for="">权限：</label>
			<c:forEach var="item" items="${listJurisdiction }" varStatus="status">
				<input type="checkbox" name="quanxian" value="">${item.jurisdictionName }
				</c:forEach>
		</div>
	</form>
	<div class="save">
		<button class="btn btn-info updateRole">保存</button>
		<button class="btn btn-warning" id="cancel">取消</button>
	</div>
</div>
<script>
	$(function() {

		//取消按钮
		$("#cancel").on("click", function() {
			$(".content_panel").load("roleManage");
		});

		$(".updateRole").on("click", function() {
			$.ajax({
				url : $("#submitForm").prop("action"),
				type : "post",
				data : $("#submitForm").serialize(),
				async : false,
				success : function(data) {
					if (data.message="success") {
						toastr.success("更新成功！");
						$(".content_panel").load("roleManage");
					} else {
						alert("输入有错！！！");
					}
				},
			});
		});
	});
</script>