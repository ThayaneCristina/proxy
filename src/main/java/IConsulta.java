import java.util.List;

public interface IConsulta {
    List<String> obterDadosConsulta();

    List<Float> obterValores(Funcionario funcionario);
}
