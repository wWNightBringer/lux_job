package job.bespalov.demo.repository;

import job.bespalov.demo.model.TablenamespaceEntity;
import org.springframework.data.repository.CrudRepository;
/**
 * Create interface {@link TableNamespaceRepository} and extends by interface {@link CrudRepository}
 *
 * @author Bespalov Andrew
 * @version 1.0
 */
public interface TableNamespaceRepository extends CrudRepository<TablenamespaceEntity,Long> {
}
