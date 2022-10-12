package threadDemo;

import java.util.concurrent.locks.Lock;

public class User extends Thread{
    private final String name;
    private final Account account;

    public User(String name, Account account) {
        this.name = name;
        this.account = account;

    }

    @Override
    public void run() {
        while (this.account.deposit(name,100));
    }

}
