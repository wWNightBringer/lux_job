package job.bespalov.repository;

import job.bespalov.logic.ArderEntity;
import job.bespalov.logic.TablenamespaceEntity;
import org.springframework.stereotype.Component;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<ArderEntity,Long>{
}
