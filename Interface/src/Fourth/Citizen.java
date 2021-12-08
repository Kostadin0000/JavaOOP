package Fourth;

public class Citizen implements Buyer,Identifiable,Person {
    private String name;
    private int age;
    private String id;
    private String birthDate;
    private int food;

    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
    }



    @Override
    public void buyFood() {
        this.food += 10;
    }

    @Override
    public int getFood() {
        return this.food;
    }


    @Override
    public String toString() {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getId() {
        return id;
    }
}
//-	name: String
//-	age: int
//-	id: String
//-	birthDate: String
//-	food: int
//+	Citizen(Stirng, int, String, String)
//+	getName() : String
//+	getAge() : int
//+	getId() : String
//+	getFood() : int
//+	buyFood() : void