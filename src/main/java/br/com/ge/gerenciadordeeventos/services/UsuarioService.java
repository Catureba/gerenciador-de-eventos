package br.com.ge.gerenciadordeeventos.services;

import br.com.ge.gerenciadordeeventos.DTOs.UsuarioDTO;
import br.com.ge.gerenciadordeeventos.mappers.MapperUsuarioDTO;
import br.com.ge.gerenciadordeeventos.domain.entities.Usuario;
import br.com.ge.gerenciadordeeventos.domain.enums.UserFunction;
import br.com.ge.gerenciadordeeventos.repositories.IUsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    @Autowired
    IUsuarioRepository repository;
    MapperUsuarioDTO mapperUsuarioDTO = new MapperUsuarioDTO();

    public UsuarioDTO buscarUsuarioPorID(UUID id){

        Usuario user = repository.findById(id).orElse(null);
        if(user == null) throw new RuntimeException("Usuario não encontrado");
        UsuarioDTO usuarioDTO = mapperUsuarioDTO.fromUsuarioToUsuarioDTO(user);
        return usuarioDTO;
    }
    public UsuarioDTO buscarUsuarioPorEmail(String email){
        Usuario user = repository.findByEmail(email);
        if(user == null) throw new RuntimeException("Usuario não encontrado");
        UsuarioDTO usuarioDTO = mapperUsuarioDTO.fromUsuarioToUsuarioDTO(user);
        return usuarioDTO;
    }
    public UsuarioDTO buscarUsuarioPorNome(String nome){
        Usuario user = repository.findByNome(nome);
        if(user == null) throw new RuntimeException("Usuario não encontrado");
        UsuarioDTO usuarioDTO = mapperUsuarioDTO.fromUsuarioToUsuarioDTO(user);
        return usuarioDTO;
    }
    public UsuarioDTO buscarUsuarioPorCPF(String CPF){
        Usuario user = repository.findByCPF(CPF);
        if(user == null) throw new RuntimeException("Usuario não encontrado");
        UsuarioDTO usuarioDTO = mapperUsuarioDTO.fromUsuarioToUsuarioDTO(user);
        return usuarioDTO;
    }

    public List<UsuarioDTO> buscarTodosOsUsuarios(){
        List<Usuario> usuarios = repository.findAll();
        List<UsuarioDTO> usuarioDTOS = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            usuarioDTOS.add(mapperUsuarioDTO.fromUsuarioToUsuarioDTO(usuario));
        }
        if(usuarioDTOS.isEmpty()) throw new RuntimeException("Usuarios não encontrados");
        return usuarioDTOS;
    }
    public UsuarioDTO cadastrar(UsuarioDTO usuarioDTO){
        Usuario usuarioSalvo = repository.save(mapperUsuarioDTO.fromUsuarioDTOToUsuario(usuarioDTO));
        return mapperUsuarioDTO.fromUsuarioToUsuarioDTO(usuarioSalvo);
    }
    public void deletar(UUID id){
        Usuario usuario = repository.findById(id).orElse(null);
        if(usuario == null) throw new RuntimeException("Usuario não encontrado");
        repository.deleteById(usuario.getId());
    }

    public UsuarioDTO atualizar(UsuarioDTO usuarioDTO){

        Usuario usuarioExistente = repository.findById(usuarioDTO.getId()).orElse(null);
        if (usuarioExistente == null) throw new RuntimeException("Usuario não encontrado");

        usuarioExistente.setLogin(usuarioDTO.getLogin());
        usuarioExistente.setEmail(usuarioDTO.getEmail());
        usuarioExistente.setCPF(usuarioDTO.getCPF());
        usuarioExistente.setNome(usuarioDTO.getNome());
        usuarioExistente.setRole(usuarioDTO.getRole());
        usuarioExistente.setUser_functions(usuarioDTO.getUserFunctions());

        Usuario usuarioAtualizado = repository.save(usuarioExistente);

        return mapperUsuarioDTO.fromUsuarioToUsuarioDTO(usuarioAtualizado);
    }
    public List<UsuarioDTO> buscarTodosOsUsuariosPorFuncao(UserFunction function) {

        //List<Usuario> usuarios = repository.listUserByFunctions(function);
        List<Usuario> usuarios = repository.findAll();
        List<UsuarioDTO> usuarioDTOS = usuarios.stream()
                .filter(user -> user.getUser_functions().contains(function))
                .map(mapperUsuarioDTO::fromUsuarioToUsuarioDTO)
                .collect(Collectors.toList());

        return usuarioDTOS.isEmpty() ? null : usuarioDTOS;
    }

}
