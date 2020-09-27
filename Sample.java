public class Sample {
  public static void main(String[] args) {
    // Statisticsをインスタンス化
    Statistics s = new Statistics();
    // 年月を渡して、利益を取得する
    long profit = s.getProfit("2020/09");
    // 利益を出力する
    System.out.println(profit);
  }
}

class Statistics {
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
    SalesDao dao = new SalesDao();
    // 年月を指定して売上金額を取得する
    return dao.select(month);
  }

  // 指定された年月の売上原価を戻す
  private long getCosts(String month) {
    // CostsDaoクラスをインスタンス化
    CostsDao dao = new CostsDao();
    // 年月を指定して売上原価を取得する
    return dao.select(month);
  }
}

//売上金額を管理するクラス
class SalesDao {
  long select(String month) {
    return 100;
  }
}

// 売上原価を管理するクラス
class CostsDao {
  long select(String month) {
    return 50;
  }
}