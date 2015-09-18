	<ul role="tablist" class="nav nav-tabs">
		<li <#if model??><#if model.navi??><#if model.navi == "aIndex">class="active"</#if></#if></#if>><a href="/users/">Index</a></li>
		<li <#if model??><#if model.navi??><#if model.navi == "inputUser">class="active"</#if></#if></#if>><a href="/users/inputUser">Input user</a></li>
		<li <#if model??><#if model.navi??><#if model.navi == "userList">class="active"</#if></#if></#if>><a href="/users/userList">User list</a></li>
		<li <#if model??><#if model.navi??><#if model.navi == "userDetail">class="active"</#if></#if></#if>><a href="#">User Detail</a></li>
		<li <#if model??><#if model.navi??><#if model.navi == "options">class="active"</#if></#if></#if>><a href="/options/userList">Options</a></li>
	</ul>