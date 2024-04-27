import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long k = scanner.nextLong();
        double n = scanner.nextDouble();
        double m = scanner.nextDouble();
        Random random = new Random(k);

            for (int i = 0; i < n; i++) {
                if (random.nextGaussian() > m) {
                    random.setSeed(++k);
                    i = -1;
                }
            }System.out.println(k);

        }
    }
