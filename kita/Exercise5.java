package kita;

import java.io.*;

public class Exercise5 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    CoinCase cc = new CoinCase();
    // cc.AddCoins(500, 10);
    for (int i = 0; i < 10; i++) {
      System.out.println("硬貨の種類は？");
      int kind = Integer.parseInt(br.readLine());
      System.out.println("硬貨の枚数は？");
      int count = Integer.parseInt(br.readLine());
      cc.AddCoins(kind, count);
    }
    System.out.println("500円玉は" + cc.GetCount(500) + "枚");
    System.out.println("100円玉は" + cc.GetCount(100) + "枚");
    System.out.println("50円玉は" + cc.GetCount(50) + "枚");
    System.out.println("10円玉は" + cc.GetCount(10) + "枚");
    System.out.println("5円玉は" + cc.GetCount(5) + "枚");
    System.out.println("1円玉は" + cc.GetCount(1) + "枚");
    System.out.println("総額は" + cc.GetAmount() + "円");
  }
}