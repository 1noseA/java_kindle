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
    // 年月を指定して売上金額を取得する
    return dao.select(month);
  }

  // 指定された年月の売上原価を戻す
  private long getCosts(String month) {
    // CostsDaoクラスをインスタンス化
    CostsDao2 dao = new CostsDao2();
    // 年月を指定して売上原価を取得する
    return dao.select(month);
  }
}

//売上金額を管理するクラス
class SalesDao2 {
  // 仮データ
  private Map<String, Integer> data = StubCommon.getData(100);
  long select(String month) {
    return data.get(month);
  }
}

// 売上原価を管理するクラス
class CostsDao2 {
  // 仮データ
  private Map<String, Integer> data = StubCommon.getData(50);
  long select(String month) {
    return data.get(month);
}

// 共通処理
class StubCommon {
  // データを作成する共通メソッド
  static Map<String, Integer> getData(int seed) {
    // 仮データの作成
    Map<String, Integer> data = new HashMap<String, Integer>();
    for (int i = 1; i <= 12; i++) {
      data.put("2020/" + String.format("%02b", i), i * seed); 
    }
    return data;
  }
}