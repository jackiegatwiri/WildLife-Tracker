import org.sql2o.Connection;

import java.util.List;

public class Animals {
    public int id;
    public String name;

    public Animals(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }

    @Override
    public boolean equals(Object otherAnimal){
        if(!(otherAnimal instanceof Animals)){
            return false;
        }
        else {
            Animals newAnimals = (Animals) otherAnimal;
            return this.getName().equals(newAnimals.getName());
        }
    }
    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO animals(name) VALUES (:name)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<Animals> all(){
        String sql = "SELECT * FROM animals";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql).executeAndFetch(Animals.class);
        }

    }
    public static Animals find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            Animals animal = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Animals.class);
            return animal;
        }
    }
}
