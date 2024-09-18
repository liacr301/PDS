package lab09.Ex2;

public class Proxy implements BankAccount {
    private BankAccountImpl bankAccount;

    public Proxy(String bankAccount, double initialDeposit){
        this.bankAccount = new BankAccountImpl(bankAccount, initialDeposit);
    }

    @Override
    public void deposit(double amount){
        this.bankAccount.deposit(amount);
    }

    @Override
    public boolean withdraw(double amount){
        if (Company.user == User.OWNER){
            return true;
        }
        return false;
    } 

    @Override
    public double balance(){
        if (Company.user == User.OWNER){
            return this.bankAccount.balance();
        }
        return -1;
    }
}
