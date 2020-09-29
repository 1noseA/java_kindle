import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Salon {
  public static void main(String[] args) {
    // サービスを管理するクラスをインスタンス化
    ServiceCommon s = new ServiceCommon();

    // 本日有効なサービスを取得する
    List<Service> services = s.getService();

    // 本日有効なサービスを表示する
    for (Service service : services) {
      System.out.println(service.summary());
    }
  }
}

// サービスを管理するクラス
class ServiceCommon {
  List<Service> getService() {
    // 本日日付を取得する
    String today = getToday();

    // 有効なサービスを取得する
    List<Service> res = getAvailable(today);

    // 有効なサービスを戻す
    return res;
  }

  // 有効なサービスを取得する
  List<Service> getAvailable(String date) {
    // ServiceDaoのインスタンス化
    ServiceDao dao = new ServiceDao();
    // 本日日付で有効なサービスを取得する
    List<Service> res = dao.select(date);
    return res;
  }

  // 本日日付を取得する
  String getToday() {
    return DateCommon.getToday();
  }
}

// 日付を管理するクラス
class DateCommon {
  static String getToday() {
    return new SimpleDateFormat("yyy/MM/dd").format(new Date());
  }
}

// サービス（メニュー）を表現したクラス
class Service {
  String name;
  int price;

  Service(String name, int price) {
    this.name = name;
    this.price = price;
  }

  // サービス情報を文字列で戻す
  String summary() {
    return name + ":¥" + price;
  }
}

// サービスデータを管理するクラス
class ServiceDao {
  // 特定指定日で有効なサービス（メニュー）を戻す
  List<Service> select(String date) {
    List<Service> res = new ArrayList<Service>();
    res.add(new Service("カット", 3000));
    res.add(new Service("パーマ", 8000));
    res.add(new Service("トリートメント", 4000));
    res.add(new Service("カラー", 5000));
    return res;
  }
}