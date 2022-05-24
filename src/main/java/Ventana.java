package conexionsqlite;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class Ventana extends javax.swing.JFrame {

    public Ventana() {
        initComponents();
        
        // Le damos el modelo por defecto a la tabla.
        model = (DefaultTableModel) this.jTable1.getModel(); 
    }
    
    DefaultTableModel model;
    
    // Creamos una variable con la dirección del archivo de la base de datos.
    String url="jdbc:sqlite:/home/dam1/Descargas/BaseDatos.db";
    
    // Sirve para establecer conexión con la base de datos.
    Connection connect;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bConectar = new javax.swing.JButton();
        bConsultar = new javax.swing.JButton();
        bInsertar = new javax.swing.JButton();
        bBorrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        bActualizar = new javax.swing.JButton();
        bSalir = new javax.swing.JButton();
        bEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bConectar.setText("CONECTAR");
        bConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConectarActionPerformed(evt);
            }
        });

        bConsultar.setText("CONSULTAR");
        bConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConsultarActionPerformed(evt);
            }
        });

        bInsertar.setText("INSERTAR");
        bInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bInsertarActionPerformed(evt);
            }
        });

        bBorrar.setText("BORRAR");
        bBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBorrarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº MATRICULA", "NOMBRE"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        bActualizar.setText("ACTUALIZAR");
        bActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bActualizarActionPerformed(evt);
            }
        });

        bSalir.setText("SALIR");
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });

        bEditar.setText("EDITAR");
        bEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bConectar)
                    .addComponent(bSalir)
                    .addComponent(bEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bConsultar)
                    .addComponent(bBorrar)
                    .addComponent(bInsertar)
                    .addComponent(bActualizar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConectarActionPerformed
        
        try{

        connect = DriverManager.getConnection(url);
        
        if (connect!=null){
            JOptionPane.showMessageDialog(null, "Conectado a base de datos.");
            }
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }//GEN-LAST:event_bConectarActionPerformed

    private void bConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConsultarActionPerformed
 
        model.setRowCount(0);
        ResultSet resultado=null;

        try{
            String id = JOptionPane.showInputDialog("Introduce o número de matrícula: ");

            PreparedStatement sentencia = connect.prepareStatement("select*from Legend where ID= " + id);
            resultado= sentencia.executeQuery();
            
            while(resultado.next()){
                model.addRow (new Object[]{resultado.getInt("ID"),resultado.getString("Nombre")});

            }



        }catch(Exception x){
            JOptionPane.showMessageDialog(null, x.getMessage().toString());
        }

       
    }//GEN-LAST:event_bConsultarActionPerformed

    private void bInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bInsertarActionPerformed

        try{

            PreparedStatement st = connect.prepareStatement("INSERT INTO Legend(ID,Nombre) VALUES(?,?)");
            st.setInt(1, Integer.parseInt(JOptionPane.showInputDialog("Introduce o número da matrícula do alumno que queres insertar: ")));
            st.setString(2,JOptionPane.showInputDialog("Introduce o nome do alumno que queres insertar: "));
            st.execute();
            JOptionPane.showMessageDialog(null, "Dato insertardo correctamente.");

        }catch(Exception x){
            JOptionPane.showMessageDialog(null, x.getMessage().toString());
        }

        
    }//GEN-LAST:event_bInsertarActionPerformed

    private void bBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBorrarActionPerformed


 try{

            PreparedStatement st = connect.prepareStatement("DELETE FROM Legend WHERE ID=?");
            st.setInt(1, Integer.parseInt(JOptionPane.showInputDialog("Introduce o número de matrícula do alumno que queres eliminar: ")));
            st.execute();
            JOptionPane.showMessageDialog(null, "Dato eliminado correctamente.");


        }catch(Exception x){
            JOptionPane.showMessageDialog(null, x.getMessage().toString());
        }

    }//GEN-LAST:event_bBorrarActionPerformed

    private void bActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bActualizarActionPerformed

         model.setRowCount(0);
        ResultSet resul=null;

        try{

            PreparedStatement st = connect.prepareStatement("SELECT ID,Nombre from Legend");
            resul= st.executeQuery();

            while(resul.next()){
                model.addRow (new Object[]{resul.getInt("ID"),resul.getString("Nombre")});

            }



        }catch(Exception x){
            JOptionPane.showMessageDialog(null, x.getMessage().toString());
        }

    }//GEN-LAST:event_bActualizarActionPerformed

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        
        try{
            // Conexión de la base de datos cerrada
            connect.close();
            JOptionPane.showMessageDialog(null, "Conexión pechada coa base de datos.");


        }catch(Exception x){
            JOptionPane.showMessageDialog(null, x.getMessage().toString());
        }

    }//GEN-LAST:event_bSalirActionPerformed

    private void bEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditarActionPerformed

        model.setRowCount(0);
        ResultSet resultado=null;

        try{
            String id = JOptionPane.showInputDialog("Introduce o número de matrícula do alumno que queres modificar: ");
            String newAlumno = JOptionPane.showInputDialog("Introduce o novo nome do alumno: ");

            PreparedStatement sentencia = connect.prepareStatement("update Legend set Nombre = " + newAlumno +
                    " where ID= " + id);
            resultado= sentencia.executeQuery();
            
            
        JOptionPane.showMessageDialog(null, "Nome editado con éxito.");


        }catch(Exception x){
            JOptionPane.showMessageDialog(null, x.getMessage().toString());
        }
        
    }//GEN-LAST:event_bEditarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bActualizar;
    private javax.swing.JButton bBorrar;
    private javax.swing.JButton bConectar;
    private javax.swing.JButton bConsultar;
    private javax.swing.JButton bEditar;
    private javax.swing.JButton bInsertar;
    private javax.swing.JButton bSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
