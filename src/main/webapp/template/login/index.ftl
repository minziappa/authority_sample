<#import "../layout/defaultLayout.ftl" as layout>
<@layout.myLayout>
      <form class="form-signin" role="form" action="/login/login" name="sform" id="sform" method="POST">
        <h2 class="form-signin-heading">Please sign ina</h2>
        <input  type="text" name="userName" class="form-control" placeholder="user name address" required autofocus>
        <input type="password" name="userPwd" class="form-control" placeholder="password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
</@layout.myLayout>