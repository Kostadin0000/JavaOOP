package Pizza;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (flourType.equals("White") || flourType.equals("Wholegrain")) {
            this.flourType = flourType;
        } else {
            String msg = String.format("Invalid type of dough.");
            throw new IllegalArgumentException(msg);
        }
    }

    private void setWeight(double weight) {
        if (weight >= 1 && weight <= 200) {
            this.weight = weight;
        } else {
            String msg = String.format("Dough weight should be in the range [1..200].");
            throw new IllegalArgumentException(msg);
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (bakingTechnique.equals("Chewy")) {
            this.bakingTechnique = bakingTechnique;
        } else if (bakingTechnique.equals("Crispy")) {
            this.bakingTechnique =bakingTechnique;
        } else if (bakingTechnique.equals("Homemade")) {
            this.bakingTechnique = bakingTechnique;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public double calculateCalories() {
        if (flourType.equals("White")) {
            return (2 * weight) * 1.5 * bakingTechniqueModifier(this.bakingTechnique);
        } else if (flourType.equals("Wholegrain")) {
            return (2 * weight) * 1.0 * bakingTechniqueModifier(this.bakingTechnique);
        } else {
            return 0;
        }
    }

    private double bakingTechniqueModifier(String bakingTechnique) {
        if (bakingTechnique.equals("Chewy")) {
            return 1.1;
        } else if (bakingTechnique.equals("Crispy")) {
            return 0.9;
        } else if (bakingTechnique.equals("Homemade")) {
            return 1.0;
        } else {
            return 0;
        }
    }
}
