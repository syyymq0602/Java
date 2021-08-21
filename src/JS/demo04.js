

window.onload = function () {
    document.getElementById("form").onsubmit = function () {

        return checkUsername() && checkPassword();
    }

    document.getElementById("user").onblur = checkUsername;
    document.getElementById("password").onblur = checkPassword;

}
// 用户名校验
function checkUsername() {
    let username = document.getElementById("user").value;

    let reg_username = /^\w{6,12}$/;

    let flag = reg_username.test(username);

    let s_username = document.getElementById("span_username");

    if(flag){
        s_username.innerHTML = "<img width='25' height='25'  src='../../images/gou.png'/>";
    }else {
        s_username.innerHTML = "用户名格式有误";
    }
    return flag
}
// 密码校验至少有一位数字
function checkPassword() {
    let password = document.getElementById("password").value;

    let reg_password = /^\w{6,12}\d+$/;

    let flag = reg_password.test(password);

    let s_password = document.getElementById("span_password");

    if(flag){
        s_password.innerHTML = "<img width='25' height='25' src='../../images/gou.png'/>";
    }else {
        s_password.innerHTML = "密码格式有误";
    }
    return flag
}