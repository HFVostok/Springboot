package app_escola.crud_escola.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    
    //método
    @GetMapping("/")
    public ModelAndView abrirIndex() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
    @GetMapping("/home")
    public ModelAndView homeIndex() {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
    @GetMapping("/login_adm")//endereço da pagina no site
    public ModelAndView abrirLoginAdm() {
        ModelAndView mv = new ModelAndView("adm/login_adm");
        return mv;
    }
    @GetMapping("/cad_adm")//endereço da pagina no site
    public ModelAndView abrirCadAdm() {
        ModelAndView mv = new ModelAndView("adm/cad_adm");
        return mv;
    }

}
