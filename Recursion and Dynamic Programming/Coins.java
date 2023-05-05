class NumberOfCoins {

    int numberOfCoins(int [] coinTypes, int amount) {
        
        if (amount == 0) {
            return 1;
        }

        if (amount < 0) {
            return 0;
        }
        else {
            return this.numberOfCoins(coinTypes, amount - coinTypes[0]) + this.numberOfCoins(coinTypes, amount - coinTypes[1]) + 
            this.numberOfCoins(coinTypes, amount - coinTypes[2]) + this.numberOfCoins(coinTypes, amount - coinTypes[3]); 
        }
    }

}

public class Coins {
    public static void main(String[] args) {
        int [] coinTypes = {25, 10, 5, 1};
        NumberOfCoins obj = new NumberOfCoins();
        int res = obj.numberOfCoins(coinTypes, 50);
        System.out.println(res);
    }
}
