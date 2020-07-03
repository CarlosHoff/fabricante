package br.com.hoffmann.fornecedor.service;


import br.com.hoffmann.fornecedor.domain.request.FornecedorRequest;
import br.com.hoffmann.fornecedor.domain.response.FornecedorResponse;
import br.com.hoffmann.fornecedor.entity.Fornecedor;
import br.com.hoffmann.fornecedor.entity.auxiliar.ServiceAuxiliar;
import br.com.hoffmann.fornecedor.repository.FornecedorRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@Transactional(value = "transactionManager")
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private ServiceAuxiliar auxiliar;

    public void createFornecedor(FornecedorRequest request) {
        auxiliar.validaFornecedor(request);
        auxiliar.criaFornecedor(request);
    }

    public void deletaFornecedor(Long id) throws NotFoundException {
        Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
        if (!fornecedor.isPresent()) {
            throw new NotFoundException(format("ID [%s] não existente em nossa base", id));
        }
        fornecedorRepository.deleteById(id);
    }

    public void updateFornecedor(FornecedorRequest request, Long id) throws NotFoundException {
        Optional<Fornecedor> fornecedorOptional = fornecedorRepository.findById(id);
        auxiliar.validaUpdate(request, id);
        if (!fornecedorOptional.isPresent()) {
            throw new NotFoundException(format("[%s] não encontrado", id));
        }
        Fornecedor fornecedor = fornecedorOptional.get();
        auxiliar.atualizaFornecedor(request, fornecedor);
    }

    public List<FornecedorResponse> buscaFornecedores() {
        List<Fornecedor> fornecedores = fornecedorRepository.findAll();
        return fornecedores.stream().map(FornecedorResponse::new).collect(Collectors.toList());
    }

    public FornecedorResponse buscaFornecedorPorCNPJ(String cnpj) throws NotFoundException {
        Optional<Fornecedor> response = fornecedorRepository.findFornecedorByCnpj(cnpj);
        if (!response.isPresent()) {
            throw new NotFoundException(format("Fornecedor com o CNPJ: [%s] não foi encontrado", cnpj));
        }
        Fornecedor fornecedor = response.get();
        return new FornecedorResponse(fornecedor);
    }
}