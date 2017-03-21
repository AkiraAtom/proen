
// VALIDATION ALERT

function validateForm() {
	    //メール
	    var email = document.forms["myForm"]["mailaddress"].value;
	    if (email == null || email == "") {
	       alert("＊ メールを入力して下さい");
	        return false;
	    }
	    //パスワード
	    var pass = document.forms["myForm"]["password"].value;
	    if (pass == null || pass == "") {
	       alert("＊ パスワードを入力して下さい");
	        return false;
	    }
	}