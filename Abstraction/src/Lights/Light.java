package Lights;

public class Light {
    //цвят
    private Color color;

    //конструктор
    public Light (Color color) {
        this.color = color;
    }

    //метод за смяна на цвета
    public void changeColor() {
        //1. ако цветът е червен -> става зелен
        //2. ако цветът е зелен -> става жълт
        //3. ако цветът е жълт -> става червен
        switch (this.color) {
            case RED:
                this.color = Color.GREEN;
                break;
            case GREEN:
                this.color = Color.YELLOW;
                break;
            case YELLOW:
                this.color = Color.RED;
                break;
        }
    }
        public Color getColor() {
            return color;
        }

}
