package util;

import java.util.ArrayList;
import java.util.List;

import entidade.Transportadora;

public class ListaTransportadora {

	private static ArrayList<Transportadora> transportadoras;

	public ListaTransportadora() {
		super();
	}

	public static synchronized List<Transportadora> getInstance() {
		if (transportadoras == null) {
			transportadoras = new ArrayList<Transportadora>();
			preencherLista();			
		}

		return transportadoras;
	}

	private static void preencherLista() {

		Transportadora transportadora1 = new Transportadora(1, "email1@gmail.com", "nome1", "empresa1", "3471-1291", "(81)998765431",
				"(81)998765431", "Rodoviário", "50720-010", "PE", "Recife", "bairro", "rua", "01");
		Transportadora transportadora2 = new Transportadora(2, "email2@gmail.com", "nome2", "empresa2", "3471-1292", "(81)998765432",
				"(81)998765432", "Rodoviário", "50720-020", "PE", "Olinda", "bairro", "rua", "10");
		Transportadora transportadora3 = new Transportadora(3, "email3@gmail.com", "nome3", "empresa3", "3471-1293", "(83)998765433",
				"(83)998765433", "Rodoviário", "50720-030", "RN", "Natal", "bairro", "rua", "12");
		Transportadora transportadora4 = new Transportadora(4, "email4@gmail.com", "nome4", "empresa4", "3471-1294", "(84)998765434",
				"(84)998765434", "Rodoviário", "50720-040", "PB", "João Pessoa", "bairro", "rua", "14");
		Transportadora transportadora5 = new Transportadora(5, "email5@gmail.com", "nome5", "empresa5", "3471-1295", "(75)998765435",
				"(75)998765435", "Rodoviário", "50720-050", "AL", "Maceio", "bairro", "rua", "16");
		Transportadora transportadora6 = new Transportadora(6, "email6@gmail.com", "nome6", "empresa6", "3471-1296", "(14)998765436",
				"(14)998765436", "Aéreo", "50720-060", "RS", "Porto Alegre", "bairro", "rua", "18");
		Transportadora transportadora7 = new Transportadora(7, "email7@gmail.com", "nome7", "empresa7", "3471-1297", "(11)998765437",
				"(11)998765437", "Aquaviário", "50720-070", "SP", "São Paulo", "bairro", "rua", "20");
		Transportadora transportadora8 = new Transportadora(8, "email8@gmail.com", "nome8", "empresa8", "3471-1298", "(65)998765438",
				"(65)998765438", "Aéreo", "50720-080", "GO", "Brasilia", "bairro", "rua", "22");

		transportadoras.add(transportadora1);
		transportadoras.add(transportadora2);
		transportadoras.add(transportadora3);
		transportadoras.add(transportadora4);
		transportadoras.add(transportadora5);
		transportadoras.add(transportadora6);
		transportadoras.add(transportadora7);
		transportadoras.add(transportadora8);
	}

}
