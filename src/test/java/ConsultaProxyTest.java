import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ConsultaProxyTest {

    String dataRecebida = "23/11/2015";
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    Date dataFormatada;


    @BeforeEach
    void setUp() {
        BD.addConsulta(new Consulta(1, "Pablito", "Tamara", dataFormatada, 80.0f));
        BD.addConsulta(new Consulta(2, "Martinely", "Rodney", dataFormatada, 100.0f));
    }

    @Test
    void deveRetornarDadosConsulta() {
        ConsultaProxy consulta = new ConsultaProxy(1);

        assertEquals (Arrays.asList("Pablito", "Tamara"), consulta.obterDadosConsulta());
    }

    @Test
    void deveRetornarValoresConsultas() {
        Funcionario funcionario = new Funcionario("Tobias", true);
        ConsultaProxy consulta = new ConsultaProxy(2);

        assertEquals (Arrays.asList(80.0f, 100.0f), consulta.obterValores(funcionario));
    }

    @Test
    void deveRetornarExcecaoUsuarioNaoAutorizadoConsultarValores() {
        try {
            Funcionario funcionario = new Funcionario("Nicolas", false);
            ConsultaProxy consulta = new ConsultaProxy(1);

            consulta.obterValores(funcionario);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Funcionário não autorizado", e.getMessage());
        }
    }

}
