package webapp.escola_completo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String mostrarFormularioLogin() {
        return "login-adm";
    }

    @PostMapping("/login")
    public String fazerLogin(@RequestParam("cpf") String cpf, @RequestParam("senha") String senha, Model model) {
        String tipoUsuario = userService.verificarTipoUsuario(cpf, senha);
        if ("ADM".equals(tipoUsuario)) {
            return "redirect:/interna-adm";
        } else if ("ALUNO".equals(tipoUsuario)) {
            return "redirect:/interno-aluno";
        } else if ("PROFESSOR".equals(tipoUsuario)) {
            return "redirect:/intern-professor";
        } else {
            model.addAttribute("mensagem", "Usuário ou senha inválidos.");
            return "login-adm";
        }
    }
}