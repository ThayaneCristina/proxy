import java.util.HashMap;
import java.util.Map;

public class BD {

    private static Map<Integer, Consulta> consultas = new HashMap<>();

    public static Consulta getConsulta(Integer id) {
        return consultas.get(id);
    }

    public static void addConsulta(Consulta consulta) {
        consultas.put(consulta.getId(), consulta);
    }
}
