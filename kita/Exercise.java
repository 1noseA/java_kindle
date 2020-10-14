package kita;

public class Exercise {
  public static void main(String[] args) {
    // Dog MyDog = new Dog("柴犬");
    // MyDog.SetName("ぽち");
    // MyDog.SetAge(3);
    // MyDog.ShowProfile();

    Dog dog = new Dog();
    dog.Name = "ポチ";
    dog.Age = 3;
    dog.ShowProfile();
    dog.Run();
    dog.Speak();

    Cat cat = new Cat();
    cat.Name = "タマ";
    cat.Age = 3;
    cat.ShowProfile();
    cat.sleep();
    cat.Speak();
  }
}
