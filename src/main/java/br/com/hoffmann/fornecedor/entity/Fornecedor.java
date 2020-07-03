package br.com.hoffmann.fornecedor.entity;

import br.com.hoffmann.fornecedor.domain.request.FornecedorRequest;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table(name = "FORNECEDOR")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SQ_FORNECEDOR")
    @SequenceGenerator(sequenceName = "SQ_FORNECEDOR", allocationSize = 1, name = "SQ_FORNECEDOR")
    @Column(name = "ID")
    private Long fornecedorID;

    @Column(name = "NOME", length = 50, nullable = false)
    private String nome;

    @Column(name = "DESCRICAO", length = 50, nullable = false)
    private String descricao;

    @Column(name = "CNPJ", length = 18, nullable = false)
    private String cnpj;

    @Column(length = 30, nullable = false, name = "ESTADO")
    private String estado;

    @Column(length = 2, nullable = false, name = "SIGLA")
    private String sigla;

    @Column(length = 50, nullable = false, name = "CIDADE")
    private String cidade;

    @Column(length = 100, nullable = false, name = "RUA")
    private String rua;

    @Column(nullable = false, name = "NUMERO")
    private int numero;

    @Column(length = 30, nullable = false, name = "BAIRRO")
    private String bairro;

    @Column(length = 10, nullable = false, name = "CEP")
    private String cep;

    @Column(length = 20, nullable = false, name = "COMPLEMENTO")
    private String complemento;

    @Column(length = 10, nullable = false, name = "TELEFONE")
    private String telefone;

    @Column(length = 11, nullable = false, name = "CELULAR")
    private String celular;

    @Column(length = 100, nullable = false, name = "EMAIL")
    private String email;

}
