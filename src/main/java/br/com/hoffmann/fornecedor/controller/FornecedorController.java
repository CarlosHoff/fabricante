package br.com.hoffmann.fornecedor.controller;


import br.com.hoffmann.fornecedor.domain.request.FornecedorRequest;
import br.com.hoffmann.fornecedor.domain.response.FornecedorResponse;
import br.com.hoffmann.fornecedor.service.FornecedorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;


@Api(value = "Cadastro de Fornecedores - endPoints API", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
@Validated
@RequestMapping(path = "/v1/fornecedor")
public class FornecedorController {

    @Autowired
    FornecedorService fornecedorService;

    @ApiOperation(value = "EndPoint para cadastro de Fornecedores")
    @RequestMapping(value = "/cadastraFornecedor", method = RequestMethod.POST)
    @Validated(FornecedorRequest.createRequest.class)
    public ResponseEntity<FornecedorResponse> cadastraFornecedor(
            @RequestBody @Valid FornecedorRequest request) {
        fornecedorService.createFornecedor(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "EndPoint para exclusão de Fornecedores")
    @RequestMapping(value = "/deletaFornecedor/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<FornecedorResponse> deletaFornecedor(
            @PathVariable(value = "id") @NotNull Long id) throws NotFoundException {
        fornecedorService.deletaFornecedor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "EndPoint para alteração de informações dos Fornecedores")
    @RequestMapping(value = "/updateFornecedor/{id}", method = RequestMethod.PUT)
    @Validated(FornecedorRequest.updateRequest.class)
    public ResponseEntity<FornecedorResponse> updateFornecedor(
            @PathVariable(value = "id") @NotNull Long id,
            @RequestBody @Valid FornecedorRequest request) throws NotFoundException {
        fornecedorService.updateFornecedor(request, id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "EndPoint para fazer a busca de Fornecedores")
    @RequestMapping(value = "/buscaFornecedores", method = RequestMethod.GET)
    public ResponseEntity<List<FornecedorResponse>> buscaFornecedores() {
        List<FornecedorResponse> response = fornecedorService.buscaFornecedores();
        return ResponseEntity.ok().body(response);
    }

    @ApiOperation(value = "EndPoint para fazer a busca de um fornecedor pelo CNPJ")
    @RequestMapping(value = "/buscaFornecedor/{cnpj}", method = RequestMethod.GET)
    public ResponseEntity<FornecedorResponse> buscaFornecedorPorCNPJ(@PathVariable(value = "cnpj") @NotNull String cnpj) throws NotFoundException {
        FornecedorResponse response = fornecedorService.buscaFornecedorPorCNPJ(cnpj);
        return ResponseEntity.ok().body(response);
    }
}
