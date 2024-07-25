package impl;

import model.Mail;

public class ManejadorComercial extends ManejadorMail{
    @Override
    public String compruebaMail(Mail mail) {
        if(mail.getTema().equalsIgnoreCase("comercial") ||
                mail.getDestino().equalsIgnoreCase("comercial@colmena.com")){
            System.out.println("El mail quedo en Comercial");
            return "El mail corresponde a comercial y será tratado";
        }
        System.out.println("El mail paso por Comercial");
        return getSiguienteManejador().compruebaMail(mail);
    }
}
