import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Consulta implements IConsulta {

    private Integer id;
    private String medico;
    private String paciente;
    private Date dataConsulta;
    private Float valor;

    public Consulta(Integer id) {
        this.id = id;
        Consulta objeto = BD.getConsulta(id);
        this.medico = objeto.medico;
        this.paciente = objeto.paciente;
        this.dataConsulta = objeto.dataConsulta;
        this.valor = objeto.valor;
    }

    public Consulta(Integer id, String medico, String paciente, Date dataConsulta, Float valor) {
        this.id = id;
        this.medico = medico;
        this.paciente = paciente;
        this.dataConsulta = dataConsulta;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public List<String> obterDadosConsulta() {
        return Arrays.asList(this.medico, this.paciente);
    }

    @Override
    public List<Float> obterValores(Funcionario funcionario) {
        return Arrays.asList(this.valor);
    }
}
