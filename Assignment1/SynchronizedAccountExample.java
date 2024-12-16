package JAVAPROGRAMMING.Assignment1;

class Account {
    private int balance;

    public Account(int initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + ". Balance: " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ". Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " attempted to withdraw " + amount + ". Insufficient balance!");
        }
    }
}

class DepositRunnable implements Runnable {
    private Account account;

    public DepositRunnable(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            account.deposit(100);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class WithdrawRunnable implements Runnable {
    private Account account;

    public WithdrawRunnable(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            account.withdraw(50);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class SynchronizedAccountExample {
    public static void main(String[] args) {
        Account account = new Account(500);

        Thread depositThread = new Thread(new DepositRunnable(account), "Deposit Thread");
        Thread withdrawThread = new Thread(new WithdrawRunnable(account), "Withdraw Thread");

        depositThread.start();
        withdrawThread.start();
    }
}

