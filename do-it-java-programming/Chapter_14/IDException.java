package Chapter_14;

/**
 * IDException
 */
public class IDException {

    String userID;

    public String getID() {
        return userID;
    }

    public void check(String name) throws IDFormatException{
        if (name == null) {
            throw new IDFormatException("UserID can't be null");
        }
        else if (name.length() < 8 || name.length() > 20) {
            throw new IDFormatException("You write ID more than 8 or 20 or less");
        }
    }
}