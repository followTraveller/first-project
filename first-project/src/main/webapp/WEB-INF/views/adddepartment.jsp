<div class="addR add disappear">
	<h3>添加部门</h3>
	<form class="form-inline">
		<div class="form-group">
			<label for="">名称：</label>
			<input type="text" class="form-control" id="departmentName" placeholder="">
		</div>
		<div class="form-group">
			<label for="">描述：</label>
			<textarea name="" id="description" cols="60" rows="10" style="resize: none"></textarea>
		</div>
	</form>
	<div class="save">
		<button class="btn btn-info saveDepartment" id="save-Department">保存</button>
		<button class="btn btn-warning" id="cancel">取消</button>
	</div>
</div>
<script>
	$(function() {
		
		//取消按钮
		$("#cancel").on("click", function() {
			$(".content_panel").load("departmentManage");
		});
		
		//保存提交按钮
		$(".saveDepartment").on("click", function() {
			var departmentName = $("#departmentName").val();
			var description = $("#description").val();
			$.ajax({
				url : "adddepartment",
				sync : "true",
				type : "post",
				data : {
					"department.departmentName" : departmentName,
					"department.description" : description
				},
				success : function() {
					toastr.success("保存成功！");
					$(".content_panel").load("departmentManage");
				},
			});
		});
	});
</script>