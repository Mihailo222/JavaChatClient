/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.User;

/**
 *
 * @author Acer
 */
public class ModelTabeleAktivni extends AbstractTableModel{

    
    ArrayList<User> users = new ArrayList<>();
    String kolone[] = {"name","surname"};

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ModelTabeleAktivni(ArrayList<User> users) {
    
        this.users=users;
    
    }
    
   

    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {

        return kolone.length;

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        
        User u = users.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return u.getName();
            case 1:
                return u.getSurname();
            default:
                return "N/A";
            
        }
        
 
        
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    
    
    
    
    
    
    
}
