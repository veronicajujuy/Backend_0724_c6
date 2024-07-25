package impl;

import model.Mail;

public class ProcesaMail {
    private ManejadorMail iniciaCadena;

    public ProcesaMail() {
        iniciaCadena = new ManejadorComercial();
        ManejadorMail tecnico = new ManejadorTecnico();
        ManejadorMail gerencial = new ManejadorGerencial();
        ManejadorMail spam = new ManejadorSpam();

        iniciaCadena.setSiguienteManejador(gerencial);
        gerencial.setSiguienteManejador(tecnico);
        tecnico.setSiguienteManejador(spam);

    }

    public String compruebaMail(Mail mail) {
        return iniciaCadena.compruebaMail(mail);
    }
}
