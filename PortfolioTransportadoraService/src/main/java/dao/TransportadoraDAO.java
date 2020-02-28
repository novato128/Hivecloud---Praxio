package dao;

import java.util.List;

import entidade.Transportadora;

public interface TransportadoraDAO {
    
    public boolean salvar(Transportadora transportadora);
    
    public boolean alterar(Transportadora transportadora);
    
    public boolean remover(Transportadora transportadora);
    
    public Transportadora pesquisar(Integer idTransportadora);
    
    public List<Transportadora> listarTodos();
}
