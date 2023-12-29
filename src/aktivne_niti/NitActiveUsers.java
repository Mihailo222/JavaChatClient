/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aktivne_niti;

import forme.ClientWorkingForm;
import forme.model.ModelTabeleAktivni;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Komunikacija;
import model.User;
import operacije.Operacije;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Acer
 */
public class NitActiveUsers extends Thread{

    ClientWorkingForm cwf;

    public ClientWorkingForm getCwf() {
        return cwf;
    }

    public void setCwf(ClientWorkingForm cwf) {
        this.cwf = cwf;
    }
    
    
    
    
    
    
    @Override
    public void run() {
       
        
        while(true){
         
        KlijentskiZahtev kz1 = new KlijentskiZahtev();
        kz1.setOperacija(Operacije.VRATI_ULOGOVANE);
        kz1.setParam(null);
        
        Komunikacija.getInstance().posaljiZahtev(kz1);
        //*********
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        ArrayList<User> listaUlogovanih = (ArrayList<User>) so.getOdgovor();
        
        
        ModelTabeleAktivni mta = new ModelTabeleAktivni(listaUlogovanih);
        cwf.getjTableAktivni().setModel(mta);
        
        
        
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(NitActiveUsers.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        }
        
        
        
        
        
    }
    
    
    
    
        
    
    
    

     

    
    
    
    
    
    
    
    
    
    
    
    
}
