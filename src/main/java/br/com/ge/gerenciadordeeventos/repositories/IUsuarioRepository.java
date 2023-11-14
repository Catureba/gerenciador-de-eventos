package br.com.ge.gerenciadordeeventos.repositories;

import br.com.ge.gerenciadordeeventos.domain.entities.Usuario;
import br.com.ge.gerenciadordeeventos.domain.enums.UserFunction;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.UUID;
public interface IUsuarioRepository extends JpaRepository<Usuario, UUID> {
//    @Query("SELECT u FROM Usuario u WHERE :function MEMBER OF u.user_functions")
//    List<Usuario> listUserByFunctions(int function);
    Usuario findByNome(String nome);
    Usuario findByEmail(String email);
    Usuario findByCPF(String CPF);
    UserDetails findByLogin(String login);
}
