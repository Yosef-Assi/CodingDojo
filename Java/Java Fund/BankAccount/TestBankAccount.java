public class TestBankAccount {
    public static void main (String[] args){
        System.out.println("*********** Your Acount Number is ***********");
        BankAccount bank = new BankAccount(255.2,600.8);
        System.out.println("*********** Your Acount Number is ***********");
        BankAccount bank1 = new BankAccount(2500,1000);
        System.out.println("*********** Your Balnce After Deposit ***********");
        bank.depositMoney("saving",965.2);
        System.out.println("*********** Your Balnce After Deposit ***********");
        bank1.depositMoney("saving",965.2);
        System.out.println("*********** Your Balnce After DrawMoney ***********");
        bank.withDrawMoney("saving",655);
        bank.checkBalance();
    }
}