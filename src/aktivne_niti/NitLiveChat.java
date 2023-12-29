/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aktivne_niti;

import forme.ClientWorkingForm;
import forme.model.ModelTabelePoruke;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Komunikacija;
import model.Poruka;
import operacije.Operacije;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Acer
 */
public class NitLiveChat  extends Thread{
    
    ClientWorkingForm cwf;

    public void setCwf(ClientWorkingForm cwf) {
        this.cwf = cwf;
    }

    @Override
    public void run() {
        
        
  while(true){ 
        
        
   KlijentskiZahtev kz1 = new KlijentskiZahtev();
   kz1.setOperacija(Operacije.VRATI_SVE_PORUKE_KORISNIKA);
   kz1.setParam(cwf.getUlogovaniUser());
   
   Komunikacija.getInstance().posaljiZahtev(kz1);
   //***********
   ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
   List<Poruka>  poruke = (List<Poruka>)so.getOdgovor();
  
   
   
   
    if(poruke.size()<=3){
      ModelTabelePoruke mtp = new ModelTabelePoruke(poruke);
      cwf.getjTableLastThreeMess().setModel(mtp);
        
    }

       
       
       
    
     if(poruke.size()>3){
         
     List<Poruka> poslednjeTri = poruke.subList(poruke.size()-3, poruke.size());
     ModelTabelePoruke mtp1 = new ModelTabelePoruke(poslednjeTri);
      cwf.getjTableLastThreeMess().setModel(mtp1);
   
       

         
         
         List<Poruka> preostale = poruke.subList(0, poruke.size()-3);
         ModelTabelePoruke mtp2 = new ModelTabelePoruke(preostale);
         cwf.getjTableAnotherMessages().setModel(mtp2);
       
       
       
       
   }
     
      try {
          Thread.sleep(5000);
      } catch (InterruptedException ex) {
          Logger.getLogger(NitLiveChat.class.getName()).log(Level.SEVERE, null, ex);
      }
     
  }
    }
    
    
    
    
    
    
    
    
    
    
    
}
