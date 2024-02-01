package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer NumeroDoQuarto;
    private Date entrada;
    private Date saida;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer NumeroDoQuarto, Date entrada, Date saida) {
        this.NumeroDoQuarto = NumeroDoQuarto;
        this.entrada = entrada;
        this.saida = saida;
    }

    public Integer getNumeroDoQuarto() {
        return NumeroDoQuarto;
    }

    public void setNumeroDoQuarto(Integer numeroDoQuarto) {
        this.NumeroDoQuarto = numeroDoQuarto;
    }

    public Date getEntrada() {
        return entrada;
    }


    public Date getSaida() {
        return saida;
    }

    public long duration() {
        long diff = entrada.getTime() - entrada.getTime();
       return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public String updateDates(Date checkIn, Date checkOut){
        Date dataDeAgora = new Date();
        if(entrada.before(dataDeAgora)|| saida.before(dataDeAgora)){
           return "Erro na reserva: a data na reserva deve ser de datas futuras";
        }
        if(!saida.after((entrada))){
          return  "Erro na reserva: A data de check-out deve ser posterior a data de check-in";
        }
        this.entrada = checkIn;
        this.saida = checkOut;
        return null;
    }

    @Override
    public String toString() {
        return "Room " + NumeroDoQuarto
                       + entrada
                       + sdf.format(entrada)
                       + ", check - out: "
                       + sdf.format(saida)
                       + ", "
                       + duration()
                       +" Nights";
    }
}


