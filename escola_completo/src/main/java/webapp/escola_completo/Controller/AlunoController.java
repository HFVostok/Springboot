package webapp.escola_completo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import webapp.escola_completo.Model.Aluno;
import webapp.escola_completo.Repository.AlunoRepository;

@Controller
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping("/cadastrar-aluno")
    public ModelAndView cadastrarAluno(Aluno aluno) {
        ModelAndView mv = new ModelAndView();

        try {
            // Salvar o aluno no banco de dados
            alunoRepository.save(aluno);

            // Mensagem de sucesso
            mv.addObject("mensagem", "Aluno cadastrado com sucesso!");
            mv.addObject("classe", "verde"); // classe CSS para mensagem verde
        } catch (Exception e) {
            // Tratamento de erro
            mv.addObject("mensagem", "Erro ao cadastrar aluno: " + e.getMessage());
            mv.addObject("classe", "vermelho"); // classe CSS para mensagem vermelha
        }

        // Retornar para a página de cadastro com a mensagem
        mv.setViewName("cadastro/cadastro-aluno");
        return mv;
    }
}