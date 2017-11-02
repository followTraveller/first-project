<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="addR add disappear">
	<h3>添加角色</h3>
	<form class="form-inline">
		<div class="form-group">
			<label for="">名称：</label>
			<input type="text" class="form-control" id="roleName" placeholder="">
		</div>
		<div class="form-group">
			<label for="">描述：</label>
			<textarea name="" id="description" cols="60" rows="10" style="resize: none"></textarea>
		</div>
		<div class="form-group">
			<label for="">权限：</label>
			<c:forEach var="item" items="${listJurisdiction }" varStatus="status">
					<input type="checkbox" name="quanxian" value="">${item.jurisdictionName }
				</c:forEach>
		</div>
	</form>
	<div class="save">
		<button class="btn btn-info saveRole">保存</button>
		<button class="btn btn-warning" id="cancel">取消</button>
	</div>
</div>
<script>
	$(function() {
		
		//取消按钮
		$("#cancel").on("click", function() {
			$(".content_panel").load("roleManage");
		});
		
		//保存提交按钮
		$(".saveRole").on("click", function() {
			var roleName = $("#roleName").val();
			var description = $("#description").val();			
			$.ajax({
				cache : true,
				type : "POST",
				url : "addrole",
				data : {
					"role.roleName" : roleName,
					"role.description" : description
				},
					/* $('#form').serialize(),// 你的formid */
				async : false,
				success : function() {
					toastr.success("保存成功！");
					$(".content_panel").load("roleManage");
				}
			});
		});		
	});
</script>