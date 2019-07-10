import com.xiaoming.test.testclass;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ServiceLoader;

public class testclasss {
    @Test
    public void test() {
        ServiceLoader<testclass> loader = ServiceLoader.load(testclass.class);
        for (testclass s : loader) {
            System.out.println();
            s.printss();
        }

    }

    @Test
    public void testss() {
        final int NMAX = 10;
        int[][] odds = new int[NMAX][];
        for (int i = 0; i < NMAX; i++) {
            odds[i] = new int[i + 1];
        }
        for (int i = 0; i < odds.length; i++) {
            for (int j = 0; j < odds[i].length; j++) {
                int lotteryOdds = 1;
                for (int k = 1; k <= j; k++)
                    lotteryOdds = lotteryOdds * (i - k + 1) / k;
                odds[i][j] = lotteryOdds;
            }
        }

        for (int[] row : odds) {
            for (int odd : row)
                System.out.printf("%4d", odd);
            System.out.println();
        }
    }

    @Test
    public void testcalander() {
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        date = date.minusDays(today - 1);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int value = dayOfWeek.getValue();
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 0; i < value; i++) {
            System.out.printf("    ");
        }
        while (date.getMonthValue() == month) {
            System.out.printf("%3d", date.getDayOfMonth());
            if (date.getDayOfMonth() == today) {
                System.out.printf("*");
            } else {
                System.out.printf(" ");
            }
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1) {
                System.out.println();
            }
        }
    }

    @Test
    public void testxiaoming() {
        int x1, x2;//两分钱个数
        int y1, y2;//五分钱个数
        for (x1 = 1; x1 * 2 <= 600; x1++) {
            for (x2 = 1; x2 * 2 < 600; x2++) {
                for (y1 = 1; y1 * 5 < 600; y1++) {
                    for (y2 = 1; y2 * 5 < 600; y2++) {
                        if (x1 == y1 && x2 * 2 == y2 * 5 && ((x1 + x2) * 2 + (y1 + y2) * 5) >= 500 && ((x1 + x2) * 2 + (y1 + y2) * 5) <= 600) {
//                            int xx = (x1 + x2) * 2 + (y1 + y2) * 5;
//                            if(xx>=500&&xx<=600) {
                            System.out.println("两分钱个数：" + x1 + "+" + x2 + "五分钱个数" + y1 + "+" + y2 + "总钱数:" + ((x1 + x2) * 2 + (y1 + y2) * 5));
//                            }
                        }
                    }
                }
            }
        }
    }

}
