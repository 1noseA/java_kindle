package kita;

public class Exercise {
  public static void main(String[] args) {
    Dog MyDog = new Dog("柴犬");
    MyDog.SetName("ぽち");
    MyDog.SetAge(3);
    MyDog.ShowProfile();

    Cat cat = new Cat();
    cat.Name = "タマ";
    cat.Age = 3;
    cat.ShowProfile();
    cat.sleep();
  }
}
