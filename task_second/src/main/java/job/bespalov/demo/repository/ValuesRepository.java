package job.bespalov.demo.repository;

import job.bespalov.demo.model.ValuesTableEntity;
import org.springframework.data.repository.CrudRepository;

public interface ValuesRepository extends CrudRepository<ValuesTableEntity,Long> {
}
