public class ClothingItem {
    private String name;
    private int quantity;
    private String size;
    private String color;

    public ClothingItem(String name, int quantity, String size, String color) {
        this.name = name;
        this.quantity = quantity;
        this.size = size;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public String toString() {
        return "ClothingItem{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

  class Shirt extends ClothingItem implements ShirtInterface {
    private double lengthSize;
    private double sleeveLength;

    public Shirt(String name, int quantity, String size, String color, double lengthSize, double sleeveLength) {
        super(name, quantity, size, color);
        this.lengthSize = lengthSize;
        this.sleeveLength = sleeveLength;
    }

    public double getLengthSize() {
        return lengthSize;
    }

    public void setLengthSize(double lengthSize) {
        this.lengthSize = lengthSize;
    }

    public double getSleeveLength() {
        return sleeveLength;
    }

    public void setSleeveLength(double sleeveLength) {
        this.sleeveLength = sleeveLength;
    }

    @Override
    public String toString() {
        return "Shirt{" + super.toString() +
                ", lengthSize=" + lengthSize +
                ", sleeveLength=" + sleeveLength +
                '}';
    }


  }

 class Pant extends ClothingItem implements PantInterface {
    private double waistSize;
    private double inseamLength;

    public Pant(String name, int quantity, String size, String color, double waistSize, double inseamLength) {
        super(name, quantity, size, color);
        this.waistSize = waistSize;
        this.inseamLength = inseamLength;
    }

    public double getWaistSize() {
        return waistSize;
    }

    public void setWaistSize(double waistSize) {
        this.waistSize = waistSize;
    }

    public double getInseamLength() {
        return inseamLength;
    }

    public void setInseamLength(double inseamLength) {
        this.inseamLength = inseamLength;
    }

    @Override
    public String toString() {
        return "Pant{" + super.toString() +
                ", waistSize=" + waistSize +
                ", inseamLength=" + inseamLength +
                '}';
    }
}

 interface ShirtInterface {
    void setLengthSize(double lengthSize);
}

 interface PantInterface {
    void setWaistSize(double waistSize);
}