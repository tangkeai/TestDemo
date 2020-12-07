
class Exchange {
    public int[] exchangeAB(int[] AB) {
        AB[1] += AB[0];
        AB[0] = AB[1] - AB[0];
        AB[1] = AB[1] - AB[0];
        return AB;
    }
}

public class TestExchange {
    public static void main(String[] args) {
        int[] AB= {1,2,3,4,5};
        Exchange exchange = new Exchange();
        AB = exchange.exchangeAB(AB);
        for (int i = 0; i < AB.length; i++) {
            System.out.print(AB[i]);
        }
    }
}
