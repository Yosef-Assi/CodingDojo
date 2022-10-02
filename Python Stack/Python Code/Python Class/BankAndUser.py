
class BankAccount:
    def __init__(self, int_rate, balance):
        self.int_rate=int_rate
        self.balance=balance

    def deposit(self, amount):
        self.balance+=amount
        return self
    def withdraw(self,amount):
        if self.balance - amount > 0:
            self.balance -= amount
        else:
            print(f'Insufficient funds: Charging a $5 fee {self.balance}')
        return self
    def display_account_info(self):
        print("int_rate",self.int_rate,"balnce is",self.balance)
        return self
    
    def yield_interest(self):
        self.balance +=self.int_rate * self.balance
        return self
        
class User:
    def __init__(self,name,email):
        self.name=name  
        self.email=email
        self.account= BankAccount(int_rate=0.02,balance=1000)
        
    def make_withdrawal(self):
        self.account.balance
        return self

    def make_deposits(self):
        self.account.balance
        return self

    def display_user_balance(self):
      
        self.account.withdraw(50)
        print("YourBalnceAfterWithdraw",self.account.balance)
        self.account.deposit(200)
        self.account.yield_interest()
        print("YourBalanceAfterDeposit",self.account.balance)
        
        return self

u1= User('ahmad','ahmad@example.com')



u1.make_deposits().make_withdrawal().display_user_balance()
















        
	
