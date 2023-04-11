package Chapter_12.Collection;

/**
 * Member
 */
public class Member {

    protected String name;
    protected int memberID;

    public Member(String name, int memberID) {
        this.name = name;
        this.memberID = memberID;
    }

    public String getName() {
        return name;
    }

    public int getMemberID() {
        return memberID;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }
    
    @Override
    public String toString() {
        return "{" + name + ", " + memberID + "}";
    }
}