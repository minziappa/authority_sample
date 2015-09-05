<#import "../layout/defaultLayout.ftl" as layout>
<@layout.myLayout>
<div class="panel panel-primary">
	<div class="panel-heading">
		<h3 class="panel-title">Select Data</h3>
	</div>
	<div class="panel-body">
		<form action="/users/registerUser" method="POST">
		<b style="color:red" >
		<#if mapErrorMessage??>
			<#list mapErrorMessage?keys as key>
			    ${mapErrorMessage[key]} <br/>
			</#list>
		</#if>
		</b>
		<table style="border-collapse: collapse;">
			<tr>
				<td style="padding: 3px;">userName</td>
				<td style="padding: 3px;"><input type="text" name="userName" size="10" maxlength="14"></td>
				<td style="padding: 3px;">Example) Joon</td>
			</tr>
			<tr>
				<td style="padding: 3px;">userPwd</td>
				<td style="padding: 3px;"><input type="text" name="userPwd" size="10" maxlength="14"></td>
				<td style="padding: 3px;">Example) password</td>
			</tr>
			<tr>
				<td style="padding: 3px;">userStatus</td>
				<td style="padding: 3px;">
					<select name="userStatus">
						<option value="1">Admin</option>
						<option value="2">Semi-Admin</option>
						<option value="3">User</option>
					</select>
				</td>
				<td style="padding: 3px;"></td>
			</tr>
			<tr>
				<td style="padding: 3px;"><input class="btn btn-sm btn-primary" type="submit" value="Register"/></td>
				<td style="padding: 3px;"></td>
				<td style="padding: 3px;"></td>
			</tr>
		</table>
		</form>
	</div> <!-- /panel-body -->
</div> <!-- /panel panel-primary -->
</@layout.myLayout>