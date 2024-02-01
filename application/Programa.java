package application;


import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner (System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Numero do quarto ");
        int numero = sc.nextInt();
        System.out.println("Data de entrada (dd/MM/yyyy)");
        Date entrada = sdf.parse(sc.next());
        System.out.println("Data de saida (dd/MM/yyyy)");
        Date saida = sdf.parse(sc.next());

        if(!saida.after((entrada))){
            System.out.println("Erro na reserva: A data de check-out deve ser posterior a data de check-in");
        }else{
            Reservation reserva = new Reservation(numero, entrada, saida);
            System.out.println("Reserva: " + reserva);

            System.out.println("entre com a nova data da reserva: ");
            System.out.println("Data de entrada (dd/MM/yyyy)");
            entrada = sdf.parse(sc.next());
            System.out.println("Data de saida (dd/MM/yyyy)");
            saida = sdf.parse(sc.next());

               String erro = reserva.updateDates(entrada, saida);
               if(erro != null) {
                   System.out.println(erro);
               }else{
                   System.out.println("Reserva: " + reserva);
               }


        }
    }


}
