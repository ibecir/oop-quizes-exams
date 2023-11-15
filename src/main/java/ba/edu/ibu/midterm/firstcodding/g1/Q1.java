package ba.edu.ibu.midterm.firstcodding.g1;

class Item {
    private String name;
    private int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double calculateTax() {
        return 0.0;
    }
}

class Chocolate extends Item {
    private double cocoaPercentage;

    public Chocolate(String name, int price, double cocoaPercentage) {
        super(name, price);
        this.cocoaPercentage = cocoaPercentage;
    }

    @Override
    public double calculateTax() {
        return super.getPrice() * 0.12;
    }
}

class Cigarettes extends Item {
    private double nicotinePercentage;

    public Cigarettes(String name, int price, double nicotinePercentage) {
        super(name, price);
        this.nicotinePercentage = nicotinePercentage;
    }

    @Override
    public double calculateTax() {
        return super.getPrice() * 1.8;
    }
}

class Q1Tests{
    public static void main(String[] args) {
        Cigarettes cigarette = new Cigarettes("Malboro", 6, 0.8);
        Chocolate chocolate = new Chocolate("Milka", 3, 22);

        // 0.2
        System.out.println(cigarette.getName());

        // 0.2
        System.out.println(chocolate.getPrice());

        // 0.3
        System.out.println(cigarette.calculateTax());

        // 0.3
        System.out.println(chocolate.calculateTax());
    }
}


