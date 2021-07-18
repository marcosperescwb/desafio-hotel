package br.com.senior.desafiohotel.model;

import javax.persistence.*;
import java.util.Date;


@Entity(name = "checkin")
// "SELECT * FROM checkin INNER JOIN hospede on checkin.id = hospede.id and hospede.nome = 'Marcos Peres'")

public class Checkin {


    @Id
    @GeneratedValue
    private Integer idCheckin;
    @Column(nullable = false)
    private Date dataEntrada;
    @Column()
    private Date dataSaida;
    @Column(nullable = false)
    private boolean adicionalVeiculo;
    @ManyToOne
    @JoinColumn(name = "id")
    private Hospede hospede;

    public Integer getIdCheckin() {
        return idCheckin;
    }

    public void setIdCheckin(Integer idCheckin) {
        this.idCheckin = idCheckin;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public boolean isAdicionalVeiculo() {
        return adicionalVeiculo;
    }

    public void setAdicionalVeiculo(boolean adicionalVeiculo) {
        this.adicionalVeiculo = adicionalVeiculo;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }
}
