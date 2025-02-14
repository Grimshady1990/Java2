public class LmnhMain {

    public static void main(String[] args) {
    
        LmnhBank bankOfGods = new LmnhBank();

        System.out.println(bankOfGods.acc1GetBalance());
        System.out.println(bankOfGods.acc2GetBalance());
        bankOfGods.acc1UpdateBalance(8888);
        bankOfGods.acc2UpdateBalance(9999);
        System.out.println(bankOfGods.acc1GetBalance());
        System.out.println(bankOfGods.acc2GetBalance());
        System.out.println(bankOfGods.acc1InterestRate());
        System.out.println(bankOfGods.acc2InterestRate());
    }
}
