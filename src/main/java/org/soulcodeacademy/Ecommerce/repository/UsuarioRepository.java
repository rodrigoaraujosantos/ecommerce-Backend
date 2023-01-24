package org.soulcodeacademy.Ecommerce.repository;


import org.soulcodeacademy.Ecommerce.domain.Querys.DashboardCliente;
import org.soulcodeacademy.Ecommerce.domain.Querys.DashboardEmpreendedores;
import org.soulcodeacademy.Ecommerce.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByCpf(String cpf);
    List<Usuario> findByNome(String nome);
    List<Usuario> findByNomeContaining(String busca);
    @Transactional
    @Modifying
    @Query(value = "update usuarios set nome = ?, sobrenome = ?, data_nascimento = ?, " +
            "telefone = ?, cpf = ?, email = ? where id = ?" ,
            nativeQuery = true)
    int updateUserPerfil(String nome, String sobrenome, String dataNascimento,
                                         String telefone, String cpf, String email, Integer id);

    @Transactional
    @Modifying
    @Query(value = "update usuarios set senha = ? where id = ?", nativeQuery = true)
    int updateSenhaPerfil(String senha, Integer id);


    @Query(value = "Select * From usuarios\n" +
            "where dtype != 'Administrador'", nativeQuery = true)
    public List<Usuario> mostrarUsuarios();


    @Query(value = "SELECT mes_de_cadastro_usuario As mes, COUNT(data_abertura) As cadastrados\n" +
            "FROM usuarios\n" +
            "WHERE  dtype = 'Cliente'\n" +
            "AND year(data_abertura)= :ano\n" +
            "GROUP BY data_abertura ORDER BY mes asc;", nativeQuery = true)
    List<DashboardCliente>clienteCadastradosPorMes(String ano);

    @Query(value = "SELECT  mes_de_cadastro_usuario As mes, COUNT(month(data_abertura)) As cadastrados\n" +
            "            FROM usuarios\n" +
            "            WHERE  dtype = 'Empreendedor'\n" +
            "            AND year(data_abertura)= '2023' \n" +
            "            GROUP BY Month(data_abertura) ORDER BY mes asc;", nativeQuery = true)
    List<DashboardEmpreendedores>EmpreendedorCadastradoPorMes(String ano);




}

