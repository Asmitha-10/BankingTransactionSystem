public class BankAccount {
    String Name;
    int AccNo;
    int deposit;

    BankAccount(String Name, int AccNo, int deposit) {
        this.Name = Name;
        this.AccNo = AccNo;
        this.deposit = deposit;
    }

    String getName() {
        return Name;
    }

    int getAccNo() {
        return AccNo;
    }

    int getdeposit() {
        return deposit;
    }

}