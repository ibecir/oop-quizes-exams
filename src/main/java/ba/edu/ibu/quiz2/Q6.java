package ba.edu.ibu.quiz2;

enum Manufacturer {
    BMW, VW, AUDI
}

class Component {
    private String name;
    private int serialNumber;
    private Manufacturer manufacturer;

    public Component(String name) {
        this.name = name;
    }

    public Component(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Component(String name, int serialNumber, Manufacturer manufacturer) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String whichComponentAmI(){
        return "Component";
    }
}

class Wheel extends Component{
    private int diameter;

    public Wheel(String name, int serialNumber, Manufacturer manufacturer, int diameter) {
        super(name, serialNumber, manufacturer);
        this.diameter = diameter;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    @Override
    public String whichComponentAmI(){
        return "Wheel";
    }
}

class Gearbox extends Component{
    private int numOfGears;

    public Gearbox(String name, int numOfGears) {
        super(name);
        this.numOfGears = numOfGears;
    }

    public int getNumOfGears() {
        return numOfGears;
    }

    public void setNumOfGears(int numOfGears) {
        this.numOfGears = numOfGears;
    }

    @Override
    public String whichComponentAmI(){
        return "Gearbox";
    }
}
