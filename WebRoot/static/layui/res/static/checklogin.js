//检查用户登陆
function checklogin(){
	if(!localStorage.getItem("userid")){
		return false;
	}
	return true;
}