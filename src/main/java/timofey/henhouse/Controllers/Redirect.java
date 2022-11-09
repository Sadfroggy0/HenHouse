package timofey.henhouse.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Redirect {
    @GetMapping("/second")
    public String second(){
        return "second";
    }
}
