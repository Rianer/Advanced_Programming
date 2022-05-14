package database;

import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
    private static List<String> users = new ArrayList<>();

    public static List<String> getUsersInstance(){
        return users;
    }
}
