import java.time.LocalDate;

/**
 * REQUISITO 1: Classe Pessoa com os atributos: nome (String) e data nascimento (LocalDate).
 * 
 * Esta classe implementa exatamente o que foi solicitado:
 * - Atributo nome do tipo String ✓
 * - Atributo dataNascimento do tipo LocalDate ✓
 * - Encapsulamento com private e getters/setters ✓
 */
public class Pessoa {
    // REQUISITO 1: Atributo nome (String) - armazena o nome da pessoa
    private String nome;
    
    // REQUISITO 1: Atributo data nascimento (LocalDate) - armazena a data de nascimento
    private LocalDate dataNascimento;
    
    /**
     * Construtor da classe Pessoa.
     * 
     * IMPLEMENTAÇÃO DO REQUISITO 1:
     * - Recebe nome como String (conforme solicitado)
     * - Recebe dataNascimento como LocalDate (conforme solicitado)
     * - Inicializa os atributos da classe base
     * 
     * @param nome Nome da pessoa (String)
     * @param dataNascimento Data de nascimento (LocalDate)
     */
    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
    
    // Getters e Setters - Métodos para acessar e modificar os atributos privados
    
    /**
     * Getter para o nome.
     * @return String com o nome da pessoa
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Setter para o nome.
     * @param nome Novo nome para a pessoa
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * Getter para a data de nascimento.
     * @return LocalDate com a data de nascimento
     */
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    
    /**
     * Setter para a data de nascimento.
     * @param dataNascimento Nova data de nascimento
     */
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    @Override
    public String toString() {
        return "Nome: " + nome + ", Data Nascimento: " + dataNascimento;
    }
}
