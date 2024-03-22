package webapp.contatojdbc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import webapp.contatojdbc.Connection.EmailDAO;



@Controller
public class indexController {
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView abrirIndex() {
        ModelAndView mv = new ModelAndView("index");
        EmailDAO obj = new EmailDAO();
        obj.criaTabela();
        return mv;
    }
}
