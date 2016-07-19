<#import "../layout/authLayout.ftl" as layout>
<@layout.myLayout>

<script src="/js/auth/auth.js"></script>
<link href="/css/auth/auth.css" rel="stylesheet">

<div>
<ul id="statuses"></ul>
</div>
<div id="enquete"></div>

<div class="row">
	<div class="col-md-5">
	  	<span>Input a user information.</span>
	</div>
	<div class="col-md-2">
	</div>
	<div class="col-md-5">
	  	<span>Select authority.</span> 
	</div>
  	<form name="myForm" action="/auth/updateAuth" method="POST">
	<div class="col-md-5">
	  <input name="aname" type="text" size="10" class="form-control" name="users" autocomplete="off" autocorrect="off" autocapitilize="off" spellcheck="false" data-toggle="popover" data-trigger="manual" data-placement="top" title="Popover title" data-content="Default popover" onclick="releasPopover(this);" onkeydown="interverKeystroke(event, 0);"/>
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
	</div>
	</form>
</div>

<script>

var users = document.getElementById("users");
var auths = document.getElementById("authId");
var usersAuth = document.getElementById("usersAuthId");

// Check if it is the default.
function checkIsDefault() {
	if(auths.selectedIndex == 0) {
		return false;
	}
	return true;
}

// Move an item to the right list.
function moveItem() {

	// Check default
	if(!checkIsDefault()) {
		alert("Could you choose a your?");
		return false;
	}

	var deleteCnt=[];
	for(var i=0; i < users.options.length; i++) {
		if(users.options[i].selected) {
			console.log(">>> selected>" + users.options[i].text);
			var option = document.createElement( 'option' );
			option.value = users.options[i].value;
			option.text = users.options[i].text;
			usersAuth.add(option);
			// Add key number into the array
			deleteCnt.push(i);
		}
	}

	// Delete items
	var j = 0;
	for(var m=0; m < deleteCnt.length; m++) {
		users.remove(deleteCnt[m]-j);
		j=j+1;
	}

}
	
function backItem() {

	var deleteCnt=[];
	for (var i=0; i < usersAuth.length; i++) {
		if(usersAuth[i].selected) {
			console.log(">selected>" + usersAuth[i].text);
			option = document.createElement( 'option' );
			option.value = usersAuth[i].value;
			option.text = usersAuth[i].text;
			users.add(option);
			// Add key number into the array
			deleteCnt.push(i);
		}
	}
	
	// Delete items
	var j = 0;
	for(var m=0; m < deleteCnt.length; m++) {
		usersAuth.remove(deleteCnt[m]-j);
		j=j+1;
	}

}




function releasPopover(event) {
	$jevent = $(event);
	$jevent.popover('destroy');
}



// User list with authority.
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