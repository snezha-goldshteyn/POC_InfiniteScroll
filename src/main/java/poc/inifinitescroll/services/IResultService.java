package poc.inifinitescroll.services;
import poc.inifinitescroll.entity.ResultEntity;

import java.io.IOException;
import java.util.List;

public interface IResultService {
    public void addImages() throws IOException;
    List<ResultEntity> getResultsFromRepo(int page);
}
