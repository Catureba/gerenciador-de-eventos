package br.com.ge.gerenciadordeeventos.mappers;

import br.com.ge.gerenciadordeeventos.DTOs.UsuarioDTO;
import br.com.ge.gerenciadordeeventos.domain.entities.Usuario;

public class MapperUsuarioDTO {

    public UsuarioDTO fromUsuarioToUsuarioDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setPassword(usuario.getPassword());
        usuarioDTO.setLogin(usuario.getLogin());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setCPF(usuario.getCPF());
        usuarioDTO.setNome(usuario.getNome());
        usuarioDTO.setRole(usuario.getRole());
        usuarioDTO.setUserFunctions(usuario.getUser_functions());

        return usuarioDTO;
    }

    public Usuario fromUsuarioDTOToUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();

        if(usuarioDTO.getId() != null) usuario.setId(usuarioDTO.getId());
        usuario.setPassword(usuarioDTO.getPassword());
        usuario.setLogin(usuarioDTO.getLogin());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setCPF(usuarioDTO.getCPF());
        usuario.setNome(usuarioDTO.getNome());
        usuario.setRole(usuarioDTO.getRole());
        usuario.setUser_functions(usuarioDTO.getUserFunctions());
        return usuario;
    }
}
