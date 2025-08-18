import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * REQUISITO 3: Classe Principal para executar as seguintes ações conforme especificado:
 * 
 * 3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela
 * 3.2 – Remover o funcionário "João" da lista
 * 3.3 – Imprimir todos os funcionários com formatação específica
 * 3.4 – Aplicar 10% de aumento de salário
 * 3.5 – Agrupar funcionários por função em um MAP
 * 3.6 – Imprimir funcionários agrupados por função
 * 3.8 – Imprimir funcionários que fazem aniversário no mês 10 e 12
 * 3.9 – Imprimir funcionário com maior idade
 * 3.10 – Imprimir lista por ordem alfabética
 * 3.11 – Imprimir total dos salários
 * 3.12 – Imprimir salários em múltiplos do salário mínimo
 */
public class Principal {
    // REQUISITO 3.12: Salário mínimo definido como R$ 1212.00
    private static final BigDecimal SALARIO_MINIMO = new BigDecimal("1212.00");
    
    // REQUISITO 3.3: Formatação de data no padrão dd/MM/aaaa
    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    // REQUISITO 3.3: Formatação monetária brasileira (separador de milhar como ponto e decimal como vírgula)
    private static final NumberFormat FORMATO_MOEDA = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
    
    // REQUISITO 3.3: Formatação numérica brasileira
    private static final NumberFormat FORMATO_NUMERO = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
    
    public static void main(String[] args) {
        // Ponto de entrada do programa - inicia a execução de todos os requisitos
        Principal principal = new Principal();
        principal.executar();
    }
    
    /**
     * Método principal que executa todos os requisitos solicitados na ordem especificada.
     * Cada requisito está claramente identificado e implementado conforme solicitado.
     */
    public void executar() {
        // REQUISITO 3.1 - Inserir todos os funcionários conforme tabela fornecida
        List<Funcionario> funcionarios = inserirFuncionarios();
        
        // REQUISITO 3.2 - Remover o funcionário "João" da lista
        funcionarios.removeIf(f -> f.getNome().equals("João"));
        System.out.println("=== REQUISITO 3.2: Funcionário João removido da lista ===\n");
        
        // REQUISITO 3.3 - Imprimir todos os funcionários com formatação específica
        imprimirFuncionarios(funcionarios, "REQUISITO 3.3: LISTA DE FUNCIONÁRIOS");
        
        // REQUISITO 3.4 - Aplicar 10% de aumento de salário para todos os funcionários
        aplicarAumento(funcionarios, new BigDecimal("0.10"));
        imprimirFuncionarios(funcionarios, "REQUISITO 3.4: FUNCIONÁRIOS APÓS AUMENTO DE 10%");
        
        // REQUISITO 3.5 e 3.6 - Agrupar funcionários por função em MAP e imprimir agrupados
        Map<String, List<Funcionario>> funcionariosPorFuncao = agruparPorFuncao(funcionarios);
        imprimirFuncionariosPorFuncao(funcionariosPorFuncao);
        
        // REQUISITO 3.8 - Imprimir funcionários que fazem aniversário no mês 10 e 12
        imprimirAniversariantes(funcionarios, Arrays.asList(10, 12));
        
        // REQUISITO 3.9 - Imprimir funcionário com maior idade (nome e idade)
        imprimirFuncionarioMaisVelho(funcionarios);
        
        // REQUISITO 3.10 - Imprimir lista de funcionários por ordem alfabética
        imprimirFuncionariosOrdemAlfabetica(funcionarios);
        
        // REQUISITO 3.11 - Imprimir o total dos salários dos funcionários
        imprimirTotalSalarios(funcionarios);
        
        // REQUISITO 3.12 - Imprimir quantos salários mínimos ganha cada funcionário
        imprimirSalariosMinimos(funcionarios);
    }
    
