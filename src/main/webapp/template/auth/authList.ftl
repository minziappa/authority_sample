<#import "../layout/authLayout.ftl" as layout>
<@layout.myLayout>
<table class="table table-striped">
	<thead>
	  <tr>
	    <th>authorityId</th>
	    <th>authority</th>
	  </tr>
	</thead>

	<tbody>
<#if model??>
	<#if model.authList?has_content>
		<#list model.authList as auth>
		  <tr>
		    <td>${auth.authorityId?if_exists}</td>
		    <td><a href="/auth/authDetail?authority=${auth.authority?if_exists}">${auth.authority?if_exists}</a></td>
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