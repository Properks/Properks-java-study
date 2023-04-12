package Chapter_12.Collection;

import java.lang.Comparable;
/**
 * Member
 */
public class Member implements Comparable<Member> {// For TreeSet

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
    public int hashCode() {
        return memberID;
    }
    
    @Override
    public boolean equals(Object ob) {// The reason why I use Object as parameter is equal function's parameter is object
        if (ob instanceof Member) {
            Member temp = (Member)ob;
            if (this.memberID == temp.memberID) {
                return true;
            }
        }
        return false;
    } // If two members' memberID is same, Computer think same things and not add in HashSet
    
    @Override
    public String toString() {
        return "{" + name + ", " + memberID + "}";
    }

    @Override
    public int compareTo(Member other) { // which one compare to for sorting
        return this.name.compareTo(other.name); // ascending
        // return other.name.compareTo(this.name); // descending
        // return this.name.compareTo(other.name) * (-1);
        
    }
}
