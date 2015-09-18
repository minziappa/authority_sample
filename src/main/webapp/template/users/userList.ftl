<#import "../layout/authLayout.ftl" as layout>
<@layout.myLayout>
<table class="table table-striped">
	<thead>
	  <tr>
	    <th>#</th>
	    <th>User Name</th>
	    <th>User Pwd</th>
	    <th>User Status</th>
	  </tr>
	</thead>

	<tbody>
<#if model??>
	<#if model.usersList?has_content>
		<#list model.usersList as user>
		  <tr>
		    <td>${user.userId?if_exists}</td>
		    <td><a href="/users/userDetail?userName=${user.userName?if_exists}">${user.userName?if_exists}</a></td>
		    <td><input type="text" name="pwd" value="${user.userPwd?if_exists}"<#if user.userStatus == "2">disabled</#if>></td>
		    <td>${user.userStatus?if_exists}</td>
		  </tr>
		</#list>
	<#else>
		No data
	</#if>
<#else>
	No data
</#if>
	</tbody>
</table>
</@layout.myLayout>