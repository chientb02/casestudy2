package casestudy.IO;

import java.util.List;

public interface IOFile<E> {
    void write(List<E> es, String path);

    List<E> read(String path);
}
