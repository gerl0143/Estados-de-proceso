
package interfaz;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gerar
 */
public class Pantalla extends javax.swing.JFrame {

    /**
     * Creates new form Pantalla
     */
    public int i;
    public String texto3;
    public Pantalla() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Barra1 = new javax.swing.JProgressBar();
        Estado = new javax.swing.JLabel();
        Btn1 = new javax.swing.JButton();
        Btn2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Estados de proceso");

        Barra1.setStringPainted(true);
        Barra1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Barra1StateChanged(evt);
            }
        });

        Estado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Estado.setText("Nuevo");

        Btn1.setText("Iniciar");
        Btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn1ActionPerformed(evt);
            }
        });

        Btn2.setText("Stop");
        Btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Btn1)
                                .addGap(18, 18, 18)
                                .addComponent(Btn2))
                            .addComponent(Estado)
                            .addComponent(Barra1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addComponent(Estado)
                .addGap(18, 18, 18)
                .addComponent(Barra1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn1)
                    .addComponent(Btn2))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void Btn1ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
        Thread  hilo= new Thread(){
            @Override
            
            public void run(){
                if ("Bloqueado".equals(Estado.getText())){
                    Estado.setText(texto3);
                }else{
                    i=0;
                    while(!"Finalizado".equals(Estado.getText())){
                        for (i = 0; i <= 100; i++) {
                            if ("Bloqueado".equals(Estado.getText())) {
                                Thread.interrupted();
                            } else {
                                Barra1.setValue(i);
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(Pantalla.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    }
                }
                
            }
        };
        hilo.start();       
    }                                    

    private void Barra1StateChanged(javax.swing.event.ChangeEvent evt) {                                    
        Thread hilo2=new Thread(){
            @Override
            public void run(){
               if(Barra1.getValue()== 100){
               String texto=Estado.getText();
               
                   switch (texto) {
                       case "Nuevo" -> Estado.setText("Listo");
                       case "Listo" -> Estado.setText("Ejecución");
                       case "Ejecución" -> Estado.setText("Finalizando");
                       case "Finalizando" -> Estado.setText("Finalizado");
                       default -> {
                       }
                   }
               }
            }
        };
        hilo2.start();
        
    }                                   

    private void Btn2ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        texto3=Estado.getText();
        String texto2="Bloqueado";
        Estado.setText(texto2);
    }                                    

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify                     
    private javax.swing.JProgressBar Barra1;
    private javax.swing.JButton Btn1;
    private javax.swing.JButton Btn2;
    private javax.swing.JLabel Estado;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration                   
}
