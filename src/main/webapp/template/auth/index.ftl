<#import "../layout/authLayout.ftl" as layout>
<@layout.myLayout>

<div class="row">
	<div class="col-md-5">
	  	<span>Input a user information.</span>
	</div>
	<div class="col-md-2">
	  	<span>2.</span> 
	</div>
	<div class="col-md-5">
	  	<span>Input a user information.</span> 
	</div>
	<div class="col-md-5">
	  <input id="theValue" type="text" size="35" name="users" autocomplete="off"/>
      <select id="users" size="10" multiple='multiple' class="form-control">
		<#if model??>
  		<#if model.usersList?has_content>
			<#list model.usersList as users>
			  <option value="${users.userName?if_exists}">${users.userName?if_exists}</option>
			</#list>
		</#if>
		</#if>
      </select>
	</div>
	<div class="col-md-2">
	  	<button type="button" class="btn btn-primary" onclick="javascript: moveItem();">move</button>
	  	<button type="button" class="btn btn-primary" onclick="javascript: backItem();">back</button>
	</div>
	<div class="col-md-5">
	  	Auth
	  	<form name="myForm" action="/auth/deleteAuth" method="POST">
	  	<select id="authId" name="authority" class="form-control" onchange="changeAuthList()">
	  		<option value="">-- Please Select --</option>
	  		<#if model??>
	  		<#if model.authList?has_content>
				<#list model.authList as auth>
				  <option value="${auth.authority?if_exists}">${auth.authority?if_exists}</option>
				</#list>
			</#if>
			</#if>
		  </select>
		<select id="usersAuthId" name="usersAuth" size="10" multiple='multiple' class="form-control">
        </select>
      </form>
	</div>
</div>

<script>

var users = document.getElementById("users");
var auths = document.getElementById("authId");
var usersAuth = document.getElementById("usersAuthId");

function checkIsDefault() {
	console.log(">>>> 1abcde >> " + auths.selectedIndex);
	if(auths.selectedIndex == 0) {
		console.log(">>>> 2abcde" + auths.selectedIndex);
		return false;
	}
	return true;
}

function moveItem() {

	// Check default
	if(!checkIsDefault()) {
		alert("alert >>> ");
		return false;
	}
	console.log(">>>> 12345");
	for (var i=0; i < users.length; i++) {
		if(users[i].selected) {
			console.log(">selected>" + users[i].text);
			option = document.createElement( 'option' );
			option.value = users[i].value;
			option.text = users[i].text;
			usersAuth.add(option);
			users.remove(i);
		} else {
			console.log(">not selected>" + users[i].text);
		}
	}
//  option.text = users[users.selectedIndex].text;
//  usersAuth.add(option);
}

function backItem() {

	for (var i=0; i < usersAuth.length; i++) {
		if(usersAuth[i].selected) {
			console.log(">selected>" + usersAuth[i].text);
			option = document.createElement( 'option' );
			option.value = usersAuth[i].value;
			option.text = usersAuth[i].text;
			users.add(option);
			usersAuth.remove(i);
		} else {
			console.log(">not selected>" + usersAuth[i].text);
		}
	}
	//  option.text = users[users.selectedIndex].text;
	//  usersAuth.add(option);
}

var authAndUsers = {};

<#if model??>
	<#if model.authUsersList?has_content>
		<#list model.authUsersList as authUser>
authAndUsers['${authUser.authority?if_exists}'] = [
			   <#if authUser.usersList?has_content>
			   	<#list authUser.usersList as user>'${user.userName?if_exists}'<#if user?has_next>,</#if></#list>
			   </#if>
			   ];
		</#list>
	</#if>
</#if>

function changeAuthList() {
	var authList = document.getElementById("authId");
	var usersList = document.getElementById("usersAuthId");
	var userSelected = authList.options[authList.selectedIndex].value;
	console.log("userSelected >>> " + userSelected);

	while (usersList.options.length) {
		usersList.remove(0);
	}

	var users = authAndUsers[userSelected];

	if (users) {
		var i;
		for (i = 0; i < users.length; i++) {
			var user = new Option(users[i], i);
			usersList.options.add(user);
		}
	}

} 
</script>

</@layout.myLayout>