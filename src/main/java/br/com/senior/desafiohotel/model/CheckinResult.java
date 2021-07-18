package br.com.senior.desafiohotel.model;

public class CheckinResult {

    private CheckinModel checkin;
    private float total;

    public CheckinModel getCheckin() {
        return checkin;
    }

    public void setCheckin(CheckinModel checkin) {
        this.checkin = checkin;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

}
