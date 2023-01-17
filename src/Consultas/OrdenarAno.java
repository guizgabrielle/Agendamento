package Consultas;

import java.util.Comparator;

public class OrdenarAno implements Comparator <Consulta> {

    @Override
    public int compare(Consulta c1, Consulta c2) {
		
		String ano1 = c1.getAno();
		String ano2 = c2.getAno();

		return ano1.compareTo(ano2);

    }

}


