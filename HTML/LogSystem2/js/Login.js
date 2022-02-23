//验证用户名和密码长度

function Check(){
    /* /^\w+$/.test(str); */    // \w 只由数字 字母 下划线组成时 返回 true; 否则返回false; 
    var name = document.getElementById('username').value;
    var pwd = document.getElementById('pwd').value;
    if(name.length<5 || name.length>10){
        alert("用户名长度在5~10");   //用户名长度在5~10
        return false;
    }
    if(!/^\w+$/.test(name)) 
    {
        alert("用户名只能由数字 字母 下划线组成");     //用户名只能由数字 字母 下划线组成
        return false;
    }
    if(pwd.length<5 || pwd.length>10){
        alert("密码长度在5~10");   //密码长度在5~10
        return false;
    }
    if(!/^\w+$/.test(pwd)){
        alert("密码只能由数字 字母 下划线组成");     //密码只能由数字 字母 下划线组成
        return false;
    }
    return true;
}

