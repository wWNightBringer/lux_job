package job.bespalov.demo.repository;

import job.bespalov.demo.model.ValuesTableEntity;
import org.springframework.data.repository.CrudRepository;
/**
 * Create interface {@link ValuesRepository} and extends by interface {@link CrudRepository}
 *
 * @author Bespalov Andrew
 * @version 1.0
 */
public interface ValuesRepository extends CrudRepository<ValuesTableEntity,Long> {
}
