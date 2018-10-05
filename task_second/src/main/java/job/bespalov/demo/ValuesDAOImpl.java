package job.bespalov.demo;

import job.bespalov.demo.dao.ValuesDAO;
import job.bespalov.demo.model.TablenamespaceEntity;
import job.bespalov.demo.model.ValuesTableEntity;
import job.bespalov.demo.repository.TableNamespaceRepository;
import job.bespalov.demo.repository.ValuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class ValuesDAOImpl implements ValuesDAO {
    private List<ValuesTableEntity> valuesTableEntity;
    private List<TablenamespaceEntity> tablenamespaceEntities;
    private ValuesRepository valuesRepository;
    private TableNamespaceRepository tableNamespaceRepository;

    @Autowired
    public ValuesDAOImpl(ValuesRepository valuesRepository, TableNamespaceRepository repository) {
        this.valuesRepository = valuesRepository;
        this.tableNamespaceRepository = repository;
        valuesTableEntity = new ArrayList<>();
        tablenamespaceEntities = new ArrayList<>();

    }


    @Override
    public List<ValuesTableEntity> getAllResult() {
        Iterable<ValuesTableEntity> iterable = valuesRepository.findAll();
        iterable.forEach(x -> valuesTableEntity.add(x));
        return valuesTableEntity;
    }
}
