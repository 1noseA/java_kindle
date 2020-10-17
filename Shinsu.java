public class Shinsu {
  public static void main(String[] args) {
    // n進数表記でint値を生成する
    int val10 = 127; // 10進数「127」
    int val2 = Integer.parseInt("01111111", 2); // 2進数「01111111」
    int val8 = 0177; // 8進数「177」
    int val16 = 0x7f; // 16進数「7f」

    System.out.println(val10);
    System.out.println(val2);
    System.out.println(val8);
    System.out.println(val16);

    // 10進数をn進数表記にする
    int i = 127;

    // int値をn進数表記にする
    System.out.println("10進数：" + i);
    System.out.println("2進数：" + Integer.toBinaryString(i)); // 2進数表記に変換
    System.out.println("8進数：" + Integer.toOctalString(i)); // 8進数表記に変換
    System.out.println("16進数：" + Integer.toHexString(i)); // 16進数表記に変換
  }
}