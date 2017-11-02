<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="addR add disappear">
	<h3>编辑部门</h3>
	<form class="form-inline" action="updateDepartment" method="post"
		id="submitForm">
		<div class="form-group">
			<input type="hidden" value="${department.id}" name="id"> <label
				for="">名称：</label> <input type="text" class="form-control"
				name="department.departmentName"
				value="${department.departmentName}">
		</div>
		<div class="form-group">
			<label for="">描述：</label>
			<textarea name="department.description" cols="60" rows="10">${department.description}</textarea>
		</div>
	</form>
	<div class="save">
		<button class="btn btn-info updateDepartment">保存</button>
		<button class="btn btn-warning" id="cancel">取消</button>
	</div>
</div>
<script>
	$(function() {

		//取消按钮
		$("#cancel").on("click", function() {
			$(".content_panel").load("departmentManage");
		});

		//更新
		$(".updateDepartment").on("click", function() {
			$.ajax({
				url : $("#submitForm").prop("action"),
				type : "post",
				data : $("#submitForm").serialize(),
				async : false,
				success : function(data) {
					if(data.message="success"){
						toastr.success("更新成功！");
						$(".content_panel").load("departmentManage");	
					}
					else{
						toastr.error("出现错误，请更改！");
					}
					
				},
			});
		});
	});
</script>