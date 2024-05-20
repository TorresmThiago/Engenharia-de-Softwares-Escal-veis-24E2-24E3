package br.com.infnet.TP1.controller;

import br.com.infnet.TP1.model.Tenis;
import br.com.infnet.TP1.service.TenisService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.MalformedParametersException;
import java.util.List;

@RestController
@RequestMapping("/tenis")
public class TenisController {
    final TenisService tenisService;

    public TenisController(TenisService tenisService){
        this.tenisService = tenisService;
    }

    @Operation(summary = "Retorna todos os tênis da lista")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "A lista de tênis foi encontrada com sucesso"),
            @ApiResponse(responseCode  = "204", description = "Não foi encontrado nenhuma um tênis na lista"),
            @ApiResponse(responseCode  = "500", description = "O servidor apresentou algum erro ao tentar realizar a ação")
    })
    @GetMapping
    public ResponseEntity<?> getAll() {
        try{
            List<Tenis> tenisList = tenisService.getAll();
            if (tenisList.isEmpty())
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Nenhum tênis cadastrado");

            return ResponseEntity.status(HttpStatus.OK).body(tenisList);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "Retorna uma tênis da lista")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description = "O Tênis com id desejado foi encontrado com sucesso"),
            @ApiResponse(responseCode  = "400", description = "Algum parâmetro informado não foi preenchido corretamente"),
            @ApiResponse(responseCode  = "404", description = "Não foi encontrado na lista um tênis com tal id"),
            @ApiResponse(responseCode  = "500", description = "O servidor apresentou algum erro ao tentar realizar a ação")
    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> get(@PathVariable int id){
        try {
            Tenis tenis = tenisService.getById(id);
            return ResponseEntity.status(HttpStatus.OK).body(tenis);
        } catch (MalformedParametersException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        } catch (OpenApiResourceNotFoundException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }

    @Operation(summary = "Cria e insere um novo tênis na lista")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "201", description = "O Tênis informado foi criado com sucesso"),
            @ApiResponse(responseCode  = "400", description = "Algum parâmetro informado não foi preenchido corretamente"),
            @ApiResponse(responseCode  = "500", description = "O servidor apresentou algum erro ao tentar realizar a ação")
    })
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Tenis tenis){
        try {
            tenisService.create(tenis);
            return ResponseEntity.status(HttpStatus.CREATED).body(String.format("Tenis %s adicionado!", tenis.getModelo()));
        } catch (MalformedParametersException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }

    @Operation(summary = "Atualiza uma tênis da lista")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "202", description = "O Tênis com id desejado foi atualizado com sucesso"),
            @ApiResponse(responseCode  = "400", description = "Algum parâmetro informado não foi preenchido corretamente"),
            @ApiResponse(responseCode  = "404", description = "Não foi encontrado na lista um tênis com tal id"),
            @ApiResponse(responseCode  = "500", description = "O servidor apresentou algum erro ao tentar realizar a ação")
    })
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Tenis tenis){
        try {
            tenisService.update(id, tenis);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(String.format("Tenis %s atualizado!", tenis.getId()));
        } catch (MalformedParametersException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        } catch (OpenApiResourceNotFoundException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }

    @Operation(summary = "Deleta uma tênis da lista")
    @ApiResponses(value = {
        @ApiResponse(responseCode  = "202", description = "O Tênis com id desejado foi removido com sucesso"),
        @ApiResponse(responseCode  = "400", description = "Algum parâmetro informado não foi preenchido corretamente"),
        @ApiResponse(responseCode  = "404", description = "Não foi encontrado na lista um tênis com tal id"),
        @ApiResponse(responseCode  = "500", description = "O servidor apresentou algum erro ao tentar realizar a ação")
    })
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        try {
            tenisService.delete(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(String.format("Tenis %s removido!", id));
        } catch (MalformedParametersException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        } catch (OpenApiResourceNotFoundException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }
}
