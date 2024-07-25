package impl;

import model.Mail;

public class ManejadorTecnico extends ManejadorMail{
    @Override
    public String compruebaMail(Mail mail) {
        if(mail.getTema().equalsIgnoreCase("tecnico") ||
                mail.getDestino().equalsIgnoreCase("tecnico@colmena.com")){
            System.out.println("El mail quedo en Tecnico");
            return "El mail corresponde a tecnico y será tratado";
        }
        System.out.println("El mail paso por Tecnico");
        return getSiguienteManejador().compruebaMail(mail);
    }
}
