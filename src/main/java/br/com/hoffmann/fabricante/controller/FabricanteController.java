package br.com.hoffmann.fabricante.controller;


import br.com.hoffmann.fabricante.client.PessoaClient;
import br.com.hoffmann.fabricante.domain.request.CreateFabricanteRequest;
import br.com.hoffmann.fabricante.domain.request.UpdateFabricanteRequest;
import br.com.hoffmann.fabricante.domain.response.*;
import br.com.hoffmann.fabricante.service.FabricanteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Response;
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


@Api(value = "Cadastro de Fabricantes - endPoints API", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
@Validated
@RequestMapping(path = "/v1/fabricante")
public class FabricanteController {

    @Autowired
    FabricanteService fabricanteService;

    @Autowired
    PessoaClient pessoaClient;

    @ApiOperation(value = "EndPoint para cadastro de Fabricantes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso"),
            @ApiResponse(code = 400, message = "Dados invalidos"),
            @ApiResponse(code = 409, message = "Conflito")})
    @RequestMapping(value = "/cadastraFabricante", method = RequestMethod.POST)
    public ResponseEntity<CreateFabricanteResponse> cadastraPessoa (
            @RequestBody @Valid CreateFabricanteRequest request){

        CreateFabricanteResponse response = fabricanteService.createFabricante(request);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @ApiOperation(value = "EndPoint para exclusão de Fabricantes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso"),
            @ApiResponse(code = 400, message = "Id invalido")})
    @RequestMapping(value = "/deletaFabricante/{id}", method = RequestMethod.DELETE)
    public DeleteFabricanteResponse deletaFabricante (
            @PathVariable(value = "id") @NotNull Long id){

        DeleteFabricanteResponse response = fabricanteService.deletaFabricante(id);

        return response;
    }

    @ApiOperation(value = "EndPoint para alteração de informações dos Fabricantes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso"),
            @ApiResponse(code = 400, message = "Dados invalidos"),
            @ApiResponse(code = 404, message = "Registro não encontrado"),
            @ApiResponse(code = 409, message = "Conflito")})
    @RequestMapping(value = "/updateFabricante/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UpdateFabricanteResponse> updatePessoa (
            @PathVariable(value = "id") @NotNull Long id,
            @RequestBody @Valid UpdateFabricanteRequest request) throws NotFoundException {

        UpdateFabricanteResponse response = fabricanteService.updateFabricante(request, id);

        return ResponseEntity.ok().body(response);
    }

    @ApiOperation(value = "EndPoint para fazer a busca de Fabricantes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso"),
            @ApiResponse(code = 404, message = "Registro não encontrado"),
            @ApiResponse(code = 422, message = "Indisponivel")})
    @RequestMapping(value = "/buscaFabricantes", method = RequestMethod.GET)
    public ResponseEntity<List<FindFabricanteResponse>> buscaFabricantes () {

        List<FindFabricanteResponse> response = fabricanteService.buscaFabricante();

        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(value = "/buscaPessoa/{id}", method = RequestMethod.GET)
    public ResponseEntity<PessoaResponse> buscarPessoa(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok().body(pessoaClient.getPessoa(id));
    }
}
