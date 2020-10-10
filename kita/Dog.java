package kita;

class Dog {
  private String Name;
  private int Age;
  private String Breed;

  public Dog(String br) {
    Breed = br;
  }

  public void SetName(String nm) {
    Name = nm;
  }

  public void SetAge(int age) {
    Age = age;
  }

  public void ShowProfile() {
    System.out.println(Breed + "で名前は" + Name + "、" + Age + "です。");
  }
}
