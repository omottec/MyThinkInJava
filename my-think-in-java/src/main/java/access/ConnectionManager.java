package access;

/**
 * Created by qinbingbing on 1/28/16.
 */
class Connection {
    private static int count = 0;
    private int i = 0;

    private Connection() {
        System.out.println("Connection()");
    }

    static Connection makeConnection() {
        count++;
        return new Connection();
    }

    public static int howMany() {
        return count;
    }

    @Override
    public String toString() {
        return "Connection " + count;
    }
}

public class ConnectionManager {
    static int howManyLeft = 3;
    static Connection[] ca = new Connection[3];
    {
        System.out.println("instance init");
        for (Connection x : ca)
            x = Connection.makeConnection();
    }

    public static Connection getConnection() {
        if (howManyLeft > 0)
            return ca[--howManyLeft];
        else {
            System.out.println("No more connections");
            return null;
        }
    }

    public static void main(String[] args) {
        ConnectionManager cm = new ConnectionManager();
        System.out.println(cm.howManyLeft);
        cm.getConnection();
        System.out.println(howManyLeft);
        cm.getConnection();
        System.out.println(howManyLeft);
        getConnection();
        System.out.println(getConnection());
        System.out.println(howManyLeft);
    }
}
