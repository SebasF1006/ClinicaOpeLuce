package web.validator;

import dao.DaoPaciente;
import dao.impl.DaoPacienteImpl;
import entidades.Paciente;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class CorreoValidator {

    
    
    
    private final HttpServletRequest request;
    public Integer num=0;
    private final DaoPaciente daoPaciente;
    private static String emailFrom = "clinicadopeluce@gmail.com";
    private static String passwordFrom = "ifszqviawqhqlizo";
    private String emailTo = null;
    private Paciente paci;
    private String PassAG = "";
    private String subject;
    private String content;

    private Properties mProperties;
    private Session mSession;
    private MimeMessage mCorreo;

    public CorreoValidator(HttpServletRequest request) {
        this.request = request;
        this.daoPaciente = new DaoPacienteImpl();
        mProperties = new Properties();
    }

    public String RecuperacionContraseña() {
        StringBuilder result = new StringBuilder("<ul>");
        createEmail();
        
        if (emailTo == null || emailTo.trim().length() == 0) {
            result.append("<li>Debe ingresar un correo</li>");
        }else if (paci == null) {
            result.append("<li>El correo no está registrado en la página Web</li>");
        }
        
        if (result.length() == 4) {
            paci.setPassword_paciente(PassAG);
            daoPaciente.pacienteUpd(paci);
            sendEmail();
        }
        
        
        return result.length() == 4 ? null : result.append("</ul>").toString();
    }
    
    private void createEmail() {
        emailTo = request.getParameter("correo");
        paci = daoPaciente.RecuperarPassword(emailTo);
        PassAG = PasswordAG();
        String nombres="";
        String apellidos="";
        if (paci!=null) {
            nombres = paci.getNombres_paciente();
            apellidos = paci.getApellidos_paciente();
        }
        subject = "RECUPERACIÓN DE CONTRASEÑA CLINICA D'OPELUCE";
        content = "Estimado "+nombres+" "+apellidos;
        content+=", procedemos a enviar su nueva contraseña.";
        content+="<br>Recuerda que esta contraseña puede cambiarla";
        content+=" una vez ingresado a la página web";
                content+="<br>Su nueva contraseña es : "+PassAG;
        
         // Simple mail transfer protocol
        mProperties.put("mail.smtp.host", "smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.port", "587");
        mProperties.setProperty("mail.smtp.user",emailFrom);
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mProperties.setProperty("mail.smtp.auth", "true");
        
        mSession = Session.getDefaultInstance(mProperties);
        
        
        try {
            mCorreo = new MimeMessage(mSession);
            mCorreo.setFrom(new InternetAddress(emailFrom));
            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
            mCorreo.setSubject(subject);
            mCorreo.setText(content, "ISO-8859-1", "html");
                     
            
        } catch (AddressException ex) {
            //Logger.getLogger(AdministradorValidator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            //Logger.getLogger(AdministradorValidator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sendEmail() {
        try {
            Transport mTransport = mSession.getTransport("smtp");
            mTransport.connect(emailFrom, passwordFrom);
            mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
            mTransport.close();
        } catch (NoSuchProviderException ex) {
            //Logger.getLogger(AdministradorValidator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            //Logger.getLogger(AdministradorValidator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String PasswordAG(){
        String CADENA ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890#%&/()=";
        Integer LONGITUD = 10;
        StringBuilder pass = new StringBuilder();
        for (int i = 0; i < LONGITUD; i++) {
            double ale = Math.random() * CADENA.length();
            int posicion = (int) ale;
            char letra = CADENA.charAt(posicion);
            pass.append(letra);
        }
        return pass.toString();
    }
    
    
    
    

}
