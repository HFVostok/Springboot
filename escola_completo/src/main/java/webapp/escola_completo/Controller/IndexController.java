import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/login-adm")
    public String acessoLoginAdm() {
        return "login/login-adm";
    }

    @GetMapping("/cadastro-adm")
    public String acessoCadastroadm() {
        return "cadastro/cadastro-adm";
    }

}
