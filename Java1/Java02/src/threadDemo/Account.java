package threadDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private int money;
    private final int MAX = 10000;
    Lock lock = new ReentrantLock();

    public Account(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public boolean deposit(String name, int money){
        //System.out.println(name+"等待锁; ");
        lock.lock();
        //System.out.print(name+"进锁; ");
        if (this.money<MAX) {
            this.money += money;
            System.out.println(name + "存入" + money + "元，余额" + this.money + "元; ");
            lock.unlock();
            //System.out.println(name + "解锁; ");
            return true;
        }
        //System.out.println(name + "解锁; ");
        lock.unlock();
        return false;
    }

    public void display(){
        System.out.println("余额为:"+money);
    }
}
