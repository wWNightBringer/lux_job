package job.bespalov.demo.controller;

import job.bespalov.demo.dao.ValuesDAOImpl;
import job.bespalov.demo.model.Validate;
import job.bespalov.demo.model.ValuesTableEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create main controller {@link MainController}
 *
 * @author Bespalov Andrew
 * @version 1.0
 */
@Controller
@RequestMapping("/")
public class MainController {
    private ValuesDAOImpl valuesDAO;
    private List<ValuesTableEntity> entityList;
    private List<ValuesTableEntity> newList;
    private Validate validate;
    private String line;
    /*
        Assign value for error
     */
    @Value("${message.error}")
    private String error;

    @Autowired
    public MainController(ValuesDAOImpl valuesDAO, Validate validate) {
        this.valuesDAO = valuesDAO;
        this.validate = validate;
        entityList = new ArrayList<>();
        newList = new ArrayList<>();
    }

    /*
        Customize method getHomePage()!
     */
    @GetMapping({"/", "home_page"})
    public String getHomePage(@RequestParam(value = "filter", required = false) String filter,
                              Model model) {
        model.addAttribute("validate", validate);
        /*
             Check list! If it`s empty, we are adding data.
         */
        if (entityList.isEmpty()) {
            entityList.addAll(valuesDAO.getAllResult());
        }
        if (filter == null) {
            model.addAttribute("values", entityList);
            return "home_page";
        } else {
            try {
                /*
                    Check value in filter and filter out him!
                 */
                if (filter.equalsIgnoreCase("biggest line")) {
                    newList = entityList.stream().
                            filter(v -> (v.getLine().length()) > 20)
                            .collect(Collectors.toList());
                    model.addAttribute("values", newList);
                    return "home_page";
                }
                if (Integer.parseInt(filter) > 0 && Integer.parseInt(filter) < 100) {
                    newList = entityList.stream().
                            filter(v -> v.getIdValue() < Integer.parseInt(filter)).
                            collect(Collectors.toList());
                    model.addAttribute("values", newList);
                    return "home_page";
                }
            } catch (Exception ex) {
                System.out.println(error);

            }
        }


        model.addAttribute("values", entityList);
        return "home_page";
    }

    /*
           Customize method postHomePage()!
        */
    @PostMapping({"/", "home_page"})
    public String postHomePage(@ModelAttribute Validate validate, Model model) {
        /*
            Check value in text field and filter out line
         */
        if (validate.getLine().isEmpty()) {
            model.addAttribute("values", entityList);
            return "home_page";
        }
        try {
            line = validate.getLine();
            newList = entityList.stream()
                    .filter(v -> (v.getLongestWord()).equalsIgnoreCase(line))
                    .collect(Collectors.toList());
            model.addAttribute("values", newList);
            return "home_page";
        } catch (Exception ex) {
            System.out.println(error);

        }
        model.addAttribute("values", entityList);
        return "home_page";
    }

}
