package webapp.escola_completo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InteroController {

    @GetMapping("/cadastro-aluno")
    public String acessarCadastroAluno() {
        return "cadastro/cadastro-aluno";
    }

    @GetMapping("/cadastro-professor")
    public String acessarCadastroProfessor() {
        return "cadastro/cadastro-professor";
    }
}