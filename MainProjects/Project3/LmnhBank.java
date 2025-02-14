public class LmnhBank {

    private LmnhCA acc1;
    private LmnhCA acc2;

    public LmnhBank() {

    LmnhCA acc1 = new LmnhCA(5000, "Zeus");
    LmnhCA acc2 = new LmnhCA(5000, "Hercules");
    }

    public int acc1GetBalance() {
        acc1.getBalance();

    }

    public void acc1updateBalance(int newBalance) {
        acc1.updateBalance(newBalance);
    }

    public double acc1intrestRate() {
        return acc1.showIntrest();
    }

    public int acc2GetB

}
