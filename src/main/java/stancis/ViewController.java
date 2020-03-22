package stancis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ViewController {
  @GetMapping({"/", "/{view}"})
  public String home(@PathVariable(required = false) String view) {
    return view == null ? "home" : view;
  }
}
