package job.bespalov.demo.controller;

import job.bespalov.demo.ValuesDAOImpl;
import job.bespalov.demo.model.TablenamespaceEntity;
import job.bespalov.demo.model.ValuesTableEntity;
import job.bespalov.demo.repository.TableNamespaceRepository;
import job.bespalov.demo.repository.ValuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {
    private ValuesDAOImpl valuesDAO;

    @Autowired
    public MainController(ValuesDAOImpl valuesDAO) {
        this.valuesDAO = valuesDAO;
    }

    @GetMapping({"/", "home_page"})
    public String getHomePage(Model model) {
        ValuesTableEntity tableEntity;
        model.addAttribute("values", valuesDAO.getAllResult());
        return "home_page";
    }


}
