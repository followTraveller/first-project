<div class="addR add disappear">
	<h3>添加权限</h3>
	<form class="form-inline">
		<div class="form-group">
			<label for="">名称：</label>
			<input type="text" class="form-control" id="jurisdictionName" placeholder="">
		</div>
		<div class="form-group">
			<label for="">描述：</label>
			<textarea name="" id="description" cols="60" rows="10" style="resize: none"></textarea>
		</div>
	</form>
	<div class="save">
		<button class="btn btn-info saveJurisdiction">保存</button>
		<button class="btn btn-warning" id="cancel">取消</button>
	</div>
</div>
<script>
	$(function() {
	
		//取消按钮
		$("#cancel").on("click", function() {
			$(".content_panel").load("jurisdictionManage");
		});
		
		//保存提交按钮
		$(".saveJurisdiction").on("click", function() {
			var jurisdictionName = $("#jurisdictionName").val();
			var description = $("#description").val();
			$.ajax({
				url : "addJurisdiction",
				sync : "true",
				type : "post",
				data : {
					"jurisdiction.jurisdictionName" : jurisdictionName,
					"jurisdiction.description" : description
				},
				success : function() {
					toastr.success("保存成功！");
					$(".content_panel").load("jurisdictionManage");
				},
			});
		});
			 
		
	});
</script>