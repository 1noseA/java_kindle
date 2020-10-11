import java.util.Scanner;

// 素数とは1より大きい自然数で、正の約数が1と自分自身のみであること。
public class PrimeNumber {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    if (isPrime(n) == true) {
      System.out.println(n + "は素数です。");
    } else {
      System.out.println(n + "は素数ではありません。");
    }
  }

  public static boolean isPrime(int num) {
    if (num < 2) {
      return false;
    } else if (num == 2) {
      return true;
      // 偶数はあらかじめ除く
    } else if (num % 2 == 0) {
      return false;
    }

    // sqrtは平方根を求めるメソッド
    double sqrtNum = Math.sqrt(num);
    for (int i = 3; i <= sqrtNum; i += 2) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }
}