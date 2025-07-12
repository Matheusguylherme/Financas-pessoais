package com.financasGrupo.financasPessoais.controller;

import com.financasGrupo.financasPessoais.DTO.UserRequestDto;
import com.financasGrupo.financasPessoais.DTO.UserResponseDto;
import com.financasGrupo.financasPessoais.DTO.UserUpdateDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import com.financasGrupo.financasPessoais.model.Usuario;
import com.financasGrupo.financasPessoais.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<UserResponseDto> listarUsuarios(){
        // 1. Busca a lista de entidades do banco de dados (isso não muda)
        List<Usuario> usuarios = usuarioService.listarUsuarios();

        // 2. Cria uma nova lista vazia que vai guardar os DTOs
        List<UserResponseDto> usuariosDto = new ArrayList<>();

        // 3. Percorre cada 'usuario' na lista de 'usuarios'
        for (Usuario usuario : usuarios) {
            // 4. Para cada usuario, cria um novo UserResponseDto
            UserResponseDto dto = new UserResponseDto(usuario);

            // 5. Adiciona o DTO recém-criado na nova lista
            usuariosDto.add(dto);
        }

        // 6. Retorna a lista de DTOs preenchida
        return usuariosDto;
    }

    @GetMapping("/{id}")
    public UserResponseDto buscarUsuarioPorId(@PathVariable ("id") long id) {
        // 1. Busca o usuário pelo ID
        Usuario usuario = usuarioService.buscarPorid(id);

        // 2. Converte o usuário para DTO
        UserResponseDto usuarioDto = new UserResponseDto(usuario);

        // 3. Retorna o DTO
        return usuarioDto;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserResponseDto> patchUsuario(@PathVariable Long id, @Valid @RequestBody UserUpdateDto updateDto) {

        // 1. Busca o usuário existente pelo ID
        Usuario usuarioExistente = usuarioService.buscarPorid(id);

        // 2. Atualiza os campos do usuário existente com os dados do DTO
        usuarioExistente.setUsername(updateDto.nome());
        usuarioExistente.setEmail(updateDto.email());

        // 3. Salva o usuário atualizado
        Usuario usuarioAtualizado = usuarioService.atualizarUsuario(id, usuarioExistente);

        // 4. Converte o usuário atualizado para DTO de resposta
        UserResponseDto updated = new UserResponseDto(
                usuarioAtualizado.getId(),
                usuarioAtualizado.getUsername(),
                usuarioAtualizado.getEmail()
        );
        return ResponseEntity.ok(updated);
    }

    @PostMapping
    public UserResponseDto criarUsuario(@Valid @RequestBody UserRequestDto usuarioRequestDto) {

        // 1. Recebe o DTO de entrada
        // 2. Converte para entidade
        Usuario usuario = new Usuario();
        usuario.setUsername(usuarioRequestDto.nome());
        usuario.setPassword(usuarioRequestDto.senha());
        usuario.setEmail(usuarioRequestDto.email());

        // 3. Salva a entidade
        Usuario usuarioSalvo = usuarioService.salvaUsuario(usuario);

        // 4. Converte para DTO de resposta
        // 5. Retorna o DTO de resposta
        return new  UserResponseDto(
                usuarioSalvo.getId(),
                usuarioSalvo.getUsername(),
                usuarioSalvo.getEmail()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }
 }








