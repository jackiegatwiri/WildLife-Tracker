public class EndangeredAnimals extends Animals {
    private String health;
    private String age;
    public static final String TYPE = "Endangered";

    public EndangeredAnimals(String name, String health, String age) {
        super(name);
        this.health = health;
        this.age = age;
    }
    public String getName(){
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getHealth() {
        return health;
    }
    public int getId() {
        return id;
    }
    public static String getTYPE() {
        return TYPE;
    }

    @Override
    public boolean equals(Object otherAnimal) {
        if (!(otherAnimal instanceof EndangeredAnimals)) {
            return false;
        } else {
            EndangeredAnimals newAnimals = (EndangeredAnimals) otherAnimal;
            return this.getName().equals(newAnimals.getName());
        }
    }
}
