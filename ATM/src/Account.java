public class Account {
	static double balance=0.0;
	Withdraw with ;
	Deposit dep;
	History his=new History ();
	Menu menu;
	public Account (double initialBalance) {
		if (initialBalance >0)
			balance = initialBalance;
	}
	public void balanceInquiry () { 
		
		History.getHistory().add("Your Balance:"+balance);	
		Menu.getI();
	}
	public void Deposit (double amount) {
		
		balance += amount;
		History.getHistory().add("Deposit:"+amount);
	    Menu.getI();
	}
	public void withdraw (double amount) {
		
		balance -= amount;
		History.getHistory().add("Withdraw: "+amount);
		Menu.getI();
	}
	public double getBalance() {
		return balance;
	}
}

