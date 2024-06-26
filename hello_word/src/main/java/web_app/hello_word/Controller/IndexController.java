package web_app.hello_word.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView buscarIndexPost(@RequestParam("buscar") String buscar) {
        ModelAndView mv = new ModelAndView("index");

        String mensagem = "Resultado da Busca!";
        mv.addObject("msg", mensagem);
        mv.addObject("buscar", buscar);

        return mv;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView buscarIndexGet(@RequestParam("buscar") String buscar) {
        ModelAndView mv = new ModelAndView("index");

        String mensagem = "Resultado da Busca!";
        mv.addObject("msg", mensagem);
        mv.addObject("buscar", buscar);

        return mv;
    }

}
