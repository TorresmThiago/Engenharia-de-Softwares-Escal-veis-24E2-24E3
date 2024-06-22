package com.br.infnet.edu.AT;

import com.br.infnet.edu.AT.controller.UsuarioController;
import com.br.infnet.edu.AT.model.Usuario;
import com.br.infnet.edu.AT.service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UsuarioController.class)
@AutoConfigureMockMvc(addFilters = false)
public class UsuarioControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService usuarioService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void criarUsuarioTest() throws Exception{
        Usuario usuario = new Usuario();
        usuario.setId("test_user_1");
        usuario.setNome("TestUser");
        usuario.setSenha("TestPass");
        usuario.setPapel("Tester");

        given(usuarioService.createUsuario(any(Usuario.class))).willReturn(usuario);

        mockMvc.perform(post("/api/public/usuarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(usuario)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nome").value("TestUser"));
    }

    @Test
    public void getAllUsuariosTest() throws Exception {
        Usuario usuario1 = new Usuario();
        usuario1.setId("test_user_1");
        usuario1.setNome("TestUser_1");
        usuario1.setSenha("TestPass");
        usuario1.setPapel("Tester");

        Usuario usuario2 = new Usuario();
        usuario2.setId("test_user_2");
        usuario2.setNome("TestUser_2");
        usuario2.setSenha("TestPass");
        usuario2.setPapel("Tester");

        given(usuarioService.getAllUsuarios()).willReturn(Arrays.asList(usuario1, usuario2));

        mockMvc.perform(get("/api/public/usuarios"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].nome").value("TestUser_1"))
                .andExpect(jsonPath("$[1].nome").value("TestUser_2"));
    }

    @Test
    public void getUsuarioTest() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setId("test_user_1");
        usuario.setNome("TestUser");
        usuario.setSenha("TestPass");
        usuario.setPapel("Tester");

        given(usuarioService.getUsuarioById(anyString())).willReturn(Optional.of(usuario));

        mockMvc.perform(get("/api/public/usuarios/test_user_1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nome").value("TestUser"));
    }

    @Test
    public void updateUsuarioTest() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setId("test_user_1");
        usuario.setNome("TestUserUpdated");
        usuario.setSenha("TestPassUpdated");
        usuario.setPapel("Tester");

        given(usuarioService.updateUsuario(anyString(), any(Usuario.class))).willReturn(usuario);

        mockMvc.perform(put("/api/public/usuarios/test_user_1")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(usuario)))
                .andExpect(status().isAccepted())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nome").value("TestUserUpdated"));
    }

    @Test
    public void deleteUsuarioTest() throws Exception {
        mockMvc.perform(delete("/api/public/usuarios/test_user_1"))
                .andExpect(status().isAccepted());
    }
}
