package animals;


public class Kitten extends Cat {
    static final String gender = "Female";

    public Kitten(String name, int age) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Meow";

    }
}
