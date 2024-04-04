package app_escola.crud_escola.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app_escola.crud_escola.Model.*;
import app_escola.crud_escola.Repository.*;

@Controller
public class AdministradorController {
    // atributos
    boolean acessoInternoAdm = false;

    @Autowired
    private AdministradorRepository ar;

    @Autowired
    private VerificaCadastroAdmrepository vcar;

    @PostMapping("cad_adm")
    public ModelAndView cadastroAdmBD(Administrador adm) {

        boolean verificaCpf = vcar.existsById(adm.getCpf());

        ModelAndView mv = new ModelAndView("login/login_adm");

        if (verificaCpf) {
            ar.save(adm);
            String mensagem = "Cadastro Realizado com sucesso";
            System.out.println(mensagem);
            mv.addObject("msg", mensagem);
            mv.addObject("classe", "verde");
        } else {
            String mensagem = "Cadastro Não Realizado";
            System.out.println(mensagem);
            mv.addObject("msg", mensagem);
            mv.addObject("classe", "vermelho");
        }

        return mv;

    }

    @PostMapping("acesso-adm")
    public ModelAndView acessoAdmLogin(@RequestParam String cpf,
            @RequestParam String senha,
            RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView("redirect:/interna_adm");// página interna de acesso

        boolean acessoCPF = cpf.equals(ar.findByCpf(cpf).getCpf());
        boolean acessoSenha = senha.equals(ar.findByCpf(cpf).getSenha());

        if (acessoCPF && acessoSenha) {
            String mensagem = "Login Realizado com sucesso";
            System.out.println(mensagem);
            acessoInternoAdm = true;
            mv.addObject("msg", mensagem);
            mv.addObject("classe", "verde");
        } else {
            String mensagem = "Login Não Efetuado";
            System.out.println(mensagem);
            mv.addObject("msg", mensagem);
            mv.addObject("classe", "vermelho");
            mv.setViewName("redirect:/login_adm");
        }
        return mv;
    }

    @GetMapping("/interna_adm")
    public ModelAndView acessoPageInternaAdm(RedirectAttributes attributes) {
        ModelAndView mv =  new ModelAndView("interna/interna_adm");
        if (acessoInternoAdm) {
            System.out.println("Acesso Permitido");
        } else{
            String mensagem = "Acesso não Permitido - faça Login";
            System.out.println(mensagem);
            mv.setViewName("redirect:/login_adm");
            mv.addObject("msg", mensagem);
            mv.addObject("classe", "vermelho");
            
        }
        
        return mv;
    }
    

    // public String postCadAdm (Administrador adm) {
    // String cpfVerificar = vcar.findByCpf(adm.getCpf()).getCpf();
    // if (cpfVerificar == adm.getCpf()) {
    // ar.save(adm);
    // }

    // return "adm/login_adm";
    // }
}
