// 順列
public class Permutation {
  public static void main(String[] args) {
    permutation("abcd", "");
  }

  public static void permutation(String q, String ans) {
    if (q.length() <= 1) {
      System.out.println(ans + q);
    } else {
      for (int i = 0; i < q.length(); i++) {
        permutation(q.substring(0, i) + q.substring(i + 1), ans + q.charAt(i));
      }
    }
  }
}