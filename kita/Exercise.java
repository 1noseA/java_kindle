package kita;

public class Exercise {
  public static void main(String[] args) {
    Dog Dog1 = new Dog();
    Dog Dog2 = new Dog();
    Dog1.SetName("ぽち");
    Dog1.SetAge(3);
    Dog1.SetName("たろう");
    Dog2.SetAge(5);
    Dog1.ShowProfile();
    Dog2.ShowProfile();
  }
}
