<#import "../layout/authLayout.ftl" as layout>
<@layout.myLayout>
<script>
function submitform() {
  document.myForm.submit();
}
</script>
		<form name="myForm" action="/users/deleteUser" method="POST">
			<input type="hidden" name="userName" value="${model.users.userName?if_exists}" autocomplete="off" />
		</form>

		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Select Data</h3>
			</div>
			<div class="panel-body">
			<table class="table table-striped">
	            <tr>
	              <td>#</td>
	              <td>${model.users.userId?if_exists}</td>
	            </tr>
	            <tr>
	              <td>User Name</td>
	              <td><input class="readonly" type="text" name="userName" size="10" maxlength="14" value="${model.users.userName?if_exists}" disabled="disabled"></td>
	            </tr>
	            <tr>
	              <td>User pwd</td>
	              <td><input class="readonly" type="text" name="userPwd" size="10" maxlength="14" value="${model.users.userPwd?if_exists}" readonly="readonly"></td>
	            </tr>
	            <tr>
	              <td>User Status</td>
	              <td><input class="readonly" type="text" name="userStatus" size="10" maxlength="14" value="${model.users.userStatus?if_exists}" readonly="readonly"></td>
	      		</tr>
	        </table>
			</div>
		</div> <!-- /panel panel-primary -->
		<a href="/users/inputUser"><button type="button" class="btn btn-primary">Update</button></a>

		<button type="button" class="btn btn-primary" onclick="javascript: submitform();">Delete</button>
		<button type="button" class="btn btn-primary" onClick="javascript:history.back(-1);">Cancel</button>
</@layout.myLayout>