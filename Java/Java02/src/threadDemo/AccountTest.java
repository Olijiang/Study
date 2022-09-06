package threadDemo;

/*
*   两个用户向一个账户存钱3000，一次存1000，存 3 次
*   每次存完打余额
* */


public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(0);
        User xm = new User("xiaoming", account);
        User lh = new User("lihhuang", account);

        xm.start();
        lh.start();

    }
}
