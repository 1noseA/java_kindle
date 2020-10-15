package kita;

public class Exercise {
  public static void main(String[] args) {
    // Dog dog = new Dog();
    // dog.Name = "ポチ";
    // dog.Age = 3;
    // dog.ShowProfile();
    // dog.Run();
    // dog.Speak();

    // Cat cat = new Cat();
    // cat.Name = "タマ";
    // cat.Age = 3;
    // cat.ShowProfile();
    // cat.sleep();
    // cat.Speak();

    Animal[] animal = new Animal[4];
    //animal[0] = new Cat();
    for (int i = 0; i < animal.length; i++) {
      if (i % 2 == 0) {
        animal[i] = new Cat();
      } else {
        animal[i] = new Dog();
      }
      animal[i].Speak();
    }
  }
}
