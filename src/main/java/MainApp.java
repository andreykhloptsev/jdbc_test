import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by DIO
 */
public class MainApp {

    static Connection conn;
    static Statement st;

    public static void main(String[] args) {
        dropTable();
        createDatabase();
        Repository rep = new Repository();
        Student student = new Student("Anton", 17,500.0f);
        Student student2 = new Student("Anton", 18,500.0f);
        Student student3 = new Student("Anton", 145,500.0f);
        Student student4 = new Student("Anton", 176,500.0f);
        rep.insert(student);
        rep.insert(student2);
        Student s= rep.get(2);
        s.setSalary(0.5f);
        System.out.println(s);
        rep.insert(student3);
        rep.update(s);
        rep.insert(student4);
        System.out.println(rep.get());
}

        public static void createDatabase(){

            try {
                conn= DriverManager.getConnection("jdbc:sqlite:db_test");
                String sql = "CREATE TABLE IF NOT EXISTS STUDENTS(\n" +
                        "    ID INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                        "   NAME TEXT NOT NULL,\n" +
                        "   AGE INT NOT NULL,\n" +
                        "   SALARY REAL NOT NULL )";
                st=conn.createStatement();
                st.execute(sql);

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        public static void dropTable(){

            try {
                conn=DriverManager.getConnection("jdbc:sqlite:db_test");
                String sql = "DROP TABLE STUDENTS";
                st=conn.createStatement();
                st.execute(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    st.close();
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }



}
