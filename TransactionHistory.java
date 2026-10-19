public class TransactionHistory {
    int Ano;
    int intial;
    int deposit;
    int withdrawl;

    TransactionHistory(int Ano, int intial, int deposit, int withdrawl) {
        this.Ano = Ano;
        this.intial = intial;
        this.deposit = deposit;
        this.withdrawl = withdrawl;
    }

    int getAno() {
        return Ano;
    }

    int getintial() {
        return intial;
    }

    int getdeposit() {
        return deposit;
    }

    int getwithdrawl() {
        return withdrawl;
    }

    void setAno() {
        this.Ano = Ano;
    }

    void setintial() {
        this.intial = intial;
    }

    void setdeposit() {
        this.deposit = deposit;
    }

    void setwithdrawl() {
        this.withdrawl = withdrawl;
    }

}
