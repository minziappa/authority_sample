<#import "../layout/authLayout.ftl" as layout>
<@layout.myLayout>

<script>
function moveItem() {
  var users = document.getElementById("users");
  var auth = document.getElementById("auth");
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
	  var auth = document.getElementById("auth");

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
      <select id="auth" size="10" multiple='multiple' class="form-control">
        <option>kim6</option>
        <option>kim7</option>
      </select>
	</div>
</div>

</@layout.myLayout>