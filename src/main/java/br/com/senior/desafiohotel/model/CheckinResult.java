package br.com.senior.desafiohotel.model;

public class CheckinResult {

    private Checkin checkin;
    private long totalDiariasSemana;
    private long totalDiariasFinalSemana;
    private float valorTotal;

    public Checkin getCheckin() {
        return checkin;
    }

    public void setCheckin(Checkin checkin) {
        this.checkin = checkin;
    }

    public long getTotalDiariasSemana() {
        return totalDiariasSemana;
    }

    public void setTotalDiariasSemana(long totDiariaSemana) {
        this.totalDiariasSemana = totDiariaSemana;
    }

    public long getTotalDiariasFinalSemana() {
        return totalDiariasFinalSemana;
    }

    public void setTotalDiariasFinalSemana(long totDiariaFinalSemana) {
        this.totalDiariasFinalSemana = totDiariaFinalSemana;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
}
