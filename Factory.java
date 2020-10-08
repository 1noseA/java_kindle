import java.util.Arrays;
import java.util.List;

public class Factory {
  public static void main(String[] args) throws Exception {
    // DatabaseFactoryクラスのget()メソッドを実行
    Database<Sales> db = DatabaseFactory.get();

    // DatabaseインスタンスからSalesのリストを取得する
    List<Sales> entities = db.select();

    // 表示処理
    for(Sales entity : entities) {
      System.out.println(entity.name);
    }
  }
}

class DatabaseFactory {
  static <T> Database<T> get() throws Exception {
    // ファイルからクラス名を取得
    String className = "SalesDao";

    // クラスを検索
    Class<?> clz = Class.forName(className);

    // クラス情報からインスタンスを作成する
    Database<T> db = (Database)clz.newInstance();
    return db;
  }
}

interface Database<T> {
  List<T> select();
}

class SalesDao3 implements Database<Sales> {
  public List<Sales> select() {
    // 仮データ
    return Arrays.asList(new Sales[] {new Sales("時計"), new Sales("PC")});
  }
}

class Sales {
  String name;
  public Sales(String name) {
    this.name = name;
  }
}