abstract class Account {
    protected double balance;
    public void deposit(double amt) { 
        balance += amt; 
    }
    public abstract void monthlyFee();
}

class SavingsAccount extends Account {
    public void monthlyFee() { balance -= 5.0; }
}

class CurrentAccount extends Account {
    public void monthlyFee() { balance -= 12.0; }
}
