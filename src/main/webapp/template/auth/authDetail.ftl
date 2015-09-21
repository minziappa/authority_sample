<#import "../layout/authLayout.ftl" as layout>
<@layout.myLayout>
<script>
function submitform() {
  document.myForm.submit();
}
</script>
		<form name="myForm" action="/auth/deleteAuth" method="POST">
			<input type="hidden" name="authority" value="${model.auth.authority?if_exists}" autocomplete="off" />
		</form>

		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">The detail authority</h3>
			</div>
			<div class="panel-body">
			<table class="table table-striped">
	            <tr>
	              <td>#</td>
	              <td>${model.auth.authorityId?if_exists}</td>
	            </tr>
	            <tr>
	              <td>authority</td>
	              <td><input class="readonly" type="text" name="authority" size="10" maxlength="14" value="${model.auth.authority?if_exists}" disabled="disabled"></td>
	            </tr>
	        </table>
			</div>
		</div> <!-- /panel panel-primary -->
		<a href="/users/inputUser"><button type="button" class="btn btn-primary">Update</button></a>

		<button type="button" class="btn btn-primary" onclick="javascript: submitform();">Delete</button>
		<button type="button" class="btn btn-primary" onClick="javascript:history.back(-1);">Cancel</button>
</@layout.myLayout>