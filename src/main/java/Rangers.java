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
}
