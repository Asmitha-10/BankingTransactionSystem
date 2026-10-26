import java.util.InputMismatchException;

public class input {
    BankingTransactionManagementSystem bankingTransactionManagementSystem = new BankingTransactionManagementSystem();
    Main o = new Main();

    void menu() {
        System.out.printf("------------------------------------------------------------------\n");
        System.out.println(
                "1.Create Account\n2.Deposit Money\n3.Withdraw Money\n4.Check Balance\n5.View Account Details\n6.View Transaction History\n7.Exit");
        System.out.printf("------------------------------------------------------------------\n");

    }

    void case1() {
        System.out.print("Enter Account Holder Name : ");
        String Name = o.sc.nextLine();
        while (Name.trim().isEmpty()) {
            System.out.print("Please Enter a Valid Name...");
            Name = o.sc.nextLine();
        }
        int AccNo = 0;
        while (true) {
            try {
                System.out.print("Enter Account Number      : ");
                AccNo = o.sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid Account Number");
                o.sc.nextLine();
            }
        }
        while (bankingTransactionManagementSystem.hm.containsKey(AccNo)) {
            System.out.print(
                    "Account Number Already Exists !!!!\nPlease Enter Another Account Number ....\n");
            AccNo = o.sc.nextInt();
        }
        int deposit;
        while (true) {
            try {
                System.out.print("Enter intial deposit      : ");
                deposit = o.sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please Enter a Valid deposit amount");
                o.sc.nextLine();
            }
        }
        while (deposit < 0) {
            System.out.println("Please Enter Deposit Amount Zer(0) or Greater .....");
            deposit = o.sc.nextInt();
            System.out.print("Enter intial deposit      : ");
        }
        o.sc.nextLine();
        BankAccount ba = new BankAccount(Name, AccNo, deposit);
        bankingTransactionManagementSystem.AddAccount(AccNo, ba);
        System.out.print("Account Created Sussessfully.....\n");
        TransactionHistory t = new TransactionHistory(AccNo, deposit, deposit, 0);
        bankingTransactionManagementSystem.addTransaction(t);
    }

    void case2() {
        int AcNo;
        while (true) {
            try {
                System.out.print("Enter Account Number     : ");
                AcNo = o.sc.nextInt();
                o.sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input !!!!!\nEnter an Integer ");
                o.sc.nextLine();
            }
        }
        while (!bankingTransactionManagementSystem.hm.containsKey(AcNo)) {
            System.out.println("Account Doesn't Exist !!!!\nPlease Enter a Valid Account Number ...");
            System.out.print("Enter Account Number     : ");
            AcNo = o.sc.nextInt();
        }
        int Deposit;
        while (true) {
            try {
                System.out.print("Enter deposit amount      : ");
                Deposit = o.sc.nextInt();
                o.sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please Enter a Valid deposit amount");
                o.sc.nextLine();
            }
        }
        while (Deposit < 0) {
            System.out.println("Please Enter Deposit Amount greater than Zero....");
            System.out.print("Enter Deposit Amount     : ");
            Deposit = o.sc.nextInt();
        }
        bankingTransactionManagementSystem.hm.get(AcNo).deposit += Deposit;
        System.out.print("Deposit Successful ....\n");
        bankingTransactionManagementSystem.ViewAccount(AcNo);
        bankingTransactionManagementSystem.adddeposit(AcNo, Deposit);
    }

    void case3() {
        int ANo = 0;
        while (true) {
            try {
                System.out.print("Enter Account Number     : ");
                ANo = o.sc.nextInt();
                o.sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input !!!!!\nEnter an Integer ");
                o.sc.nextLine();
            }
        }

        while (!bankingTransactionManagementSystem.hm.containsKey(ANo)) {
            System.out.println("Account Doesn't Exist !!!!\nPlease Enter a Valid Account Number ...");
            System.out.print("Enter Account Number     : ");
            ANo = o.sc.nextInt();
        }
        int Withdrawl;
        while (true) {
            try {
                System.out.print("Enter Withdrawal Amount  : ");
                Withdrawl = o.sc.nextInt();
                o.sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please Enter a Valid Withdrawl amount");
                o.sc.nextLine();
            }
        }

        while (Withdrawl < 0) {
            System.out.println("Please Enter Amount greater than zero for withdrawl...");
            System.out.print("Enter Withdrawal Amount  : ");
            Withdrawl = o.sc.nextInt();
        }
        while (Withdrawl > bankingTransactionManagementSystem.hm.get(ANo).deposit) {
            System.out.println("Insufficient Balance ....\nAvailable Balance  : "
                    + bankingTransactionManagementSystem.hm.get(ANo).deposit
                    + "\nPlease Enter an Amount Within Your Available Balance");
            System.out.print("Enter Withdrawal Amount  : ");
            Withdrawl = o.sc.nextInt();
        }
        bankingTransactionManagementSystem.hm.get(ANo).deposit -= Withdrawl;
        System.out.println("Withdrawl Successful ......");
        bankingTransactionManagementSystem.ViewAccount(ANo);
        bankingTransactionManagementSystem.addwithdraw(ANo, Withdrawl);
    }

    void case4() {
        int aNo = 0;
        while (true) {
            try {
                System.out.print("Enter Account Number     : ");
                aNo = o.sc.nextInt();
                o.sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input !!!!!\nEnter an Integer ");
                o.sc.nextLine();
            }
        }
        while (!bankingTransactionManagementSystem.hm.containsKey(aNo)) {
            System.out.print("Error : Account not found !!!!\nPlease enter a valid Account Number");
            aNo = o.sc.nextInt();
        }
        System.out.println("Account Number         : " + aNo);
        System.out.println("Current Balance        : $"
                + bankingTransactionManagementSystem.hm.get(aNo).deposit);
    }

    void case5() {
        int ANO = 0;
        while (true) {
            try {
                System.out.print("Enter Account Number     : ");
                ANO = o.sc.nextInt();
                o.sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input !!!!!\nEnter an Integer ");
                o.sc.nextLine();
            }
        }
        while (!bankingTransactionManagementSystem.hm.containsKey(ANO)) {
            System.out.println("Error : Account not found !!!!\nPlease enter a valid Account Number");
            ANO = o.sc.nextInt();
        }
        System.out.println("------------------ACCOUNT DETAILS--------------");
        bankingTransactionManagementSystem.ViewAccount(ANO);
    }

    void case6() {
        int ano;
        while (true) {
            try {
                System.out.print("Enter Account Number     : ");
                ano = o.sc.nextInt();
                o.sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input !!!!!\nEnter an Integer ");
                o.sc.nextLine();
            }
        }
        while (!bankingTransactionManagementSystem.hm.containsKey(ano)) {
            System.out.print("Error : Account not found !!!!\nPlease enter a valid Account Number");
            ano = o.sc.nextInt();
        }
        System.out.println("------------------TRANSACTION HISTORY---------------");
        bankingTransactionManagementSystem.viewTransaction(ano);
    }

    void case7() {
        System.out.println("------------Thankyou for using Simple Bank---------");
        System.out.println("Application Closed Successfully. ");
    }
}
