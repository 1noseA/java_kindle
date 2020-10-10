package kita;

class Dog {
  private String Name;
  private int Age;
  private String Breed;

  public void SetName(String nm) {
    Name = nm;
  }

  public void SetAge(int age) {
    Age = age;
  }

  public void SetBreed(String br) {
    Breed = br;
  }

  public void ShowProfile() {
    System.out.println("名前は" + Name + "、" + Age + "才、犬種は" + Breed + "です。");
  }
}
