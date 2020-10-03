import java.util.ArrayList;
import java.util.List;

public class Game {
  public static void main(String[] args) throws Exception{
    // 敵1のインスタンス化
    Enemy enemy1 = new Enemy(1, 1);

    // 敵2のインスタンス化
    Enemy enemy2 = new Enemy(5, 3);

    // 自分を作成
    Ship s = new Ship(1, 6);

    // 敵を管理するList
    List<Enemy> enemys = new ArrayList<>();

    // 敵を追加する
    enemys.add(enemy1);
    enemys.add(enemy2);

    // ゲーム中フラグ
    boolean loop = true;
    System.out.println("ゲーム開始");

    while(loop) {
      // ログを出力
      out(s, enemys);

      // 自分を移動
      s.move(2, 1);

      // 敵を移動
      for (Enemy enemy : enemys) {
        // 敵を移動
        enemy.move(1, 2);

        // 衝突を検証
        if (s.conflict(enemy)) {
          // 衝突ログを出力
          out(s, enemy);

          // whileを抜ける
          loop = false;
          break;
        }
      }

      // メインスレッドを一時停止
      Thread.sleep(1000);
    }
    System.out.println("ゲーム終了");
  }

  // ログ出力
  static void out(Ship s, Enemy ... enemys) {
    System.out.println(s.summary());
    for (Enemy enemy : enemys) {
      System.out.println(enemy.summary());
    }
    System.out.println();
  }

  // ログ出力
  static void out(Ship s, List<Enemy> enemys) {
    out(s, enemys.toArray(new Enemy[0]));
  }
}

class Enemy {
  int x, y;

  // 初期位置
  Enemy(int x, int y) {
    this.x = x;
    this.y = y;
  }

  // 移動する
  void move(int dx, int dy) {
    this.x += dx;
    this.y += dy;
  }

  // 描画処理
  void draw() {
  }

  String summary() {
    return (getName() + "[" + x + "][" + y + "]");
  }

  // オーバーライド
  String getName() {
    return "Item";
  }
}

class Ship extends Enemy {
  int width = 2;
  int height = 2;

  public Ship(int x, int y) {
    super(x, y);
  }

  // 衝突しているか検証
  boolean conflict(Enemy enemy) {
    // 衝突の確認
    if (x <= enemy.x && enemy.x <= x + width && y <= enemy.y && enemy.y <= y + height) {
      return true;
    }
    return false;
  }

  // オーバーライド
  String getName() {
    return "Ship";
  }
}