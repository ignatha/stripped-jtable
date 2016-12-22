package table;


import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ignatha
 */

public class Table_00163 extends JTable{
    
    
    
    public Table_00163() throws SQLException {
         koneksi c = new koneksi(); 
        Statement st = c.getConnection().createStatement();
        ResultSet rs = st.executeQuery("select * from javaObjectTable");
        setModel(buildTableModel(rs));
      
    }
    
    public static DefaultTableModel buildTableModel(ResultSet rs)
        throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

    // nama kolom
        Vector<String> columnNames = new Vector<String>();
    int columnCount = metaData.getColumnCount();
    for (int column = 1; column <= columnCount; column++) {
        columnNames.add(metaData.getColumnName(column));
    }

    // isi
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    while (rs.next()) {
        Vector<Object> vector = new Vector<Object>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            vector.add(rs.getObject(columnIndex));
        }
        data.add(vector);
    }

    return new DefaultTableModel(data, columnNames);

}
  
    public Component prepareRenderer(TableCellRenderer ren, int r, int c){
        
        Component comp=super.prepareRenderer(ren, r, c);
        if(r%2==0&&(!isCellSelected(r, c)||isCellSelected(r, c))){
            comp.setBackground(new Color(235,182,228));
            comp.setForeground(Color.BLACK);
            
        }else if(!isCellSelected(r, c)||isCellSelected(r, c)){
            comp.setBackground(new Color(255,255,255));
            comp.setForeground(Color.BLACK);
        }
        return comp;        
    }
    
   
    
}
