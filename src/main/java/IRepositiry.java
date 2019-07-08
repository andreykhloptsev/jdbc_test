import java.util.List;

/**
 * Created by DIO
 */
public interface IRepositiry<T extends Student> {

    void insert(T student);
    void update(T student);
    boolean delete(int id);
    T get(int id);
    List<T> get();
}
