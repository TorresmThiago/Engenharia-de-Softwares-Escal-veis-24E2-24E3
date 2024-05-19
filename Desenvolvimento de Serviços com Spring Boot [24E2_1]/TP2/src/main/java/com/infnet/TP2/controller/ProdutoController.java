package com.infnet.TP2.controller;
import com.infnet.TP2.domain.Produto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    int idUnico = 0;

    int getUniqueId()
    {
        return idUnico++;
    }


    List<Produto> listaProdutos = new ArrayList<>();

    @GetMapping(value = "/listar")
    public List<Produto> listarProdutos() {
        return listaProdutos;
    }

    @GetMapping(value = "/listar/{id}")
    public Produto listarProduto(@PathVariable int id){
        for (int i = 0; i < listaProdutos.size(); i++) {
            if (listaProdutos.get(i).getId() == id){
                return listaProdutos.get(i);
            }
        }
        return null;
    }

    @PostMapping(value = "/adicionar")
    public String adicionarProduto(@RequestBody Map<String, String> requestParams) {
        Produto produto = new Produto(getUniqueId(), requestParams.get("nome"), Double.parseDouble(requestParams.get("valor")));
        listaProdutos.add(produto);
        return "Produto adicionado com sucesso!";
    }

    @PutMapping(value = "/atualizar/{id}")
    public String atualizarProduto(@PathVariable int id, @RequestBody Produto produto){
        for (int i = 0; i < listaProdutos.size(); i++) {
            if (listaProdutos.get(i).getId() == id){
                if (produto.getNome() != null)
                    listaProdutos.get(i).setNome(produto.getNome());

                if (produto.getValor() > 0)
                    listaProdutos.get(i).setValor(produto.getValor());
            }

            return "Produto atualizado com sucesso!";
        }
        return "Produto não encontrado";
    }

    @DeleteMapping(value = "/remover/{id}")
    public String removerProduto(@PathVariable int id) {
        for (int i = 0; i < listaProdutos.size(); i++) {
            if (listaProdutos.get(i).getId() == id){
                listaProdutos.remove(i);
                return "Produto removido com sucesso!";
            }
        }
        return "Produto não encontrado";
    }

}
