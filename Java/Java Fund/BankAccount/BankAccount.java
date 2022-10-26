import java.util.Random;
public class BankAccount {
    private double checkingBalance;
    private double savingsgBalance;
    private static  int numbeOfAccounts = 0;
    private static  double totalMoney = 0.0;
    private String accountNumber = "";

    public BankAccount(double checkingBalance,double savingsgBalance){
        this.savingsgBalance=savingsgBalance;
        this.checkingBalance=checkingBalance;
        numbeOfAccounts++;
        accountNumber=accountNumber();
        System.out.println("This Account number is "+numbeOfAccounts);
        System.out.println("Your Account number is "+accountNumber);

    }

     public double getCheckingBalance(){
        return checkingBalance;
    }
    public double getSavingsgBalance(){
        return savingsgBalance;
    }
    public void depositMoney(String type,double depositMone){
        if(type == "cheacking"){
            double JJ=getCheckingBalance()+depositMone;
            totalMoney+=depositMone;
            System.out.println("The Total Money is : "+ totalMoney);

        }
        if (type == "saving"){
            double ja=getSavingsgBalance()+depositMone;
            totalMoney+=depositMone;
            System.out.println("The Total Money is : "+ totalMoney);
        }
    }
        public void withDrawMoney(String type,double depositMone){
        if(type == "cheacking"){
            if (totalMoney > depositMone ) {
            double jj=getCheckingBalance()-depositMone;
            totalMoney-=depositMone;
            System.out.println("The Total Money is : "+ totalMoney);
            }
            else {
                System.out.println("Your Money is not enough: "+ totalMoney);

            }
        }
        if (type == "saving"){
            if (totalMoney > depositMone ) {
            double ja=getSavingsgBalance()+depositMone;
            totalMoney-=depositMone;
            System.out.println("The Total Money is : "+ totalMoney);
            }
            else {
                System.out.println("Your Money is not enough: "+ totalMoney);

            }
        }
    }
    public void checkBalance() {
        System.out.println("*********** Your Total Balnce is ***********");
		System.out.println("The Total Money is : "+ totalMoney);
	}
    private String accountNumber() {
		String numbers = "0123456789";
		String randomNumber = "";
		Random rand = new Random();
		for(int i = 0; i < 10; i++) {
			char number = numbers.charAt(rand.nextInt(10));
			randomNumber += number;
		}
		accountNumber = randomNumber;
		return randomNumber;	
	}

}