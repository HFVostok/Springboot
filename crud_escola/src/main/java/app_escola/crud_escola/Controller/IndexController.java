package app_escola.crud_escola.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

     @GetMapping("/home")
    public ModelAndView acessoHomePage() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
    @GetMapping("")
    public String acessoHomePage2() {
        return "index";
    }
    @GetMapping("/login_adm")
    public String acessoLoginAdm() {
        return "login/login_adm";
    }
    @GetMapping("/cad_adm")
    public String acessoCadastroAdm() {
        return "adm/cad_adm";
    }
    
    
    

}
