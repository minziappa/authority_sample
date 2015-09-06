<#macro myLayout title="FreeMarker example">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<#include "header.ftl"/>
	<body>
	<#include "navi.ftl"/>
    <div class="container">
    	<div class="jumbotron">
		<#include "menu.ftl"/>
		<#nested/>

		</div><!-- /jumbotron -->
    </div><!-- /container -->
	<#include "footer.ftl">
	</body>
</html>
</#macro>