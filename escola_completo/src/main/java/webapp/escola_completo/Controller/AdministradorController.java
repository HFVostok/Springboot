package webapp.escola_completo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import webapp.escola_completo.Model.Administrador;
import webapp.escola_completo.Model.Aluno;
import webapp.escola_completo.Model.Professor;
import webapp.escola_completo.Repository.AdministradorRepository;
import webapp.escola_completo.Repository.VerificaCadastroAdmRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdministradorController {
    // atributos
    boolean acessoInternoAdm = false;

    @Autowired
    private AdministradorRepository ar;

    @Autowired
    private VerificaCadastroAdmRepository vcar;

    // métodos
    @PostMapping("cadastrar-adm")
    public ModelAndView cadastroAdmBD(Administrador adm) {

        boolean verificaCpf = vcar.existsById(adm.getCpf());

        ModelAndView mv = new ModelAndView("login/login-adm");

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
        ModelAndView mv = new ModelAndView("redirect:/interna-adm");// página interna de acesso

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
            mv.setViewName("redirect:/login-adm");
        }
        return mv;
    }

    // @PostMapping("/cadastrar-aluno")
    // public ModelAndView cadastrarAluno(Aluno aluno) {
    //     // Lógica para salvar o aluno no banco de dados
    //     // Utilize o AlunoRepository para salvar o aluno
    //     // Adicione mensagens de sucesso ou erro conforme necessário
    // }

    // @PostMapping("/cadastrar-professor")
    // public ModelAndView cadastrarProfessor(Professor professor) {
    //     // Lógica para salvar o professor no banco de dados
    //     // Utilize o ProfessorRepository para salvar o professor
    //     // Adicione mensagens de sucesso ou erro conforme necessário
    // }

    @GetMapping("/interna-adm")
    public String acessoPageInternaAdm() {
        String acesso = "";
        ModelAndView mv = new ModelAndView();
        if (acessoInternoAdm) {
            System.out.println("Acesso Permitido");
            acesso = "interna/interna-adm";

        } else {
            String mensagem = "Acesso não Permitido - faça Login";
            System.out.println(mensagem);
            acesso = "login/login-adm";
            mv.addObject("msg", mensagem);
            mv.addObject("classe", "vermelho");
        }

        return acesso;
    }

}