    /**
     * REQUISITO 3.1: Inserir todos os funcionários conforme tabela fornecida,
     * na mesma ordem e informações especificadas.
     * 
     * @return Lista com todos os funcionários criados conforme dados da tabela
     */
    private List<Funcionario> inserirFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        
        // REQUISITO 3.1: Inserindo todos os funcionários conforme tabela fornecida, na mesma ordem
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));
        
        System.out.println("=== REQUISITO 3.1: Funcionários inseridos conforme tabela fornecida ===\n");
        return funcionarios;
    }
    
    /**
     * REQUISITO 3.3: Imprime todos os funcionários com formatação específica:
     * - Data no formato dd/MM/aaaa
     * - Valor numérico com separador de milhar como ponto e decimal como vírgula
     * 
     * @param funcionarios Lista de funcionários para imprimir
     * @param titulo Título para a seção de impressão
     */
    private void imprimirFuncionarios(List<Funcionario> funcionarios, String titulo) {
        System.out.println("=== " + titulo + " ===");
        for (Funcionario funcionario : funcionarios) {
            // REQUISITO 3.3: Formatação específica - data dd/MM/aaaa e valores com separadores brasileiros
            System.out.printf("Nome: %s, Data Nascimento: %s, Salário: %s, Função: %s%n",
                funcionario.getNome(),
                funcionario.getDataNascimento().format(FORMATO_DATA), // dd/MM/aaaa
                formatarMoeda(funcionario.getSalario()), // R$ x.xxx,xx (ponto=milhar, vírgula=decimal)
                funcionario.getFuncao());
        }
        System.out.println();
    }
    
    /**
     * REQUISITO 3.4: Aplica aumento salarial de 10% para todos os funcionários.
     * Utiliza BigDecimal para manter a precisão monetária.
     * 
     * @param funcionarios Lista de funcionários para aplicar o aumento
     * @param percentual Percentual de aumento (0.10 = 10%)
     */
    private void aplicarAumento(List<Funcionario> funcionarios, BigDecimal percentual) {
        for (Funcionario funcionario : funcionarios) {
            // Cálculo preciso: salário_atual * (1 + percentual)
            BigDecimal novoSalario = funcionario.getSalario()
                .multiply(BigDecimal.ONE.add(percentual)) // 1 + 0.10 = 1.10
                .setScale(2, RoundingMode.HALF_UP); // Arredonda para 2 casas decimais
            funcionario.setSalario(novoSalario);
        }
    }
    
    /**
     * REQUISITO 3.5: Agrupa funcionários por função em um Map.
     * Chave = função (String), Valor = lista de funcionários (List<Funcionario>)
     * 
     * @param funcionarios Lista de funcionários para agrupar
     * @return Map com funcionários agrupados por função
     */
    private Map<String, List<Funcionario>> agruparPorFuncao(List<Funcionario> funcionarios) {
        // Usa Streams API para agrupar por função de forma eficiente
        return funcionarios.stream()
            .collect(Collectors.groupingBy(Funcionario::getFuncao));
    }
    
    /**
     * REQUISITO 3.6: Imprime funcionários agrupados por função.
     * Mostra cada função e os funcionários que pertencem a ela.
     * 
     * @param funcionariosPorFuncao Map com funcionários agrupados por função
     */
    private void imprimirFuncionariosPorFuncao(Map<String, List<Funcionario>> funcionariosPorFuncao) {
        System.out.println("=== REQUISITO 3.5/3.6: FUNCIONÁRIOS AGRUPADOS POR FUNÇÃO ===");
        for (Map.Entry<String, List<Funcionario>> entrada : funcionariosPorFuncao.entrySet()) {
            System.out.println("Função: " + entrada.getKey()); // Chave = função
            for (Funcionario funcionario : entrada.getValue()) { // Valor = lista de funcionários
                System.out.printf("  - %s%n", funcionario.getNome());
            }
            System.out.println();
        }
    }
    
    /**
     * REQUISITO 3.8: Imprime funcionários que fazem aniversário nos meses 10 e 12.
     * Usa filter para selecionar apenas funcionários dos meses especificados.
     * 
     * @param funcionarios Lista de funcionários para verificar
     * @param meses Lista dos meses para filtrar (10 e 12)
     */
    private void imprimirAniversariantes(List<Funcionario> funcionarios, List<Integer> meses) {
        System.out.println("=== REQUISITO 3.8: FUNCIONÁRIOS QUE FAZEM ANIVERSÁRIO NOS MESES " + meses + " ===");
        funcionarios.stream()
            .filter(f -> meses.contains(f.getDataNascimento().getMonthValue())) // Filtra pelos meses 10 e 12
            .forEach(f -> System.out.printf("Nome: %s, Data Nascimento: %s%n",
                f.getNome(), f.getDataNascimento().format(FORMATO_DATA))); // Formato dd/MM/aaaa
        System.out.println();
    }
    
    /**
     * REQUISITO 3.9: Imprime funcionário com maior idade.
     * Exibe os atributos: nome e idade calculada.
     * 
     * @param funcionarios Lista de funcionários para analisar
     */
    private void imprimirFuncionarioMaisVelho(List<Funcionario> funcionarios) {
        System.out.println("=== REQUISITO 3.9: FUNCIONÁRIO COM MAIOR IDADE ===");
        // Encontra o funcionário com data de nascimento mais antiga (maior idade)
        Funcionario maisVelho = funcionarios.stream()
            .min(Comparator.comparing(Funcionario::getDataNascimento)) // Data mais antiga = idade maior
            .orElse(null);
        
        if (maisVelho != null) {
            // Calcula idade atual: diferença entre data de nascimento e hoje
            int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();
            // REQUISITO 3.9: Exibe nome e idade conforme solicitado
            System.out.printf("Nome: %s, Idade: %d anos%n", maisVelho.getNome(), idade);
        }
        System.out.println();
    }
    
    /**
     * REQUISITO 3.10: Imprime lista de funcionários por ordem alfabética.
     * Ordena pelo nome usando Comparator.
     * 
     * @param funcionarios Lista de funcionários para ordenar
     */
    private void imprimirFuncionariosOrdemAlfabetica(List<Funcionario> funcionarios) {
        System.out.println("=== REQUISITO 3.10: FUNCIONÁRIOS EM ORDEM ALFABÉTICA ===");
        funcionarios.stream()
            .sorted(Comparator.comparing(Funcionario::getNome)) // Ordena alfabeticamente por nome
            .forEach(f -> System.out.println("Nome: " + f.getNome()));
        System.out.println();
    }
    
    /**
     * REQUISITO 3.11: Imprime o total dos salários dos funcionários.
     * Soma todos os salários usando BigDecimal para precisão.
     * 
     * @param funcionarios Lista de funcionários para somar salários
     */
    private void imprimirTotalSalarios(List<Funcionario> funcionarios) {
        System.out.println("=== REQUISITO 3.11: TOTAL DOS SALÁRIOS ===");
        // Usa stream para somar todos os salários de forma eficiente
        BigDecimal total = funcionarios.stream()
            .map(Funcionario::getSalario) // Extrai os salários
            .reduce(BigDecimal.ZERO, BigDecimal::add); // Soma tudo começando do zero
        System.out.println("Total: " + formatarMoeda(total));
        System.out.println();
    }
    
    /**
     * REQUISITO 3.12: Imprime quantos salários mínimos ganha cada funcionário.
     * Considera salário mínimo = R$ 1212.00 conforme especificado.
     * 
     * @param funcionarios Lista de funcionários para calcular
     */
    private void imprimirSalariosMinimos(List<Funcionario> funcionarios) {
        System.out.println("=== REQUISITO 3.12: SALÁRIOS EM SALÁRIOS MÍNIMOS ===");
        for (Funcionario funcionario : funcionarios) {
            // Divide salário do funcionário pelo salário mínimo (R$ 1212.00)
            BigDecimal salariosMinimos = funcionario.getSalario()
                .divide(SALARIO_MINIMO, 2, RoundingMode.HALF_UP); // 2 casas decimais
            System.out.printf("%s: %s salários mínimos%n", 
                funcionario.getNome(), 
                formatarNumero(salariosMinimos)); // Formatação brasileira
        }
        System.out.println();
    }
    
    /**
     * Método auxiliar para formatar valores monetários no padrão brasileiro.
     * REQUISITO 3.3: Separador de milhar como ponto e decimal como vírgula.
     * 
     * @param valor Valor em BigDecimal para formatar
     * @return String formatada como moeda brasileira (R$ x.xxx,xx)
     */
    private String formatarMoeda(BigDecimal valor) {
        return FORMATO_MOEDA.format(valor);
    }
    
    /**
     * Método auxiliar para formatar números no padrão brasileiro.
     * REQUISITO 3.3: Separador de milhar como ponto e decimal como vírgula.
     * 
     * @param valor Valor em BigDecimal para formatar
     * @return String formatada como número brasileiro (x.xxx,xx)
     */
    private String formatarNumero(BigDecimal valor) {
        return FORMATO_NUMERO.format(valor);
    }
}
