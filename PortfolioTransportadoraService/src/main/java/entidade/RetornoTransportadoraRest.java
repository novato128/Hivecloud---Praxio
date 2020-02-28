package entidade;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RetornoTransportadoraRest {

	private int codigoRetorno;
	private String mensagemretorno;
	private Transportadora transportadoraRetorno;
	private List<Transportadora> listaTransportadora;

	public int getCodigoRetorno() {
		return codigoRetorno;
	}

	public void setCodigoRetorno(int codigoRetorno) {
		this.codigoRetorno = codigoRetorno;
	}

	public String getMensagemretorno() {
		return mensagemretorno;
	}

	public void setMensagemretorno(String mensagemretorno) {
		this.mensagemretorno = mensagemretorno;
	}

	public Transportadora getTransportadoraRetorno() {
		return transportadoraRetorno;
	}

	public void setTransportadoraRetorno(Transportadora transportadoraRetorno) {
		this.transportadoraRetorno = transportadoraRetorno;
	}

	public List<Transportadora> getListaTransportadora() {
		return listaTransportadora;
	}

	public void setListaTransportadora(List<Transportadora> listaTransportadora) {
		this.listaTransportadora = listaTransportadora;
	}

}
