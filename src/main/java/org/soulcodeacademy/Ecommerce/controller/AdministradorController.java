package org.soulcodeacademy.Ecommerce.controller;


import org.soulcodeacademy.Ecommerce.domain.Administrador;


import org.soulcodeacademy.Ecommerce.domain.Querys.DashboardTotalCadastrados;
import org.soulcodeacademy.Ecommerce.domain.dto.AdministradorDTO;
import org.soulcodeacademy.Ecommerce.repository.AdministradorRepository;
import org.soulcodeacademy.Ecommerce.services.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @Autowired
    private AdministradorRepository administradorRepository;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/administradores")
    public List<Administrador> mostrarLista() {
        return this.administradorService.listar();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/administradores/{id}")
    public Administrador getAdministrador(@PathVariable Integer id) {
        return this.administradorService.getAdministrador(id);
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/administrador")
    public Administrador salvar(@RequestBody AdministradorDTO dto) {
        Administrador administrador = this.administradorService.salvar(dto);
        return administrador;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/administrador/{id}")
    public void deleteAdmin(@PathVariable Integer id){
        this.administradorService.deletarAdmin(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/administradores/total")
    DashboardTotalCadastrados totalDeAdmCadastrado(@RequestParam String ano){
        return this.administradorService.admsCadastrados(ano);
    }
}



