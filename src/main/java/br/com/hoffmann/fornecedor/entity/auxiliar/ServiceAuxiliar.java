package br.com.hoffmann.fornecedor.entity.auxiliar;

import br.com.hoffmann.fornecedor.domain.request.FornecedorRequest;
import br.com.hoffmann.fornecedor.entity.Fornecedor;
import br.com.hoffmann.fornecedor.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.NonUniqueResultException;
import java.util.Optional;

import static java.lang.String.format;

@Component
public class ServiceAuxiliar {

    @Autowired
    FornecedorRepository fornecedorRepository;

    public void criaFornecedor(FornecedorRequest request) {

        Fornecedor fornecedor = new Fornecedor();

        fornecedor.setNome(request.getNome());
        fornecedor.setDescricao(request.getDescricao());
        fornecedor.setCnpj(request.getCnpj());
        fornecedor.setEstado(request.getEstado());
        fornecedor.setSigla(request.getSigla());
        fornecedor.setCidade(request.getCidade());
        fornecedor.setRua(request.getRua());
        fornecedor.setNumero(request.getNumero());
        fornecedor.setBairro(request.getBairro());
        fornecedor.setCep(request.getCep());
        fornecedor.setComplemento(request.getComplemento());
        fornecedor.setTelefone(request.getTelefone());
        fornecedor.setCelular(request.getCelular());
        fornecedor.setEmail(request.getEmail());

        fornecedorRepository.save(fornecedor);
    }

    public void atualizaFornecedor(FornecedorRequest request, Fornecedor fornecedor) {

        fornecedor.setNome(request.getNome());
        fornecedor.setDescricao(request.getDescricao());
        fornecedor.setCnpj(request.getCnpj());
        fornecedor.setEstado(request.getEstado());
        fornecedor.setSigla(request.getSigla());
        fornecedor.setCidade(request.getCidade());
        fornecedor.setRua(request.getRua());
        fornecedor.setNumero(request.getNumero());
        fornecedor.setBairro(request.getBairro());
        fornecedor.setCep(request.getCep());
        fornecedor.setComplemento(request.getComplemento());
        fornecedor.setTelefone(request.getTelefone());
        fornecedor.setCelular(request.getCelular());
        fornecedor.setEmail(request.getEmail());

        fornecedorRepository.save(fornecedor);
    }

    public void validaFornecedor(FornecedorRequest request) {

        Optional<Fornecedor> validaCnpj = fornecedorRepository.findFornecedorByCnpj(request.getCnpj());
        Optional<Fornecedor> validaTelefone = fornecedorRepository.findFornecedorByTelefone(request.getTelefone());
        Optional<Fornecedor> validaCelular = fornecedorRepository.findFornecedorByCelular(request.getCelular());
        Optional<Fornecedor> validaEmail = fornecedorRepository.findFornecedorByEmail(request.getEmail());

        if (validaCnpj.isPresent()) {
            throw new NonUniqueResultException(format("CNPJ [%s] já existe na nossa base de dados", request.getCnpj()));
        } else if (validaTelefone.isPresent()) {
            throw new NonUniqueResultException(format("TELEFONE [%s] já existe na nossa base de dados", request.getTelefone()));
        } else if (validaCelular.isPresent()) {
            throw new NonUniqueResultException(format("CELULAR [%s] já existe na nossa base de dados", request.getCelular()));
        } else if (validaEmail.isPresent()) {
            throw new NonUniqueResultException(format("EMAIL [%s] já existe na nossa base de dados", request.getEmail()));
        }
    }

    public void validaUpdate(FornecedorRequest request, Long id) {

        Optional<Fornecedor> validaCnpj = fornecedorRepository.findFornecedorByCnpj(request.getCnpj());
        Optional<Fornecedor> validaTelefone = fornecedorRepository.findFornecedorByTelefone(request.getTelefone());
        Optional<Fornecedor> validaCelular = fornecedorRepository.findFornecedorByCelular(request.getCelular());
        Optional<Fornecedor> validaEmail = fornecedorRepository.findFornecedorByEmail(request.getEmail());

        if (validaCnpj.isPresent() && !validaCnpj.get().getFornecedorID().equals(id)) {
            throw new NonUniqueResultException(format("CNPJ [%s] já existe na nossa base de dados", request.getCnpj()));
        } else if (validaTelefone.isPresent() && !validaTelefone.get().getFornecedorID().equals(id)) {
            throw new NonUniqueResultException(format("TELEFONE [%s] já existe na nossa base de dados", request.getTelefone()));
        } else if (validaCelular.isPresent() && !validaCelular.get().getFornecedorID().equals(id)) {
            throw new NonUniqueResultException(format("CELULAR [%s] já existe na nossa base de dados", request.getCelular()));
        } else if (validaEmail.isPresent() && !validaEmail.get().getFornecedorID().equals(id)) {
            throw new NonUniqueResultException(format("EMAIL [%s] já existe na nossa base de dados", request.getEmail()));
        }
    }
}
