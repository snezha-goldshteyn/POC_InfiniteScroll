package poc.inifinitescroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import poc.inifinitescroll.entity.ResultEntity;
import poc.inifinitescroll.repository.ResultRepository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResultService implements IResultService {

    private final int size = 10;

    @Autowired
    ResultRepository repository;

    @PostConstruct
    @Transactional
    public void addImages() throws IOException {
        for (int i = 1; i <= 200; i++) {
            ResultEntity entity = new ResultEntity();
            entity.setName("name" + i);
            entity.setDescription("all about name " + i);
            entity.setPrice(100.0);
            repository.save(entity);
        }
    }

    @Override
    public List<ResultEntity> getResultsFromRepo(int page) {
        int start = size * (page-1) + 1;
        int end = page * size;
        List<ResultEntity> result = new ArrayList<>();
        for (long i = start; i <= end; i++) {
            ResultEntity entity = repository.findById(i).orElse(null);
            if (entity == null) {
                break;
            }
            result.add(entity);
        }
        return result;
    }
}
