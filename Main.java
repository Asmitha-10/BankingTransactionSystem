import java.util.*;

public class Main {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        BankingTransactionManagementSystem bankingTransactionManagementSystem = new BankingTransactionManagementSystem();
        Main o = new Main();
        System.out.printf("%40s", "BANKING SYSTEM\n");
        while (true) {
            o.menu();
            int ch = o.sc.nextInt();
            o.sc.nextLine();
            switch (ch) {
                case 1:
                    System.out.print("Enter Account Holder Name : ");
                    String Name = o.sc.nextLine();
                    while (Name.trim().isEmpty()) {
                        System.out.print("Please Enter a Valid Name...");
                        Name = o.sc.nextLine();

                    }

                    System.out.print("Enter Account Number      : ");
                    int AccNo = o.sc.nextInt();
                    while (bankingTransactionManagementSystem.hm.containsKey(AccNo)) {
                        System.out.print(
                                "Account Number Already Exists !!!!\nPlease Enter Another Account Number ....\n");
                        AccNo = o.sc.nextInt();
                    }

                    System.out.print("Enter intial deposit      : ");
                    int deposit = o.sc.nextInt();
                    while (deposit < 0) {
                        System.out.println("Please Enter Deposit Amount Zer(0) or Greater .....");
                        deposit = o.sc.nextInt();
                    }
                    BankAccount ba = new BankAccount(Name, AccNo, deposit);
                    bankingTransactionManagementSystem.AddAccount(AccNo, ba);
                    System.out.print("Account Created Sussessfully.....\n");
                    TransactionHistory t = new TransactionHistory(AccNo, deposit, deposit, 0);
                    bankingTransactionManagementSystem.addTransaction(t);
                    break;
                case 2:
                    System.out.print("Enter Account Number     : ");
                    int AcNo = o.sc.nextInt();
                    while (!bankingTransactionManagementSystem.hm.containsKey(AcNo)) {
                        System.out.println("Account Doesn't Exist !!!!\nPlease Enter a Valid Account Number ...");
                        AcNo = o.sc.nextInt();
                    }
                    System.out.print("Enter Deposit Amount     : ");
                    int Deposit = o.sc.nextInt();
                    while (Deposit < 0) {
                        System.out.print("Please Enter Deposit Amount greater than Zero....");
                        Deposit = o.sc.nextInt();
                    }
                    bankingTransactionManagementSystem.hm.get(AcNo).deposit += Deposit;
                    System.out.print("Deposit Successful ....\n");
                    bankingTransactionManagementSystem.ViewAccount(AcNo);
                    bankingTransactionManagementSystem.adddeposit(AcNo, Deposit);
                    break;
                case 3:
                    System.out.print("Enter Account Number     : ");
                    int ANo = o.sc.nextInt();
                    while (!bankingTransactionManagementSystem.hm.containsKey(ANo)) {
                        System.out.println("Account Doesn't Exist !!!!\nPlease Enter a Valid Account Number ...");
                        ANo = o.sc.nextInt();
                    }
                    System.out.print("Enter Withdrawal Amount  : ");
                    int Withdrawl = o.sc.nextInt();
                    while (Withdrawl < 0) {
                        System.out.println("Please Enter Amount greater than zero for withdrawl...");
                        Withdrawl = o.sc.nextInt();
                    }
                    while (Withdrawl > bankingTransactionManagementSystem.hm.get(ANo).deposit) {
                        System.out.println("Insufficient Balance ....\nAvailable Balance  : "
                                + bankingTransactionManagementSystem.hm.get(ANo).deposit
                                + "\nPlease Enter an Amount Within Your Available Balance");
                        Withdrawl = o.sc.nextInt();
                    }
                    bankingTransactionManagementSystem.hm.get(ANo).deposit -= Withdrawl;
                    System.out.println("Withdrawl Successful ......");
                    bankingTransactionManagementSystem.ViewAccount(ANo);
                    bankingTransactionManagementSystem.addwithdraw(ANo, Withdrawl);
                    break;
                case 4:
                    System.out.print("Enter Account Number   :  ");
                    int aNo = o.sc.nextInt();
                    while (!bankingTransactionManagementSystem.hm.containsKey(aNo)) {
                        System.out.print("Error : Account not found !!!!\nPlease enter a valid Account Number");
                        aNo = o.sc.nextInt();
                    }
                    System.out.println("Account Number         : " + aNo);
                    System.out.println("Current Balance        : $"
                            + bankingTransactionManagementSystem.hm.get(aNo).deposit);
                    break;
                case 5:
                    System.out.print("Enter Account Number    :  ");
                    int ANO = o.sc.nextInt();
                    while (!bankingTransactionManagementSystem.hm.containsKey(ANO)) {
                        System.out.println("Error : Account not found !!!!\nPlease enter a valid Account Number");
                        ANO = o.sc.nextInt();
                    }
                    System.out.println("------------------ACCOUNT DETAILS--------------");
                    bankingTransactionManagementSystem.ViewAccount(ANO);
                    break;
                case 6:
                    System.out.print("Enter Account Number   :  ");
                    int ano = o.sc.nextInt();
                    while (!bankingTransactionManagementSystem.hm.containsKey(ano)) {
                        System.out.print("Error : Account not found !!!!\nPlease enter a valid Account Number");
                        ano = o.sc.nextInt();
                    }
                    System.out.println("------------------TRANSACTION HISTORY--------------");
                    bankingTransactionManagementSystem.viewTransaction(ano);
                    break;

                case 7:
                    System.out.println("------------Thankyou for using Simple Bank---------");
                    System.out.println("Application Closed Successfully. ");
                    System.exit(0);
            }

        }

    }

    void menu() {
        System.out.printf("------------------------------------------------------------------\n");
        System.out.println(
                "1.Create Account\n2.Deposit Money\n3.Withdraw Money\n4.Check Balance\n5.View Account Details\n6.View Transaction History\n7.Exit");
        System.out.printf("------------------------------------------------------------------\n");
        System.out.print("Enter your choice :");

    }
}
