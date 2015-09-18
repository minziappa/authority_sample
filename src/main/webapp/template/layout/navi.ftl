	<!-- Static navbar -->
    <nav class="navbar navbar-default navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Authority</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li <#if model??><#if model.navi??><#if model.navi == "home">class="active"</#if></#if></#if>><a href="/">Home</a></li>
            <#if user??>
            <li <#if model??><#if model.navi??>
					<#if model.navi == "aIndex" 
						|| model.navi == "inputUser"
						|| model.navi == "userList"
						|| model.navi == "userDetail">
						class="active"
            		</#if></#if></#if>><a href="/users/userList">Users</a></li>
            </#if>
            <li class="dropdown">
	        	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Options<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="/options/userList">User List A</a></li>
					<li><a href="#">Type B</a></li>
					<li><a href="#">Type C</a></li>
				</ul>
			</li>
          </ul>
	<#if user??>
		<#include "/login/naviLogin.ftl">
	<#else>
		<#include "/login/naviLogout.ftl">
	</#if>
        </div><!--/.nav-collapse -->
      </div><!--/container -->
    </nav><!--/navbar -->