package br.com.hoffmann.fornecedor.repository;


import br.com.hoffmann.fornecedor.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

    Optional<Fornecedor> findFornecedorByCnpj(String cnpj);

    Optional<Fornecedor> findFornecedorByTelefone(String telefone);

    Optional<Fornecedor> findFornecedorByCelular(String celular);

    Optional<Fornecedor> findFornecedorByEmail(String email);
}
