<#import "../layout/defaultLayout.ftl" as layout>
<@layout.myLayout>
<script>
function editUser() {
	var inputs = document.getElementsByName("pwd");
	var cntInput = inputs.length;
	for (i=0; i < cntInput; i++) {
		var v = inputs[i].value;
	    if (v==null || v=="" || v=="0") {
	    	inputs[i].style.border = "1px solid red";
	        isError = false;
	    } else {
			console.log("v => " + v);
			inputs[i].disabled = true;
	    }
	}
}

function test() {
	var inputs = document.getElementsByName("pwd");
	var cntInput = inputs.length;
	for (i=0; i < cntInput; i++) {
		var v = inputs[i].value;
	    if (v==null || v=="" || v=="0") {
	    	inputs[i].style.border = "1px solid red";
	        isError = false;
	    } else {
			console.log("v => " + v);
			inputs[i].disabled = false;
	    }
	}
}
</script>

<table class="table table-striped">
	<thead>
	  <tr>
	    <th>#</th>
	    <th>User Name</th>
	    <th>User Pwd</th>
	    <th>User Status</th>
	    <th>Edite</th>
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
		    <td><button type="button" onclick="editUser()">Edit</button><button type="button" onclick="test()">test</button></td>
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