import java.util.Scanner;

public class PerfectNumber {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int Q = sc.nextInt();
    for (int i = 1; i < Q; i++) {
      int N = sc.nextInt();
      int sum = 0;
      for (int j = 1; j < N; j++) {
        if (N % j == 0) {
          sum += j;
        }
      }
      if (sum == N) {
        System.out.println(N + "は完全数です。");
      } else {
        System.out.println(N + "は完全数ではありません。");
      }
    }
  }
}