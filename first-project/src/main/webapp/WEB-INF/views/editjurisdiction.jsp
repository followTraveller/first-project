<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="addR add disappear">
	<h3>编辑权限</h3>
	<form class="form-inline" action="updateJurisdiction" method="post"
		id="submitForm">
		<div class="form-group">
			<input type="hidden" value="${jurisdiction.id}" name="id"> <label
				for="">名称：</label> <input type="text" class="form-control"
				value="${jurisdiction.jurisdictionName}"
				name="jurisdiction.jurisdictionName">
		</div>
		<div class="form-group">
			<label for="">描述：</label>
			<textarea cols="60" rows="10" style="resize: none"
				name="jurisdiction.description">${jurisdiction.description}</textarea>
		</div>
	</form>
	<div class="save">
		<button class="btn btn-info updateJurisdiction">保存</button>
		<button class="btn btn-warning" id="cancel" >取消</button>
	</div>
</div>
<script>
	$(function() {

		//取消按钮
		$("#cancel").on("click", function() {
			$(".content_panel").load("jurisdictionManage");
		});

		$(".updateJurisdiction").on("click", function() {
			$.ajax({
				url : $("#submitForm").prop("action"),
				type : "post",
				data : $("#submitForm").serialize(),
				async : false,
				success : function(data) {
					if (data.message = "success") {
						toastr.success("更新成功！");
						$(".content_panel").load("jurisdictionManage");
					} else {
						toastr.error("出现错误，请更改!");
					}
				},
			});
		});
	});
</script>