package webapp.escola_completo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import webapp.escola_completo.Model.Professor;
import webapp.escola_completo.Repository.ProfessorRepository;

@Controller
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @PostMapping("/cadastrar-professor")
    public ModelAndView cadastrarProfessor(Professor professor) {
        ModelAndView mv = new ModelAndView();

        try {
            // Salvar o professor no banco de dados
            professorRepository.save(professor);

            // Mensagem de sucesso
            mv.addObject("mensagem", "Professor cadastrado com sucesso!");
            mv.addObject("classe", "verde"); // classe CSS para mensagem verde
        } catch (Exception e) {
            // Tratamento de erro
            mv.addObject("mensagem", "Erro ao cadastrar professor: " + e.getMessage());
            mv.addObject("classe", "vermelho"); // classe CSS para mensagem vermelha
        }

        // Retornar para a página de cadastro com a mensagem
        mv.setViewName("cadastro/cadastro-professor");
        return mv;
    }
}
