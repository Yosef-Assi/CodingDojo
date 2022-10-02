
class User:
    def __init__(self,name,email,balnce):
        self.name=name  
        self.email=email
        self.account_balnce=balnce
        
    def make_withdrawal(self, amount):
        self.account_balnce-=amount
        return self

    def make_deposits(self,amount1):
        self.account_balnce+=amount1
        return self

    def display_user_balance(self):
        print("name",self.name,"email",self.email,"AcountBalnce",self.account_balnce)
        return self

u1= User('ahmad','ahmad@example.com',150)
u2= User('sami','sami@example.com',250)
u3= User('zaki','zaki@example.com',100)



u1.make_deposits(10).make_deposits(20).make_deposits(44).make_withdrawal(100).display_user_balance()


u2.make_deposits(20).make_deposits(44).make_withdrawal(20).make_withdrawal(20).display_user_balance()





u3.make_deposits(100).make_withdrawal(20).make_withdrawal(20).make_withdrawal(40).display_user_balance()






