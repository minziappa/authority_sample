<#import "../layout/authLayout.ftl" as layout>
<@layout.myLayout>
<div class="panel panel-primary">
	<div class="panel-heading">
		<h3 class="panel-title">Insert Auth</h3>
	</div>
	<div class="panel-body">
		<form action="/auth/registerAuth" method="POST">
		<b style="color:red" >
		${errorMessage?if_exists}
		<#if mapErrorMessage??>
			<#list mapErrorMessage?keys as key>
			    ${mapErrorMessage[key]} <br/>
			</#list>
		</#if>
		</b>
		<table style="border-collapse: collapse;">
			<tr>
				<td style="padding: 3px;">authority</td>
				<td style="padding: 3px;"><input type="text" name="authority" size="10" maxlength="14"></td>
				<td style="padding: 3px;">Example) Joon</td>
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