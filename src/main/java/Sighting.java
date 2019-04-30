import org.sql2o.Connection;

import java.util.List;

public class Sighting {
    private int animalId;
    private String location;
    private String rangerName;

    public Sighting(int animalId, String location, String rangerName) {
        this.animalId = animalId;
        this.location = location;
        this.rangerName = rangerName;
    }

    public int getAnimalId() {
        return animalId;
    }

    public String getLocation() {
        return location;
    }

    public String getRangerName() {
        return rangerName;
    }

//    @Override
//    public boolean equals(Object otherAnimal){
//        if(!(otherAnimal instanceof Animals)){
//            return false;
//        }
//        else {
//            Animals newAnimals = (Animals) otherAnimal;
//            return this.getName().equals(newAnimals.getName());
//        }
//    }
//    public void save(){
//        try(Connection con = DB.sql2o.open()){
//            String sql = "INSERT INTO animals(name, type) VALUES (:name, :type)";
//            this.id = (int) con.createQuery(sql, true)
//                    .addParameter("name", this.name)
//                    .addParameter("type", TYPE)
//                    .executeUpdate()
//                    .getKey();
//        }
//    }
//    public static List<Animals> all(){
//        String sql = "SELECT * FROM animals where type = 'Not Endangered'";
//        try(Connection con = DB.sql2o.open()){
//            return con.createQuery(sql)
//                    .throwOnMappingFailure(false) //throw an exception to tell database not to return the fiels that it is not using
//                    .executeAndFetch(Animals.class);
//        }
//
//    }
//    public static Animals find(int id) {
//        try(Connection con = DB.sql2o.open()) {
//            String sql = "SELECT * FROM animals where id=:id";
//            Animals animal = con.createQuery(sql)
//                    .addParameter("id", id)
//                    .executeAndFetchFirst(Animals.class);
//            return animal;
//        }
//    }
}
