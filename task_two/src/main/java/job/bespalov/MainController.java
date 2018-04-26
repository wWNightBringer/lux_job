package job.bespalov;

import job.bespalov.logic.ArderEntity;
import job.bespalov.logic.TablenamespaceEntity;
import job.bespalov.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;

@Controller
@RequestMapping(value = "/table")
public class MainController {
    private UserRepository userRepository;

    @Autowired
    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<ArderEntity> getAllUsers() {
        return userRepository.findAll();
    }
}
