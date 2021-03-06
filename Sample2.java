import java.util.ArrayList;
import java.util.List;
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
    // 年月を指定して売り上げた商品を取得する
    List<Item> items = dao.select(month);
    // 全てのItemインスタンスのpriceの値を合算
    return sum(items);
  }

  // 指定された年月の売上原価を戻す
  private long getCosts(String month) {
    // CostsDaoクラスをインスタンス化
    CostsDao2 dao = new CostsDao2();
    // 年月を指定して売り上げた商品の原価を取得する
    List<Item> items = dao.select(month);
    // 全てのItemインスタンスのpriceの値を合算
    return sum(items);
  }

// Itemリストのpriceの値を全て合算するメソッド
  public long sum(List<Item> items) {
    // 戻り値
    long res = 0;
    // Itemインスタンスを全て取得する
    for (Item item : items) {
      // priceの値を加算
      res += item.price;
    }
    // 戻り値を戻す
    return res;
  }
}

//売上金額を管理するクラス
class SalesDao2 {
  // 仮データ
  private Map<String, List<Item>> data;
  // Itemインスタンスを戻す
  List<Item> select(String month) {
    return data.get(month);
  }
}

// 売上原価を管理するクラス
class CostsDao2 {
  // 仮データ
  private Map<String, List<Item>> data = StubCommon.getData(50);
  // Itemインスタンスを戻す
  List<Item> select(String month) {
    return data.get(month);
  }
}

// 商品を表現したクラス
class Item {
  long price;
  Item(long price) {
    this.price = price;
  }
}

// 共通処理
class StubCommon {
  // データを作成する共通メソッド
  static Map<String, List<Item>> getData(int seed) {
    // 仮データの作成
    Map<String, List<Item>> data = new HashMap<String, List<Item>>();
    for (int i = 1; i <= 12; i++) {
      List<Item> items = new ArrayList<Item>();
      for (int j = 1; j <= i; j++) {
        items.add(new Item(i * seed));
      }
      data.put("2020/" + String.format("%02b", i), items); 
    }
    return data;
  }
}