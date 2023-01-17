package Consultas;

import java.util.Comparator;

public class OrdenarDia implements Comparator <Consulta>{
    
@Override
    public int compare(Consulta c1, Consulta c2) {
		
		String dia1 = c1.getDia();
		String dia2 = c2.getDia();

		return dia1.compareTo(dia2);

    }

}