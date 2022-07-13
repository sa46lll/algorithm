import java.util.Arrays;

public class Coding {

    public static void main(String[] args) {
        int[] periods = {24, 59, 59, 60};
        int[][] payments = {{50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000},
                {50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000},
                {350000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000},
                {50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000}};
        int[] estimates = {350000, 50000, 40000, 50000};

        Coding coding = new Coding();

        int[] result = coding.solution(periods, payments, estimates);

        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    private int[] solution(int[] periods, int[][] payments, int[] estimates) {
        int[] result = {0, 0};

        for (int i = 0; i < periods.length; i++) {
            if (periods[i] < 23) {
                continue;
            }

            PeriodsGrade grade = PeriodsGrade.of(periods[i]);
            int pay = sum(payments[i]);
            boolean vip = grade.isVip(pay);

            PeriodsGrade nextGrade = PeriodsGrade.of(periods[i] + 1);
            int nextPay = pay - payments[i][0] + estimates[i];
            boolean nextVip = nextGrade.isVip(nextPay);

            if (!vip && nextVip) {
                result[0]++;
            }

            if (vip && !nextVip) {
                result[1]++;
            }
        }

        return result;
    }

    private int sum(int[] payments) {
        return Arrays.stream(payments)
                .parallel()
                .reduce(0, (ele1, ele2) -> ele1 + ele2);
    }

    enum PeriodsGrade {
        FIRST(0, 0),
        PRE_SECOND(1, 0),
        SECOND(2, 900000),
        PRE_THIRD(3, 900000),
        THIRD(4, 600000);

        private final int code;
        private final int payment;
        PeriodsGrade(int code, int payment) {
            this.code = code;
            this.payment = payment;
        }

        public boolean isVip(int payment) {
            if (this.payment != 0 && this.payment <= payment) {
                return true;
            }

            return  false;
        }

        public static PeriodsGrade of(int periods) {
            if (periods >= 60) {
                return THIRD;
            } else if (periods == 59) {
                return PRE_THIRD;
            } else if (periods >= 24) {
                return SECOND;
            } else if (periods == 23) {
                return PRE_SECOND;
            }

            return FIRST;
        }
    }
}