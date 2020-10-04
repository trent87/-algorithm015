import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if(amount < 1){
            return 0;
        }
        return coinChange(coins,amount,new int[amount]);
    }

    private int coinChange(int[] coins,int residue,int[] memo){
        if (residue < 0){
            return -1;
        }
        if(residue == 0){
            return 0;
        }
        if(memo[residue - 1] != 0){
            return memo[residue - 1];
        }
        int min = Integer.MAX_VALUE;
        for(int coin : coins){
            int rem = coinChange(coins,residue - coin,memo);
            if(rem >= 0 && rem < min){
                min = rem + 1;
            }
        }
        memo[residue - 1] = (min == Integer.MAX_VALUE )? -1 : min;
        return memo[residue - 1];
    }

}
