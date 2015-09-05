<#import "../layout/defaultLayout.ftl" as layout>
<@layout.myLayout>
<table class="table table-striped">
	<thead>
	  <tr>
	    <th>#</th>
	    <th>User Name</th>
	    <th>User Status</th>
	    <th>User Pwd</th>
	  </tr>
	</thead>

	<tbody>
<#if model??>
	<#if model.usersList?has_content>
		<#list model.usersList as user>
		  <tr>
		    <td>${user.userId?if_exists}</td>
		    <td><a href="/user/userDetail?userName=${user.userName?if_exists}">${user.userName?if_exists}</a></td>
		    <td>${user.userStatus?if_exists}</td>
		    <td>${user.userPwd?if_exists}</td>
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