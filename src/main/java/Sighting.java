import org.sql2o.Connection;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.List;

public class Sighting {
    private int animalId;
    private String location;
    private String rangerName;
    private int id;
    private Timestamp date;

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
    public int getId() {
        return id;
    }

    public String getDate(){
        return DateFormat.getDateTimeInstance().format(date);
    }

    @Override
    public boolean equals(Object otherSighting){
        if(!(otherSighting instanceof Sighting)){
            return false;
        }
        else {
            Sighting newSighting = (Sighting) otherSighting;
            return this.id == newSighting.getId();
        }

//        this.getAnimalId() == (newSighting.getAnimalId()) &&
//                this.getLocation().equals(newSighting.getLocation()) &&
//                this.getRangerName().equals(newSighting.getLocation());
    }
    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO sightings(animalid, location, rangername, date) VALUES (:animalid, :location, :rangername, now())";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("animalid", this.animalId)
                    .addParameter("location", this.location)
                    .addParameter("rangername", this.rangerName)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<Sighting> allSighting(){
        String sql = "SELECT * FROM sightings";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                    .executeAndFetch(Sighting.class);
        }

    }
    public static Sighting find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings where id=:id";
            Sighting sighting = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sighting.class);
            return sighting;
        }
    }


}
