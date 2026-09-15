import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pessoa {
    private String nome;
    private int idade;
    private String cpf;
    private String telefone;
    private String profissão;
    private List<Endereco> enderecos;

    public Pessoa(String nome, int idade, String cpf, String telefone, String profissão) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.telefone = telefone;
        this.profissão = profissão;
        this.enderecos = new ArrayList<>();
    }

    public boolean existeEndereco(String rua, String bairro, String cep, int numero, String cidade) {
        for (Endereco e : enderecos) {
            if (e.enderecoGemeo(rua, bairro, numero, cep, cidade)) {
                return true;
            }
        }
        return false;
    }

    public void cadastraEndereco(String rua, String bairro, String cep, int numero, String cidade) {
        if (existeEndereco(rua, bairro, cep, numero, cidade)) {
            throw new IllegalArgumentException("Endereço existente");
        }

        this.enderecos.add(new Endereco(rua, bairro, numero, cep, cidade));
    }

    public void deletarEndereco(int id) {
        Endereco endRemover = null;

        for (Endereco e : this.enderecos) {
            if (e.getId() == id) {
                endRemover = e;
                break;
            }
        }

        if (endRemover == null) {
            throw new IllegalArgumentException("Endereço Inexistente");
        }

        this.enderecos.remove(endRemover);
    }

    public String showEnderecos() {
        return this.enderecos.toString();
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getProfissão() {
        return profissão;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setProfissao(String profissão) {
        this.profissão = profissão;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(cpf, pessoa.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", profissão='" + profissão +
                '}';
    }
}