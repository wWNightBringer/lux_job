package job.bespalov.demo.model;

import org.springframework.stereotype.Service;

@Service
public class Validate {
    private String line;

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }
}
