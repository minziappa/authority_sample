<#import "../layout/authLayout.ftl" as layout>
<@layout.myLayout>
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
	              <td>${model.users.userName?if_exists}</td>
	            </tr>
	            <tr>
	              <td>User pwd</td>
	              <td>${model.users.userPwd?if_exists}</td>
	            </tr>
	            <tr>
	              <td>User Status</td>
	              <td>${model.users.userStatus?if_exists}</td>
	            </tr>
	        </table>
			</div>
		</div> <!-- /panel panel-primary -->
</@layout.myLayout>