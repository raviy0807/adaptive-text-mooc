
function LoginForm(){
    window.localStorage.clear();
	var user = $('#username').val();
	localStorage.setItem("username",user);
	window.location = "/html/main.html";
  }
