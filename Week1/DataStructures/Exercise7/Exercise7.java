package Week1.DataStructures.Exercise7;

public class Exercise7 {

    // Recursive method to calculate future value
    public static double forecast(double principal, double rate, int years) {
        if (years == 0) {
            return principal;
        }
        return forecast(principal, rate, years - 1) * (1 + rate);
    }

    // Optimized version using memoization
    public static double forecastMemo(double principal, double rate, int years, Double[] memo) {
        if (years == 0) return principal;
        if (memo[years] != null) return memo[years];
        memo[years] = forecastMemo(principal, rate, years - 1, memo) * (1 + rate);
        return memo[years];
    }

    public static void main(String[] args) {
        double principal = 10000;
        double growthRate = 0.05;
        int years = 5;

        System.out.println(" Recursive Forecast:");
        double result1 = forecast(principal, growthRate, years);
        System.out.printf("Future Value after %d years: Rs%.2f\n", years, result1);

        System.out.println("\n Forecast with Memoization:");
        Double[] memo = new Double[years + 1];
        double result2 = forecastMemo(principal, growthRate, years, memo);
        System.out.printf("Future Value after %d years: Rs%.2f\n", years, result2);
    }
}
