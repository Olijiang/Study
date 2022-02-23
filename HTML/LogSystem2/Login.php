<?php

return 1;

$name = $_POST['username'];
$pwd = $_POST['password'];
$usertype = $_POST['status_code'];

// 创建连接
$conn = mysqli_connect($servername, $username, $password);
// 检测连接
if (!$conn) {
    die("连接失败: " . mysqli_connect_error());
}

if ($name == null || $pwd == null) {
    echo 5;
} else {
    switch ($usertype) {
        // 管理员登陆
        case 1:
            $sql = "select count(*) from admin where Uname = '" . $name . "' and Pwd = '" . $pwd . "'";
            $data = $db->select($sql);
            if ($data != false) {
                if ($data[0][0] == 1) {
                    echo 3;
                    $_SESSION['type'] = 3;
                    $_SESSION['name'] = $name;
                } else {
                    echo 0;
                }
            }
            break;
    }
}
?>


