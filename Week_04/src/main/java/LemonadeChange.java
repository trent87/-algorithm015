public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0) {
            return false;
        }
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = new int[]{5, 5, 10, 10, 20};
        LemonadeChange lemonadeChange = new LemonadeChange();
        System.err.println(lemonadeChange.lemonadeChange(bills));
    }

}
