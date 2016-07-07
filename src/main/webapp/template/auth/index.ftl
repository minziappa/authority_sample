<#import "../layout/authLayout.ftl" as layout>
<@layout.myLayout>

<script>
function moveItem() {
  var users = document.getElementById("users");
  var auth = document.getElementById("usersAuthId");
  console.log(">>>>" + users.value);

  for (var i=0; i < users.length; i++) {
	  if(users[i].selected) {
		  console.log(">selected>" + users[i].text);
		  option = document.createElement( 'option' );
		  option.value = users[i].value;
		  option.text = users[i].text;
		  auth.add(option);
		  users.remove(i);
	  } else {
		  console.log(">not selected>" + users[i].text);
	  }
  }
//  option.text = users[users.selectedIndex].text;
//  auth.add(option);
}

function backItem() {
	  var users = document.getElementById("users");
	  var auth = document.getElementById("usersAuthId");

	  for (var i=0; i < auth.length; i++) {
		  if(auth[i].selected) {
			  console.log(">selected>" + auth[i].text);
			  option = document.createElement( 'option' );
			  option.value = auth[i].value;
			  option.text = auth[i].text;
			  users.add(option);
			  auth.remove(i);
		  } else {
			  console.log(">not selected>" + auth[i].text);
		  }
	  }
	//  option.text = users[users.selectedIndex].text;
	//  auth.add(option);
	}

</script>

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
        <option value="kim1">kim1</option>
        <option value="kim2">kim2</option>
        <option value="kim3">kim3</option>
        <option value="kim4">kim4</option>
        <option value="kim5">kim5</option>
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
				  <option value="${auth.authorityId?if_exists}">${auth.authority?if_exists}</option>
				</#list>
			</#if>
			</#if>
		  </select>
		<select id="usersId" name="usersAuth" size="10" multiple='multiple' class="form-control">
	        <option>kim6</option>
	        <option>kim7</option>
        </select>
      </form>
	</div>
</div>

<select id="car" onchange="ChangeCarList()"> 
<option value="">-- Car --</option> 
<option value="VO">Volvo</option> 
<option value="VW">Volkswagen</option> 
<option value="BMW">BMW</option> 
</select> 

<select id="carmodel"></select> 

<script>
var carsAndModels = {};
carsAndModels['VO'] = ['V70', 'XC60', 'XC90'];
carsAndModels['VW'] = ['Golf', 'Polo', 'Scirocco', 'Touareg'];
carsAndModels['BMW'] = ['M6', 'X5', 'Z3'];

function ChangeCarList() {
  var carList = document.getElementById("car");
  var modelList = document.getElementById("carmodel");
  var selCar = carList.options[carList.selectedIndex].value;
  
  console.log("selCar >>> " + selCar);
  
  
  while (modelList.options.length) {
      modelList.remove(0);
  }
  var cars = carsAndModels[selCar];
  if (cars) {
      var i;
      for (i = 0; i < cars.length; i++) {
          var car = new Option(cars[i], i);
          modelList.options.add(car);
      }
  }
}

var authAndUsers = {};

<#if model??>
	<#if model.authUsersList?has_content>
		<#list model.authUsersList as authUser>
authAndUsers['${authUser.authority?if_exists}'] = [
			   <#if authUser.usersList?has_content>
			   	<#list authUser.usersList as user>
			    		${user.userName?if_exists},
			    </#list>
			   </#if>
			   ];
		</#list>
	</#if>
</#if>

function changeAuthList() {
	  var authList = document.getElementById("authId");
	  var usersList = document.getElementById("usersId");
	  var userSelected = authList.options[authList.selectedIndex].value;

	  console.log("userSelected >>> " + userSelected);

	  while (usersList.options.length) {
		  usersList.remove(0);
	  }

	  var users = authAndUsers[userSelected];
	  if (users) {
	      var i;
	      for (i = 0; i < cars.length; i++) {
	          var user = new Option(users[i], i);
	          usersList.options.add(user);
	      }
	  }
} 
</script>

</@layout.myLayout>