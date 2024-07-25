package impl;

import model.Mail;

public class ManejadorSpam extends ManejadorMail{
    @Override
    public String compruebaMail(Mail mail) {
            System.out.println("El fue a parar a Spam");
            return "El mail termino en Spam";

    }
}
