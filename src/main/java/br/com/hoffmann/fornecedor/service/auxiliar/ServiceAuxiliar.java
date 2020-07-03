package br.com.hoffmann.fornecedor.service.auxiliar;

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

    private final String CNPJ_EXISTENTE = "CNPJ [%s] já existe na nossa base de dados";
    private final String TELEFONE_EXISTENTE = "TELEFONE [%s] já existe na nossa base de dados";
    private final String CELULAR_EXISTENTE = "CELULAR [%s] já existe na nossa base de dados";
    private final String EMAIL_EXISTENTE = "EMAIL [%s] já existe na nossa base de dados";

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

        Optional<Fornecedor> validaCnpj = validaCnpj(request);
        Optional<Fornecedor> validaTelefone = validaTelefone(request);
        Optional<Fornecedor> validaCelular = validaCelular(request);
        Optional<Fornecedor> validaEmail = validaEmail(request);

        if (validaCnpj.isPresent()) {
            throw new NonUniqueResultException(format(CNPJ_EXISTENTE, request.getCnpj()));
        } else if (validaTelefone.isPresent()) {
            throw new NonUniqueResultException(format(TELEFONE_EXISTENTE, request.getTelefone()));
        } else if (validaCelular.isPresent()) {
            throw new NonUniqueResultException(format(CELULAR_EXISTENTE, request.getCelular()));
        } else if (validaEmail.isPresent()) {
            throw new NonUniqueResultException(format(EMAIL_EXISTENTE, request.getEmail()));
        }
    }

    public void validaUpdate(FornecedorRequest request, Long id) {

        Optional<Fornecedor> validaCnpj = validaCnpj(request);
        Optional<Fornecedor> validaTelefone = validaTelefone(request);
        Optional<Fornecedor> validaCelular = validaCelular(request);
        Optional<Fornecedor> validaEmail = validaEmail(request);

        if (validaCnpj.isPresent() && !validaCnpj.get().getFornecedorID().equals(id)) {
            throw new NonUniqueResultException(format(CNPJ_EXISTENTE, request.getCnpj()));
        } else if (validaTelefone.isPresent() && !validaTelefone.get().getFornecedorID().equals(id)) {
            throw new NonUniqueResultException(format(TELEFONE_EXISTENTE, request.getTelefone()));
        } else if (validaCelular.isPresent() && !validaCelular.get().getFornecedorID().equals(id)) {
            throw new NonUniqueResultException(format(CELULAR_EXISTENTE, request.getCelular()));
        } else if (validaEmail.isPresent() && !validaEmail.get().getFornecedorID().equals(id)) {
            throw new NonUniqueResultException(format(EMAIL_EXISTENTE, request.getEmail()));
        }
    }

    private Optional<Fornecedor> validaCnpj(FornecedorRequest request){
        return fornecedorRepository.findFornecedorByCnpj(request.getCnpj());
    }

    private Optional<Fornecedor> validaTelefone(FornecedorRequest request){
        return fornecedorRepository.findFornecedorByTelefone(request.getTelefone());
    }

    private Optional<Fornecedor> validaCelular(FornecedorRequest request){
        return fornecedorRepository.findFornecedorByCelular(request.getCelular());
    }

    private Optional<Fornecedor> validaEmail(FornecedorRequest request){
        return fornecedorRepository.findFornecedorByEmail(request.getEmail());
    }
}
