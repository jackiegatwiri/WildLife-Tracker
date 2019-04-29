import org.sql2o.Connection;

public class Rangers {
private int id;
private String firstName;
private String secondName;
private int badgeNo;

    public Rangers(String firstName, String secondName, int badgeNo) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.badgeNo = badgeNo;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getBadgeNo() {
        return badgeNo;
    }

    @Override
    public boolean equals(Object otherRanger){
        if(!(otherRanger instanceof Rangers )){
            return false;
        } else{
            Rangers newRanger = (Rangers) otherRanger;
            return this.getFirstName().equals(newRanger.getFirstName()) &&
                    this.getSecondName().equals(newRanger.getSecondName()) &&
                    this.getBadgeNo() == (newRanger.getBadgeNo());
        }
    }

    public void save(){
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO rangers(firstname, secondname, badgeno) VALUES (:firstname, :secondname, badgeno)";
            con.createQuery(sql)
            .addParameter("firstname", this.firstName)
                    .addParameter("secondname", this.secondName)
                    .addParameter("badgeno", this.badgeNo)
                    .executeUpdate();


        }
    }
}
