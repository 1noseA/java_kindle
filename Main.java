import java.io.File;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    boolean loop = true;

    // トップ画面を表示
    index();

    // 現在ページを保管する
    String pageName = "index";

    while(loop) {
      String input = new Scanner(System.in).nextLine();
      if ("99".equals(input)) {
        System.exit(0);
      } else {
        // 現在トップ画像の場合は、
        // 現在作業フォルダ画面を表示
        if ("index".equals(pageName)) {
          if ("1".equals(input)) {
            // 現在フォルダを表示
            currentPath();
            // 現在ページを設定する
            pageName = "currentPath";
          }
        } else if ("2".equals(input)){
          // ファイル検索画面
          fileSearch();
          // 現在ページを設定する
          pageName = "fileSearch";
        } else if ("fileSearch".equals(pageName)) {
          if ("1".equals(input)) {
            // トップ画面を表示
            index();
            // 現在ページを設定する
            pageName = "index";
          }
        }
      }
    }
  }

  static void header() {
    System.out.println("----------");
    System.out.println("HEADER");
    System.out.println("----------");
  }

  static void menu() {
    System.out.println("-----");
    System.out.println("99：終了");
  }

  static void index() {
    // 共通ヘッダーの表示
    System.out.println("【トップ画面】");
    System.out.println("01：現在作業フォルダ");
    System.out.println("02：ファイル検索機能");
    // 共通メニューの表示
    menu();
  }

  static void currentPath() {
    System.out.println("----------");
    System.out.println("HEADER");
    System.out.println("----------");
    System.out.println("【現在作業フォルダ】");
    System.out.println(new File(".").getAbsolutePath());
    System.out.println("01：トップ画面");
    System.out.println("-----");
    System.out.println("99：終了");
  }

  static void fileSearch() {
    // 共通ヘッダーの表示
    System.out.println("【ファイル検索画面】");
    System.out.println("01：トップ画面");
    // 共通メニューの表示
    menu();
  }

  
}