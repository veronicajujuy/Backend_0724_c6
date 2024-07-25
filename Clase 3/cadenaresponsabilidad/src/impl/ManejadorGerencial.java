package impl;

import model.Mail;

public class ManejadorGerencial extends ManejadorMail{
    @Override
    public String compruebaMail(Mail mail) {
        if(mail.getTema().equalsIgnoreCase("gerencia") ||
        mail.getDestino().equalsIgnoreCase("gerencia@colmena.com")){
            System.out.println("El mail quedo en Gerencia");
            return "El mail corresponde a gerencia y será tratado";
        }
        System.out.println("El mail paso por Gerencia");
        return getSiguienteManejador().compruebaMail(mail);
    }
}
