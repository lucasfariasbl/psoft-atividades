import java.util.HashMap;
import java.util.Map;

public class PessoaController {

    private Map<String, Pessoa> listaUsers;

    public PessoaController() {
        this.listaUsers = new HashMap<>();
    }

    public void cadastraPessoa(String nome, int idade, String cpf, String telefone, String profissão) {
        if (this.listaUsers.containsKey(cpf)) {
            throw new IllegalArgumentException("Pessoa já cadastrada");
        }

        this.listaUsers.put(cpf, new Pessoa(nome, idade, cpf, telefone, profissão));
    }

    public Pessoa buscaPessoa(String cpf) {
        return this.listaUsers.get(cpf);
    }

    public void deletaPessoa(String cpf) {
        if (!existePessoa(cpf)) {
            throw new IllegalArgumentException("Pessoa não encontrada");
        }

        this.listaUsers.remove(cpf);
    }

    public boolean existePessoa(String cpf) {
        return this.listaUsers.containsKey(cpf);
    }

    public void atualizaIdade(String cpf, int novaIdade) {
        if (!existePessoa(cpf)) {
            throw new IllegalArgumentException("Pessoa não encontrada");
        }

        this.listaUsers.get(cpf).setIdade(novaIdade);
    }

    public void atualizaTelefone(String cpf, String novoTelefone) {
        if (!existePessoa(cpf)) {
            throw new IllegalArgumentException("Pessoa não encontrada");
        }

        this.listaUsers.get(cpf).setTelefone(novoTelefone);
    }

    public void atualizaProfissao(String cpf, String profissao) {
        if (!existePessoa(cpf)) {
            throw new IllegalArgumentException("Pessoa não encontrada");
        }

        this.listaUsers.get(cpf).setProfissao(profissao);
    }

    public void adicionaEndereco(String cpf, String rua, String bairro, String cep, int numero, String cidade) {
        if (!existePessoa(cpf)) {
            throw new IllegalArgumentException("Pessoa não encontrada");
        }

        this.listaUsers.get(cpf).cadastraEndereco(rua, bairro, cep, numero, cidade);
    }

    public void removeEndereco(String cpf, int idEndereco) {
        if (!existePessoa(cpf)) {
            throw new IllegalArgumentException("Pessoa não encontrada");
        }

        this.listaUsers.get(cpf).deletarEndereco(idEndereco);
    }

    public String showEnderecos(String cpf) {
        if (!existePessoa(cpf)) {
            throw new IllegalArgumentException("Pessoa não encontrada");
        }

        return this.listaUsers.get(cpf).showEnderecos();
    }
}
