
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DIO
 */
public class Repository implements IRepositiry {

    Connection conn;
    PreparedStatement st;

    public void insert(Student student) {

        String sql = "INSERT INTO STUDENTS ( NAME, AGE, SALARY) VALUES(?,?,?)";

        try {
            conn= MyConnection.getConnection();
            st=conn.prepareStatement(sql);
            st.setString(1,student.getName());
            st.setInt(2,student.getAge());
            st.setFloat(3,student.getSalary());
            st.execute();

        } catch (SQLException e){
            e.printStackTrace();
        }finally {
           try {
               st.close();
               conn.close();
           } catch (SQLException e){
               e.printStackTrace();
           }
        }

    }

    public void update(Student student) {
        String sql = "UPDATE STUDENTS SET NAME=?, AGE=?, SALARY=? WHERE id=?";

        try {
            conn= MyConnection.getConnection();
            st=conn.prepareStatement(sql);
            st.setString(1,student.getName());
            st.setInt(2,student.getAge());
            st.setFloat(3,student.getSalary());
            st.setInt(4,student.getId());
            st.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public boolean delete(int id) {

        return false;
    }

    public Student get(int id) {
        Student student = new Student();
        conn= MyConnection.getConnection();
        String sql = "SELECT * FROM STUDENTS WHERE id=?";
        try {
            st=conn.prepareStatement(sql);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();

        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return student;
    }

    public List get() {
        List<Student> list= new ArrayList();

        conn= MyConnection.getConnection();
        String sql = "SELECT * FROM STUDENTS";
        try {
            st=conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                Student student = new Student();
                student.setName(rs.getString("NAME"));
                student.setAge(rs.getInt("AGE"));
                student.setSalary(rs.getFloat("SALARY"));
                list.add(student);
            }
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

        return list;
    }
}
