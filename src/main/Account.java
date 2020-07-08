public class Account {

    /**
     * Calculates the account balance after a period of time
     * taking into account the entered parameters.
     *
     * @param openingSum initial sum the bank account starts with
     * @param interestRate interest rate applied to the sum at the beginning of every month
     * @param taxFreeLimit the tax threshold
     * @param taxRate the tax rate for sums above the the tax threshold
     * @param numMonths the number of months
     * @return account balance after the specified number of months
     */
    public static double balance(double openingSum, double interestRate, double taxFreeLimit, double taxRate, int numMonths){
        if(openingSum < 0 || interestRate < 0 || taxFreeLimit < 0 || taxRate < 0 || numMonths < 0){
            throw new IllegalArgumentException("All parameters must be 0 or higher");
        }
        double beginningOfTheMonthSum = openingSum;
        for (int i = 0; i < numMonths; i++ ){
            openingSum += beginningOfTheMonthSum*interestRate/100;
            if(beginningOfTheMonthSum > taxFreeLimit)
                openingSum -= (beginningOfTheMonthSum - taxFreeLimit)*taxRate/100;
            beginningOfTheMonthSum = openingSum;
        }
        return openingSum;
    }
}
