public class LmnhBank {

    private LmnhCA acc1;
    private LmnhCA acc2;

    public LmnhBank() {

        acc2 = new LmnhCA(5000, "Zeus");
        acc1 = new LmnhCA(2000, "Hercules");
    }

    public int acc1GetBalance() {
        return acc1.getBalance();
    }

    public void acc1UpdateBalance(int amount) {
        acc1.updateBalance(amount);

    }

    public double acc1InterestRate() {
        return acc1.getInterest();
    }

    public int acc2GetBalance() {
        return acc2.getBalance();
    }

    public void acc2UpdateBalance(int amount) {
        acc2.updateBalance(amount);
    }

    public double acc2InterestRate() {
      return acc2.getInterest();
    }


}

