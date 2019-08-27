package br.com.hoffmann.fabricante.repository;


import br.com.hoffmann.fabricante.entity.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {

    Optional<Fabricante>findFabricanteByCnpj(String cnpj);

    Optional<Fabricante>findFabricanteByTelefone(String telefone);

    Optional<Fabricante>findFabricanteByCelular(String celular);

    Optional<Fabricante>findFabricanteByEmail(String email);

}
