package br.ufjf.dcc192;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Evento {

    private String id;
    private String titulo;
    private double minimo;
    private Date dataAtual;
    private Date dataEvento;

    public Evento() {
    }

    public Evento(String id, String titulo, double minimo, Date dataAtual, Date dataEvento) {
        this.id = id;
        this.titulo = titulo;
        this.minimo = minimo;
        this.dataAtual = dataAtual;
        this.dataEvento = dataEvento;
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

    public Date getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(Date dataAtual) {
        this.dataAtual = dataAtual;
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
            //Collections.shuffle(amigo);
            int i;
            for (i = 0; i < amigo.size()-1; i++) {

                ParticipanteDao.getInstace().addSelecionado(amigo.get(i).getId(), amigo.get(i++).getId());
            }

            ParticipanteDao.getInstace().addSelecionado(amigo.get(amigo.size()-1).getId(), amigo.get(0).getId());
        }
    }

}
