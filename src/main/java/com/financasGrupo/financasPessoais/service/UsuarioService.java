package com.financasGrupo.financasPessoais.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.financasGrupo.financasPessoais.model.Usuario;
import com.financasGrupo.financasPessoais.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvaUsuario(Usuario usuario) {
         usuarioRepository.findByUsername(usuario.getUsername())
                .ifPresent(u -> { throw  new RuntimeException("Username já existe"); } );
        return usuarioRepository.save(usuario);
    }

    public void deletarUsuario(Long id){
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElse(null);
        if (usuarioExistente != null) {
            usuarioRepository.deleteById(id);
        }
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
    

    public Usuario atualizarUsuario (Long id, Usuario usuario){
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        
        usuarioExistente.setUsername(usuario.getUsername());
        usuarioExistente.setEmail(usuario.getEmail());
        usuarioExistente.setPassword(usuario.getPassword());      

        return usuarioRepository.save(usuarioExistente);
    }

    public Usuario buscarPorid (Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

    }
}
