import org.sql2o.Connection;
import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;


public class Rangers {
private int id;
private String fname;
private String sname;
private String badge;

    public Rangers(String fname, String sname, String badge) {
        this.id = id;
        this.fname = fname;
        this.sname = sname;
        this.badge = badge;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return fname;
    }

    public String getSecondName() {
        return sname;
    }

    public String getBadgeNo() {
        return badge;
    }

    @Override
    public boolean equals(Object otherRanger){
        if(!(otherRanger instanceof Rangers )){
            return false;
        } else{
            Rangers newRanger = (Rangers) otherRanger;
            return this.getFirstName().equals(newRanger.getFirstName()) &&
                    this.getSecondName().equals(newRanger.getSecondName()) &&
                    this.getBadgeNo().equals(newRanger.getBadgeNo());
        }
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO rangers (fname, sname, badge) VALUES (:fname, :sname, :badge)";
            con.createQuery(sql)
                    .addParameter("fname", this.fname)
                    .addParameter("sname", this.sname)
                    .addParameter("badge", this.badge)
                    .executeUpdate();
        }
    }
    public static List<Rangers> all() {
        String sql = "SELECT fname, sname, badge FROM rangers";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(Rangers.class);
        }
    }
}
