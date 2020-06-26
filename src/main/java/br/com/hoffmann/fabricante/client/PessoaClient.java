package br.com.hoffmann.fabricante.client;

import br.com.hoffmann.fabricante.domain.response.PessoaResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "http://localhost:8081/v1/pessoa", name = "PessoaClient")
public interface PessoaClient {

    @RequestMapping(value = "/buscaPessoa/{id}", method = RequestMethod.GET)
    public PessoaResponse getPessoa(@PathVariable(value = "id") Long id);
}