package Database;

public class DBLoader {
    public static void load(Database database) {
        database.add("123451", new Product("7.62 bullets x30", "123451", 100));
        database.add("123452", new Product("5.56 bullets x30", "123452", 200));
        database.add("123453", new Product("M62 grenade", "123453", 500));
        database.add("123454", new Product("M4A3 ", "123454", 2000));
        database.add("123455", new Product("AK-47", "123455", 1000));
        database.add("123456", new Product("Barret .50", "123456", 10000));
    }
}
