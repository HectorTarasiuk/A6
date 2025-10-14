import java.time.LocalDate;

public class ClientePF extends Cliente {
    private String cpf;
    private LocalDate dataNascimento;

    public ClientePF(String nome, String email, String cpf) {
        super(nome, email);
        this.cpf = cpf;
    }

    public String getCPF() {
        return cpf;
    }

    @Override
    public String getIdentificadorUnico() {
        return cpf;
    }
}
