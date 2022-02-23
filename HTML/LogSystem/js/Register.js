//验证用户名和密码


function RegBack(){
    window.location.href = "./Login.html";
}

function CheckEnter(){
    if (event.keyCode == 13) Regsubmit();
}

function Regsubmit(){
    document.getElementById("RegBox").style.display = "none";
    document.getElementById("RegBox_ok").style.display = "block";

}


document.getElementById("regbt").onclick = Regsubmit;
document.getElementById("regback").onclick = RegBack;
