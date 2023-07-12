import java.util.Scanner;
class Account
{
	String name;
	String userName;
	String password;
	String accountNo;
	float balance = 100000f;
	int transactions = 0;
	String transHistory = "";
	public void register()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("\n Enter your name :");
		this.name = sc.nextLine();
		System.out.print("\n Enter your Username :");
		this.userName = sc.nextLine();
		System.out.print("\n Enter your password :");
		this.password  = sc.nextLine();
		System.out.print("\n Enter your Account no. :");
		this.accountNo = sc.nextLine();
		System.out.println("\n Registration completed....kindly login!");
	}
	public boolean login()
	{
		boolean isLogin = false;
		Scanner sc = new Scanner(System.in);
		while (!isLogin )
		{
			System.out.print("\n Enter your Username :");
			String Username = sc.nextLine();
			if (Username.equals(userName))
			{
				while(!isLogin )
				{
					System.out.print("\n Enter your password :");
					String Password = sc.nextLine();
					if (Password.equals(password))
					{
						System.out.print("\n Login successfull !");
						isLogin = true;
					}
					else
					{
						System.out.println("\n Incorrect password ! ");
					}
				}
			}
			else
			{
 				System.out.println("\n Username not  found ");
			}
		}
		return isLogin;
	}
	public void withDraw()
	{
		System.out.print("\n Enter the amount you want to withdraw : ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		if (balance >= amount)
		{
			transactions++;
			balance -= amount;
			System.out.println("\n Withdrawn Successfully ");
			String str = amount + "Rs Withdrawed \n";
			transHistory = transHistory.concat(str);
		}
		else
			System.out.println("\n Insufficient Balance ");
	}
	public void deposit()
	{
		System.out.print("\n Enter the amountyou want to deposit : ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();	
		if (amount <= 100000f)
		{
			transactions++;
			balance += amount;
			System.out.println("\nSuccessfully Deposited ");
			String str = amount + "Rs Deposited \n";
			transHistory = transHistory.concat(str);
		}
		else
			System.out.println("\n Sorry...limit is 100000.00 ");
	}
	public void transfer()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("\n Enter Reciepent's name : ");
		String reciepent = sc.nextLine();
		System.out.print("\n Enter Reciepent's account no : ");
		String rAcc = sc.nextLine();
		System.out.print("\n Enter the amount to transfer : ");
		float amount = sc.nextFloat();
		if (balance >= amount)
		{
			if (amount <= 50000f)
			{
				transactions++;
				balance -= amount;
				System.out.println("\nSuccessfully Transfered to " + reciepent);
				String str = amount + "Rs Transfered to " +  reciepent + "\n";
				transHistory = transHistory.concat(str);
			}
			else
			{
				System.out.println("\n Sorry...limit is 50000.00 ");
			}
		}
		else
		{
			System.out.println("\n Insufficient Balance ");
		}
	}
	public void transactionHistory()
	{
		if (transactions == 0)
		{
			System.out.println("\n Empty");
		}
		else
		{
			System.out.println("\n" + transHistory  );
		}
	}
	public void quit()
	{
		System.exit(0);
	}
}
public class Interface
{
	public static void main(String args[])
	{
		System.out.println("\n**************** WELCOME TO SBI ATM SYSTEM ****************\n");
		System.out.println("1.Register \n 2.Exit");
		System.out.print("Enter  your choice : ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		if (choice == 1)
		{
			Account ac = new Account();
			ac.register();
			while (true)
			{
				System.out.println("\n 1.Login \n 2.Exit");
				System.out.print("Enter  your choice : ");
				int ch = sc.nextInt();
				if (ch == 1)
				{
					if (ac.login())
					{
						System.out.println("\n************* WELCOME BACK " + ac.name + "************ \n");
						while (true)
						{
						
							System.out.println("\n 1. CASH DEPOSIT");
							System.out.println("2. CASH WITHDRAW");
							System.out.println("3. CASH TRANSFER");
							System.out.println("4. TRANSACTION HISTORY");
							System.out.println("5. QUIT");
							System.out.println("Please choose what you want to perform ");
							int c = sc.nextInt();
							switch(c)
							{
								case 1:
								ac.deposit();
								break;
								case 2:
								ac.withDraw();
								break;
								case 3:
								ac.transfer();
								break;
								case 4:
								ac.transactionHistory();
								break;
								case 5:
								ac.quit();
								default:
								System.out.println("You have choosen an incorrect option...");
							}
						}
					}
				}
				else
					System.exit(0);
			}
		}
		else
			System.exit(0);
	}
}
						








