package job.bespalov.demo.dao;

import job.bespalov.demo.controller.MainController;
import job.bespalov.demo.model.ValuesTableEntity;
import job.bespalov.demo.repository.ValuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Create ValueDaoImpl and implements {@link ValuesDAO}
 *
 * @author Bespalov Andrew
 * @version 1.0
 */
@Component
public class ValuesDAOImpl implements ValuesDAO {
    private List<ValuesTableEntity> valuesTableEntity;
    private ValuesRepository valuesRepository;

    @Autowired
    public ValuesDAOImpl(ValuesRepository valuesRepository) {
        this.valuesRepository = valuesRepository;
        valuesTableEntity = new ArrayList<>();
    }

    /**
     * Add values to {@link ArrayList}
     */
    @Override
    public List<ValuesTableEntity> getAllResult() {
        Iterable<ValuesTableEntity> iterable = valuesRepository.findAll();
        iterable.forEach(x -> valuesTableEntity.add(x));
        return valuesTableEntity;
    }

}
