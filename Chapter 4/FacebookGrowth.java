public class FacebookGrowth {
    public static void main(String[] args) {
        double initialUsers = 1.0; 
        double currentUsers = initialUsers;
        double growthRate = 0.04;
        
        int monthsTo15Billion = 0;
        int monthsTo2Billion = 0;
        int currentMonth = 0;

        while (currentUsers < 2.0) {
            currentMonth++;
            currentUsers *= (1.0 + growthRate);

            if (currentUsers >= 1.5 && monthsTo15Billion == 0) {
                monthsTo15Billion = currentMonth;
            }
            if (currentUsers >= 2.0 && monthsTo2Billion == 0) {
                monthsTo2Billion = currentMonth;
            }
        }

        System.out.printf("Months to hit 1.5 Billion users: %d months%n", monthsTo15Billion);
        System.out.printf("Months to hit 2.0 Billion users: %d months%n", monthsTo2Billion);
    }
}