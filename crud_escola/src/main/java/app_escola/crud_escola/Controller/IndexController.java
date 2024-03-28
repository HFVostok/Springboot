package app_escola.crud_escola.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String acessoHome() {
        return "index";
    }
    
    @GetMapping("/home")
    public String acessoHome2() {
        return "index";
    }

    @GetMapping("/login_adm")
    public String acessoLoginAdm() {
        return "login/login_adm";
    }

}
