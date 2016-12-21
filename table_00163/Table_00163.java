
package table_00163;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class Table_00163 extends JTable {
    
    public Component prepareRenderer(TableCellRenderer ren, int r, int c){
        
        Component comp = super.prepareRenderer(ren, r, c);
        if(r%2==0&&(!isCellSelected(r, c)||isCellSelected(r, c))){
            comp.setBackground(new Color(0,0,0));
        }else if(isCellSelected(r, c)||isCellSelected(r, c)){
            comp.setBackground(new Color(255,255,255));
        }else{
             comp.setBackground(new Color(255,255,255));
        }
        
        return comp;
    }
 
   
    
}
