package service;

import model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProdutoService {

    Produto salvar(Produto produto);

    void excluir(Long idProduto);

    Page<Produto> listar(String filtro, Pageable pageable);

    Produto getId(Long id);

    boolean isEmpty();

    void salvarLista(List<Produto> produtos);
}
