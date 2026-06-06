package com.example.skatingplan.model.dao.demo;


import com.example.skatingplan.model.Pagamento;
import com.example.skatingplan.model.dao.PagamentiDAO;
import com.example.skatingplan.model.enumerazioni.StatoPagamento;


import java.util.ArrayList;
import java.util.List;


public class DEMOPagamentiDAO implements PagamentiDAO {
    List<Pagamento> pagamenti = new ArrayList<>();

    @Override
    public void inserisciPagamento(Pagamento pagamento) {
        pagamenti.add(pagamento);
    }

    @Override
    public void aggiornaPagamento(Pagamento newpagamento, StatoPagamento statoPagamento) {
        for(Pagamento pagamento : pagamenti){
            if(pagamento.getIdLezione() == newpagamento.getIdLezione()){
                pagamento.setStatoPagamento(statoPagamento);
            }
        }
    }

    @Override
    public void annullaPagamento(int idLezione) {
        pagamenti.removeIf(pagamento -> pagamento.getIdLezione() == idLezione);
    }

}
