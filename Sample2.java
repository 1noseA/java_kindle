import java.util.HashMap;
import java.util.Map;

public class Sample2 {
  public static void main(String[] args) {
    // Statisticsをインスタンス化
    Statistics2 s = new Statistics2();
    // 年月を渡して、利益を取得する
    long profit = s.getProfit("2020/09");
    // 利益を出力する
    System.out.println(profit);
  }
}

class Statistics2 {
  // 指定された年月の利益を戻す
  long getProfit(String month) {
    // 年月を指定して売上金額を取得する
    long sales = getSales(month);
    // 年月を指定して売上原価を取得する
    long costs = getCosts(month);
    // 利益を計算して戻す
    return (sales - costs);
  }

  // 指定された年月の売上金額を戻す
  private long getSales(String month) {
    // SalesDaoクラスをインスタンス化
    SalesDao2 dao = new SalesDao2();
    // 年月を指定してItemを取得する
    Item item = dao.select(month);
    // Itemインスタンスのpriceフィールドの値を戻す
    return item.price;
  }

  // 指定された年月の売上原価を戻す
  private long getCosts(String month) {
    // CostsDaoクラスをインスタンス化
    CostsDao2 dao = new CostsDao2();
    // 年月を指定してItemを取得する
    Item item = dao.select(month);
    // Itemインスタンスのpriceフィールドの値を戻す
    return item.price;
}

//売上金額を管理するクラス
class SalesDao2 {
  // 仮データ
  private Map<String, Integer> data;
  // コンストラクタ
  // SalesDao2() {
  //   data = new HashMap<String, Long>();
  //   data.put("2020/01", 1000);
  //   data.put("2020/02", 1200);
  //   data.put("2020/03", 1300);
  //   data.put("2020/04", 1400);
  //   data.put("2020/05", 500);
  //   data.put("2020/06", 600);
  //   data.put("2020/07", 700);
  //   data.put("2020/08", 800);
  //   data.put("2020/09", 900);
  //   data.put("2020/10", 1000);
  //   data.put("2020/11", 1100);
  //   data.put("2020/12", 1200);
  // }
  // Itemインスタンスを戻す
  Item select(String month) {
    return data.get(month);
  }
}

// 売上原価を管理するクラス
class CostsDao2 {
  // 仮データ
  private Map<String, Integer> data = StubCommon.getData(50);
  // Itemインスタンスを戻す
  Item select(String month) {
    return data.get(month);
  }
}

// Itemインスタンス
class Item {
  long price;
  Item(long price) {
    this.price = price;
  }
}

// 共通処理
class StubCommon {
  // データを作成する共通メソッド
  static Map<String, Item> getData(int seed) {
    // 仮データの作成
    Map<String, Item> data = new HashMap<String, Item>();
    for (int i = 1; i <= 12; i++) {
      data.put("2020/" + String.format("%02b", i), new Item(i * seed)); 
    }
    return data;
  }
}