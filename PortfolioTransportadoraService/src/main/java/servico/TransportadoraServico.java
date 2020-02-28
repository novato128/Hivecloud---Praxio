package servico;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.TransportadoraDAO;
import dao.TransportadoraDAOImpl;
import entidade.RetornoTransportadoraRest;
import entidade.Transportadora;

@Path("/transportadoraServico")
public class TransportadoraServico {

	private TransportadoraDAO transportadoraDAO = new TransportadoraDAOImpl();
		
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String ola() {
		return "Servico de Transportadora!!";
	}
	
	@GET
	@Path("/listar/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public RetornoTransportadoraRest listar(@PathParam("id") int id) {

		RetornoTransportadoraRest retorno = new RetornoTransportadoraRest();
		retorno.setCodigoRetorno(0);
		retorno.setMensagemretorno("SUCESSO!!!");
		retorno.setTransportadoraRetorno(this.transportadoraDAO.pesquisar(id));
		return retorno;
	}

	@GET
	@Path("/listarTodos")
	@Produces(MediaType.APPLICATION_JSON)
	public RetornoTransportadoraRest listarTodos() {

		RetornoTransportadoraRest retorno = new RetornoTransportadoraRest();
		retorno.setCodigoRetorno(0);
		retorno.setMensagemretorno("SUCESSO!!!");
		retorno.setListaTransportadora(this.transportadoraDAO.listarTodos());

		return retorno;
	}

	@POST
	@Path("/inserir")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoTransportadoraRest inserir(Transportadora transportadora) {

		RetornoTransportadoraRest retorno = new RetornoTransportadoraRest();
		if(this.transportadoraDAO.salvar(transportadora)) {
			retorno.setCodigoRetorno(0);
			retorno.setMensagemretorno("SUCESSO!!!");
		} else {
			retorno.setCodigoRetorno(1);
			retorno.setMensagemretorno("FALHA!!!");
		}
		return retorno;
	}

	@POST
	@Path("/deletar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoTransportadoraRest remover(Transportadora transportadora) {

		RetornoTransportadoraRest retorno = new RetornoTransportadoraRest();
		if(this.transportadoraDAO.remover(transportadora)) {
			retorno.setCodigoRetorno(0);
			retorno.setMensagemretorno("SUCESSO!!!");
		} else {
			retorno.setCodigoRetorno(1);
			retorno.setMensagemretorno("FALHA!!!");
		}

		return retorno;
	}
	
	@POST
	@Path("/alterar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoTransportadoraRest alterar(Transportadora transportadora) {

		RetornoTransportadoraRest retorno = new RetornoTransportadoraRest();
		if(this.transportadoraDAO.alterar(transportadora)) {
			retorno.setCodigoRetorno(0);
			retorno.setMensagemretorno("SUCESSO!!!");
		} else {
			retorno.setCodigoRetorno(1);
			retorno.setMensagemretorno("FALHA!!!");
		}

		return retorno;
	}

}