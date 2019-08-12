package poc.inifinitescroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poc.inifinitescroll.entity.ResultEntity;

public interface ResultRepository extends JpaRepository<ResultEntity, Long> {
}
