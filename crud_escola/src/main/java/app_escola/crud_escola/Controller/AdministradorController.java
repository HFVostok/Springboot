package app_escola.crud_escola.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;


import app_escola.crud_escola.Model.*;
import app_escola.crud_escola.Repository.*;


@Controller
public class AdministradorController {
    @Autowired
    private AdministradorRepository ar ;

    @Autowired
    private VerificaCadastroAdmrepository vcar;

    @PostMapping("/cad_adm")
    public String postCadAdm (Administrador adm) {
        String cpfVerificar = vcar.findByCpf(adm.getCpf()).getCpf();
        if (cpfVerificar == adm.getCpf()) {
            ar.save(adm); 
        }
        
        return "adm/login_adm";
    }
    
    
}
