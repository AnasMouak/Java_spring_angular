package spring.java_spring;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class JavaSpringController {

    @GetMapping("/")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/spring")
    public String spring() {
        return "spring";
    }
    
    @GetMapping({"/java", "/java/", "/java/{name}"})
    public String helloJava(@PathVariable(required = false) String name) {
        if (name == null) {
            name = "is awesome";
        }
        return "java, " + name.replace("_", " ") + "!";
    }

    @GetMapping("/number/{n}")
    public String number(@PathVariable int n) {
        return n + " is a number";
    }

    @GetMapping("/number_template/{n}") 
    public ModelAndView number_template(@PathVariable int n) {
        ModelAndView modelAndView = new ModelAndView("number"); // Looks for 'number.html'
        modelAndView.addObject("number", n); // Passes 'n' as a model attribute
        return modelAndView;
    }

    @GetMapping("/number_odd_or_even/{n}")
    public ModelAndView number_odd_or_even(@PathVariable int n) {
        ModelAndView modelAndView = new ModelAndView("number_odd_or_even"); // Looks for 'odd_or_even.html'
        modelAndView.addObject("number", n); // Passes 'n' as a model attribute
        modelAndView.addObject("odd_or_even", n % 2 == 0 ? "even" : "odd"); // Passes 'odd' or 'even' as a model attribute
        return modelAndView;
    }
    
}
