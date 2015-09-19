<#macro myLayout title="FreeMarker example">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<#include "header.ftl"/>
	<body>
	<#include "navi.ftl"/>
    <div class="container">
    	<#if model??><#if model.navi??>
			<#if model.navi == "auth">
				<#include "authMenu.ftl"/>
			<#elseif model.navi == "users">
				<#include "usersMenu.ftl"/>
			</#if>
		</#if></#if>>
    	<div class="jumbotron">
			<#nested/>
		</div><!-- /jumbotron -->
		<#include "footer.ftl">
    </div><!-- /container -->
	</body>
</html>
</#macro>