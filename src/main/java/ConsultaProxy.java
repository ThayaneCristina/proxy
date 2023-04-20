import java.util.List;

public class ConsultaProxy implements IConsulta{

    private Consulta consulta;
    private Integer id;

    public ConsultaProxy(Integer id) {
        this.id = id;
    }

    @Override
    public List<String> obterDadosConsulta() {
        if (this.consulta == null) {
            this.consulta = new Consulta(this.id);
        }
        return this.consulta.obterDadosConsulta();
    }

    @Override
    public List<Float> obterValores (Funcionario funcionario) {
        if (!funcionario.isAdministrador()) {
            throw new IllegalArgumentException("Funcionário não autorizado");
        }
        if (this.consulta == null) {
            this.consulta = new Consulta(this.id);
        }
        return this.consulta.obterValores(funcionario);
    }
}
