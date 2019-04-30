import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

    @Override
    protected void before() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlifetracker_test", "jackline", "jacky");
    }

    @Override
    protected void after() {
        try(Connection con = DB.sql2o.open()) {
            String deleteRangersQuery = "DELETE FROM rangers *;";
            String deleteAnimalsQuery = "DELETE FROM animals *;";
            String deleteSightingsQuery = "DELETE FROM sightings *;";
            con.createQuery(deleteRangersQuery).executeUpdate();
            con.createQuery(deleteAnimalsQuery).executeUpdate();
            con.createQuery(deleteSightingsQuery).executeUpdate();
        }
    }

}