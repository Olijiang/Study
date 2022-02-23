//验证用户名和密码
var ename = '666';
var epwd = '123';

function isDigit(s) 
{   //校验是否全由数字组成
    var patrn=/^[0-9]{1,16}$/; 
    if (!patrn.exec(s)) return false ;
    return true;
}

function Login(){
    var name = document.getElementById('username').value;
    var pwd = document.getElementById('pwd').value;
    var status = document.getElementById('status').value;
    /* alert(name); */
    if(name=='') return; //无输入时
    if(name==ename && pwd==epwd) {
        if(status==1) alert("管理员");
        else alert("用户");
        window.location.href = "https://www.cnblogs.com/ZGByoyo/";
    }
    else alert("账号或密码错误");
}

function Register(){
    window.location.href = "./Register.html";
}

function CheckEnter(){
    if (event.keyCode == 13) Login();
}

document.getElementById("signin").onclick = Login;
document.getElementById("signup").onclick = Register;
document.getElementById("username").onkeyup = CheckEnter;
document.getElementById("pwd").onkeyup = CheckEnter;
