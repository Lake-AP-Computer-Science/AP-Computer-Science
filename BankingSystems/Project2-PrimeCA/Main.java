
public class Main {

	public static void main(String[] args) {
		
		PrimeCheckingAccount PCA = new PrimeCheckingAccount(0, "kent", "aie", "6723488293", "kentaie@corp.org", 10, "wut");
		
		System.out.println(PCA);
		
		for(int i = 0; i < 5; i++)
		{
			PCA.Deposit(20000);
		
			System.out.println(PCA);
		}
		
		PCA.Withdraw(1000000);
		
		System.out.println(PCA);
		
	}

}
