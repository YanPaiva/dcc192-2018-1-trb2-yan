package br.ufjf.dcc192;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Evento {

    private String id;
    private String titulo;
    private double minimo;
    private Date dataSorteio;
    private Date dataEvento;
    private boolean sorteia = true;

    public Evento() {
    }

    public Evento(String id, String titulo, double minimo, Date dataAtual, Date dataEvento) {
        this.id = id;
        this.titulo = titulo;
        this.minimo = minimo;
        this.dataSorteio = dataAtual;
        this.dataEvento = dataEvento;
    }

    public boolean isSorteia() {
        return sorteia;
    }

    public void setSorteia(boolean sorteia) {
        this.sorteia = sorteia;
    }

    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getMinimo() {
        return minimo;
    }

    public void setMinimo(double minimo) {
        this.minimo = minimo;
    }

    public Date getDataSorteio() {
        return dataSorteio;
    }

    public void setDataSorteio(Date dataSorteio) {
        this.dataSorteio = dataSorteio;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    public void sorteia() {
        List<Participante> amigo = EventoAmigoDao.getInstace().listParticipantes(id);
        if (amigo.get(0).getSorteado() == null) {
            Collections.shuffle(amigo);
            int i;    
            for (i = 0; i < amigo.size()-1; i++) {

                ParticipanteDao.getInstace().addSelecionado(amigo.get(i).getId(), amigo.get(i+1).getId());
            }

            ParticipanteDao.getInstace().addSelecionado(amigo.get(amigo.size()-1).getId(), amigo.get(0).getId());
        }
    }

}
