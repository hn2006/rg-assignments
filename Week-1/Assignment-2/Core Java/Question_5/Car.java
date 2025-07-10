package Question_5;

public class Car {
    // Private data members ensure data is hidden from outside access
    private String model;
    private int speed;

    // Public getter for read access
    public String getModel() {
        return model;
    }

    // Public setter for write access
    public void setModel(String model) {
        this.model = model;
    }

    public int getSpeed() {
        return speed;
    }

    // Method to increase speed using internal logic controls value
    public void accelerate(int increment) {
        if (increment > 0) {
            speed += increment;
        }
    }
}

