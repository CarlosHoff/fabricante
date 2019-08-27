package br.com.hoffmann.fabricante.service;


import br.com.hoffmann.fabricante.domain.request.CreateFabricanteRequest;
import br.com.hoffmann.fabricante.domain.request.UpdateFabricanteRequest;
import br.com.hoffmann.fabricante.domain.response.CreateFabricanteResponse;
import br.com.hoffmann.fabricante.domain.response.DeleteFabricanteResponse;
import br.com.hoffmann.fabricante.domain.response.FindFabricanteResponse;
import br.com.hoffmann.fabricante.domain.response.UpdateFabricanteResponse;
import br.com.hoffmann.fabricante.entity.Fabricante;
import br.com.hoffmann.fabricante.repository.FabricanteRepository;
import br.com.hoffmann.web.exceptions.NonUniqueResultException;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

@Service
@Transactional(value = "transactionManager")
public class FabricanteService {

    @Autowired
    FabricanteRepository fabricanteRepository;

    public void validaSeFabricanteJaExiste(CreateFabricanteRequest request) {

        Optional<Fabricante> validaCnpj = fabricanteRepository.findFabricanteByCnpj(request.getCnpj());

        Optional<Fabricante> validaTelefone = fabricanteRepository.findFabricanteByTelefone(request.getTelefone());

        Optional<Fabricante> validaCelular = fabricanteRepository.findFabricanteByCelular(request.getCelular());

        Optional<Fabricante> validaEmail = fabricanteRepository.findFabricanteByEmail(request.getEmail());

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

    // TODO METODO PARA CRIAR FABRICANTE
    public CreateFabricanteResponse createFabricante(CreateFabricanteRequest request) {

        validaSeFabricanteJaExiste(request);

        Fabricante fabricante = new Fabricante();

        fabricante.setNome(request.getNome());
        fabricante.setDescricao(request.getDescricao());
        fabricante.setCnpj(request.getCnpj());
        fabricante.setEstado(request.getEstado());
        fabricante.setSigla(request.getSigla());
        fabricante.setCidade(request.getCidade());
        fabricante.setRua(request.getRua());
        fabricante.setNumero(request.getNumero());
        fabricante.setBairro(request.getBairro());
        fabricante.setCep(request.getCep());
        fabricante.setComplemento(request.getComplemento());
        fabricante.setTelefone(request.getTelefone());
        fabricante.setCelular(request.getCelular());
        fabricante.setEmail(request.getEmail());

        Fabricante idGerado = fabricanteRepository.save(fabricante);

        CreateFabricanteResponse response = new CreateFabricanteResponse();

        response.setId(idGerado.getId());
        response.setMensagem("fabricante cadastrado com sucesso.");

        return response;
    }

    // TODO METODO PARA DELETAR FABRICANTE
    public DeleteFabricanteResponse deletaFabricante(Long id) {

        Optional<Fabricante> fabricante = fabricanteRepository.findById(id);

        if (!fabricante.isPresent()) {
            throw new br.com.hoffmann.web.exceptions.NotFoundException(format("ID [%s] não existente em nossa base", id));
        }

        fabricanteRepository.deleteById(id);

        DeleteFabricanteResponse response = new DeleteFabricanteResponse();
        response.setMensagem("fabricante deletado");

        return response;

    }

    public void validaUpdate(UpdateFabricanteRequest request, Long id) {

        Optional<Fabricante> validaCnpj = fabricanteRepository.findFabricanteByCnpj(request.getCnpj());

        Optional<Fabricante> validaTelefone = fabricanteRepository.findFabricanteByTelefone(request.getTelefone());

        Optional<Fabricante> validaCelular = fabricanteRepository.findFabricanteByCelular(request.getCelular());

        Optional<Fabricante> validaEmail = fabricanteRepository.findFabricanteByEmail(request.getEmail());

        if (validaCnpj.isPresent() && !validaCnpj.get().getId().equals(id)) {
            throw new NonUniqueResultException(format("CNPJ [%s] já existe na nossa base de dados", request.getCnpj()));
        } else if (validaTelefone.isPresent() && !validaTelefone.get().getId().equals(id)) {
            throw new NonUniqueResultException(format("TELEFONE [%s] já existe na nossa base de dados", request.getTelefone()));
        } else if (validaCelular.isPresent() && !validaCelular.get().getId().equals(id)) {
            throw new NonUniqueResultException(format("CELULAR [%s] já existe na nossa base de dados", request.getCelular()));
        } else if (validaEmail.isPresent() && !validaEmail.get().getId().equals(id)) {
            throw new NonUniqueResultException(format("EMAIL [%s] já existe na nossa base de dados", request.getEmail()));
        }
    }

    // TODO METODO PARA ALTERAR FABRICANTE
    public UpdateFabricanteResponse updateFabricante(UpdateFabricanteRequest request, Long id) throws NotFoundException {

        Optional<Fabricante> fabricanteOptional = fabricanteRepository.findById(id);

        validaUpdate(request, id);

        if (!fabricanteOptional.isPresent()) {
            throw new NotFoundException(format("[%s] não encontrado", id));
        }

        Fabricante fabricanteUpdate = fabricanteOptional.get();

        fabricanteUpdate.setNome(request.getNome());
        fabricanteUpdate.setDescricao(request.getDescricao());
        fabricanteUpdate.setCnpj(request.getCnpj());
        fabricanteUpdate.setEstado(request.getEstado());
        fabricanteUpdate.setSigla(request.getSigla());
        fabricanteUpdate.setCidade(request.getCidade());
        fabricanteUpdate.setRua(request.getRua());
        fabricanteUpdate.setNumero(request.getNumero());
        fabricanteUpdate.setBairro(request.getBairro());
        fabricanteUpdate.setCep(request.getCep());
        fabricanteUpdate.setComplemento(request.getComplemento());
        fabricanteUpdate.setTelefone(request.getTelefone());
        fabricanteUpdate.setCelular(request.getCelular());
        fabricanteUpdate.setEmail(request.getEmail());

        fabricanteRepository.save(fabricanteUpdate);

        UpdateFabricanteResponse response = new UpdateFabricanteResponse();
        response.setMensagem("Alterado com Sucesso");

        return response;
    }

    // TODO METODO PARA BUSCAR CIDADE - ESTADO - SIGLA
    public List<FindFabricanteResponse> buscaFabricante() {

        List<Fabricante> fabricantes = fabricanteRepository.findAll();

        List<FindFabricanteResponse> fabricanteListResponse = new ArrayList<>();

        for (Fabricante f : fabricantes) {

            FindFabricanteResponse response = new FindFabricanteResponse();

            response.setId(f.getId());
            response.setNome(f.getNome());
            response.setDescricao(f.getDescricao());
            response.setCnpj(f.getCnpj());
            response.setEstado(f.getEstado());
            response.setSigla(f.getSigla());
            response.setCidade(f.getCidade());
            response.setRua(f.getRua());
            response.setNumero(f.getNumero());
            response.setBairro(f.getBairro());
            response.setCep(f.getCep());
            response.setComplemento(f.getComplemento());
            response.setTelefone(f.getTelefone());
            response.setCelular(f.getCelular());
            response.setEmail(f.getEmail());

            fabricanteListResponse.add(response);
        }
        return fabricanteListResponse;
    }
}