package timofey.henhouse.Services;

import java.util.List;

public interface ICrudService <I>{
    void save (I obj);
    void update(I obj);
    I findById(int id);
    List<I> findAll();
    void delete(I obj);
    void deleteById(int id);

}
