package ba.edu.ibu.quiz3.second;

interface Eatable {
    public String eat();
}

class Elephant implements Eatable {
    private String name;

    public Elephant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String eat() {
        return this.name + " eating";
    }
}

class Cow implements Eatable {
    public String name;

    public Cow(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String eat() {
        return this.name + " eat";
    }
}

class MainC {
    public static void main(String[] args) {
        Elephant elephant = new Elephant("Slonic");
        Cow cow = new Cow("Kravica");

        System.out.println(elephant.eat());
        System.out.println(cow.eat());
    }
}
