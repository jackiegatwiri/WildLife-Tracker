import org.sql2o.Connection;

import java.util.List;

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
    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO animals(name, type, health, age) VALUES (:name, :type, :health, :age)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("health", this.health)
                    .addParameter("age", this.age)
                    .addParameter("type", TYPE)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<EndangeredAnimals> allEndangeredAnimals(){
        String sql = "SELECT * FROM animals where type = 'Endangered'";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                    .executeAndFetch(EndangeredAnimals.class);
        }

    }
    public static EndangeredAnimals find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            EndangeredAnimals endangeredanimal = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(EndangeredAnimals.class);
            return endangeredanimal;
        }
    }
}
