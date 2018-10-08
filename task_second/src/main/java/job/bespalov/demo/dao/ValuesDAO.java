package job.bespalov.demo.dao;

import job.bespalov.demo.model.ValuesTableEntity;

import java.util.List;

/**
 * Create interface {@link ValuesDAO}
 *
 * @author Bespalov Andrew
 * @version 1.0
 */
public interface ValuesDAO {
    List<ValuesTableEntity> getAllResult();
}
