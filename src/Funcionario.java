import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * REQUISITO 2: Classe Funcionário que estenda a classe Pessoa, 
 * com os atributos: salário (BigDecimal) e função (String).
 * 
 * Esta classe implementa exatamente o que foi solicitado:
 * - Estende Pessoa (herança) ✓
 * - Atributo salário do tipo BigDecimal ✓  
 * - Atributo função do tipo String ✓
 */
public class Funcionario extends Pessoa {
    // REQUISITO 2: Atributo salário (BigDecimal) - usado para valores monetários precisos
    private BigDecimal salario;
    
    // REQUISITO 2: Atributo função (String) - armazena o cargo do funcionário
    private String funcao;
    
    /**
     * Construtor que recebe todos os dados necessários para criar um funcionário.
     * 
     * IMPLEMENTAÇÃO DOS REQUISITOS:
     * - Herda nome e dataNascimento da classe Pessoa (super)
     * - Inicializa salário como BigDecimal (conforme requisito 2)
     * - Inicializa função como String (conforme requisito 2)
     * 
     * @param nome Nome do funcionário (herdado de Pessoa)
     * @param dataNascimento Data de nascimento (herdado de Pessoa) 
     * @param salario Salário em BigDecimal para precisão monetária
     * @param funcao Função/cargo do funcionário
     */
    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        // Chama o construtor da classe pai (Pessoa) para inicializar nome e dataNascimento
        super(nome, dataNascimento);
        
        // Inicializa os atributos específicos de Funcionario
        this.salario = salario;
        this.funcao = funcao;
    }
    
    // Getters e Setters
    public BigDecimal getSalario() {
        return salario;
    }
    
    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
    
    public String getFuncao() {
        return funcao;
    }
    
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    
    @Override
    public String toString() {
        return "Nome: " + getNome() + 
               ", Data Nascimento: " + getDataNascimento() + 
               ", Salário: " + salario + 
               ", Função: " + funcao;
    }
}
