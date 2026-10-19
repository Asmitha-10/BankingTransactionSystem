import java.util.*;

public class BankingTransactionManagementSystem {
    HashMap<Integer, BankAccount> hm = new HashMap<>();
    ArrayList<TransactionHistory> arrayList = new ArrayList<>();

    void AddAccount(int AccNo, BankAccount o) {
        hm.put(AccNo, o);
    }

    void ViewAccount(int AccNo) {
        if (hm.containsKey(AccNo)) {
            System.out.println("Account Number         :  " + hm.get(AccNo).AccNo);
            System.out.println("Account Holder         :  " + hm.get(AccNo).Name);
            System.out.println("Current Balance        :  $" + hm.get(AccNo).deposit);
        }

    }

    void addTransaction(TransactionHistory t) {
        arrayList.add(t);
    }

    void adddeposit(int AcNo, int deposit) {
        for (TransactionHistory i : arrayList) {
            if (i.Ano == AcNo) {
                i.deposit += deposit;
            }
        }
    }

    void addwithdraw(int AcNo, int withdraw) {
        for (TransactionHistory i : arrayList) {
            if (i.Ano == AcNo) {
                i.withdrawl += withdraw;
            }
        }
    }

    void viewTransaction(int Acno) {
        for (TransactionHistory i : arrayList) {
            if (i.Ano == Acno) {
                System.out.println("Account Number       :    " + Acno);
                System.out.println("Intial Deposit       :    " + i.intial);
                System.out.println("Total Deposit        :    " + i.deposit);
                System.out.println("Total Withdrawl      :    " + i.withdrawl);
                System.out.println("Current Balance      :    " + hm.get(Acno).deposit);
            }
        }
    }

}
