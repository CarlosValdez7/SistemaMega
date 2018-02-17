package megapublicidad2.pkg0;

import Conexion.Conexion;
import Metodos.ArchivoPDF;
import Metodos.Ticket2;
import Metodos.cortedeCaja;
import java.awt.Desktop;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author German Valdez
 */
public class corteCaja extends javax.swing.JFrame {

    /**
     * Creates new form corteCaja
     */
    Connection cn;
    cortedeCaja u;
    ventanaPrincipal prin;
    //ventanaCorte vc;
    String fecha = "", usuario = "";
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public corteCaja(String usuario, Connection c) {
        initComponents();
        setLocationRelativeTo(null);


        fecha = new SimpleDateFormat("yyyy-MM-dd").format(GregorianCalendar.getInstance().getTime());
        this.usuario = usuario;
        
        cn = c;
        u = new cortedeCaja(cn);

        iniciaTabla();

        sumas();
    }

    public void iniciaTabla() {
        //limpiar(tablaCorte);
        DefaultTableModel modelo = (DefaultTableModel) tablaCorte.getModel();
        DefaultTableModel modelo2 = (DefaultTableModel) tablaTipos.getModel();
        DefaultTableModel modelo3 = (DefaultTableModel) tablaTrans.getModel();
        DefaultTableModel modelo4 = (DefaultTableModel) jTable1.getModel();
        u.tablaCorteCaja(modelo, fecha);
        u.tablaCorteCajaAbonos(modelo, fecha);
        u.tablaCorteCajaTipos(modelo2, fecha);
        u.tablaCorteTrans(modelo3, fecha);
        u.tablaGastos(modelo4, fecha);
        cambiarPrecios();
        sumaTipos();
        sumaGastos();
        jTable1.setVisible(false);
    }

    public void cambiarPrecios() {
        DefaultTableModel modelo = (DefaultTableModel) tablaTipos.getModel();
        double total = 0;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            total = Float.parseFloat(modelo.getValueAt(i, 1) + "");
            modelo.setValueAt(df.format(total), i, 1);
        }
    }
    double totalTipos=0, totalGastos = 0;

    public void sumaTipos() {
        DefaultTableModel modelo = (DefaultTableModel) tablaTipos.getModel();

        for (int i = 0; i < modelo.getRowCount(); i++) {
            totalTipos = totalTipos + Float.parseFloat(modelo.getValueAt(i, 1) + "");
        }
        
    }

    public void sumaGastos() {
try{
        DefaultTableModel modelo2 = (DefaultTableModel) jTable1.getModel();
        totalGastos = 0;
        for (int i = 0; i < modelo2.getRowCount(); i++) {
            totalGastos = totalGastos + Float.parseFloat(modelo2.getValueAt(i, 1) + "");
        }
        labelGastos.setText(df.format(totalGastos));
}catch(Exception e){}    
        //double suma2 = (Double.parseDouble(sumEfec.getText()) + Double.parseDouble(sumTar.getText()) + Double.parseDouble(sumCheque.getText())) + Double.parseDouble(labelGastos.getText());
        //System.out.println(sumEfec.getText()+" + "+sumTar.getText()+" + "+sumCheque.getText()+ " + "+labelGastos.getText()+" = "+suma2 );
        //totalCalculado.setText(df.format(suma2));
    }

    public void total() {
        try {
            double efec = Double.parseDouble(eCaja.getText());
            double tar = Double.parseDouble(tCaja.getText());
            double che = Double.parseDouble(cCaja.getText());

            double efec2 = Double.parseDouble(dEfectivo.getText());
            double tar2 = Double.parseDouble(jTextField10.getText());
            double che2 = Double.parseDouble(jTextField15.getText());

            totalCaja.setText(df.format(efec + tar + che) + "");
            jTextField3.setText(df.format(efec2 + tar2 + che2) + "");
        }
        catch (Exception e) {
        }
    }

    private void sumas() {
        String efec = u.sumEfectivo(fecha);
        String tar = u.sumTarjeta(fecha);
        String che = u.sumCheque(fecha);
        String trans = u.sumTrans(fecha);

        sumEfec.setText(u.sumEfectivo(fecha) + "");
        sumTar.setText(u.sumTarjeta(fecha) + "");
        sumCheque.setText(u.sumCheque(fecha) + "");
        labelTrans.setText(u.sumTrans(fecha) + "");

        double suma = (Double.parseDouble(tar) + Double.parseDouble(efec) + Double.parseDouble(che));// + Double.parseDouble(labelGastos.getText());

        totalCalculado.setText(df.format(suma) + "");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        eCaja = new javax.swing.JTextField();
        sumEfec = new javax.swing.JTextField();
        dEfectivo = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        sumTar = new javax.swing.JTextField();
        tCaja = new javax.swing.JTextField();
        cCaja = new javax.swing.JTextField();
        sumCheque = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        totalCaja = new javax.swing.JTextField();
        totalCalculado = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        labelTrans = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        labelGastos = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCorte = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaTipos = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaTrans = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Generando corte..");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setOpaque(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Conteo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.white));
        jPanel2.setOpaque(false);

        eCaja.setText("0.0");
        eCaja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                eCajaKeyReleased(evt);
            }
        });

        dEfectivo.setText("0.0");

        jTextField10.setText("0.0");

        tCaja.setText("0.0");
        tCaja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tCajaKeyReleased(evt);
            }
        });

        cCaja.setText("0.0");
        cCaja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cCajaKeyReleased(evt);
            }
        });

        jTextField15.setText("0.0");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Efectivo");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tarjeta");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cheque");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Transferencias");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Caja");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Calculado");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Diferencia");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Gastos");

        totalCaja.setText("0.0");

        jTextField3.setText("0.0");

        labelTrans.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelTrans.setForeground(new java.awt.Color(255, 255, 255));
        labelTrans.setText("0.0");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Total");

        labelGastos.setText("0.0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalCalculado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sumTar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(eCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sumEfec, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(dEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelGastos)
                                    .addComponent(sumCheque, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelTrans)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sumEfec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sumTar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sumCheque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(labelGastos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalCalculado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(labelTrans)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.white));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setOpaque(false);

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Salida");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Entrada");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 620, 250));

        jScrollPane1.setOpaque(false);

        tablaCorte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Concepto", "Total", "Tipo"
            }
        ));
        jScrollPane1.setViewportView(tablaCorte);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 600, 140));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoCobro2.png"))); // NOI18N
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 420));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Concepto", "Total", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 590, 70));

        tablaTipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "Suma"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablaTipos);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 550, 70));

        jScrollPane5.setOpaque(false);

        tablaTrans.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Concepto", "Total", "Tipo"
            }
        ));
        jScrollPane5.setViewportView(tablaTrans);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 600, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public Object[][] obtenerArticulos(DefaultTableModel modelo) {
        Object[][] articulos = null;
        articulos = new Object[modelo.getRowCount()][modelo.getColumnCount()];
        for (int i = 0; i < modelo.getRowCount(); i++) {
            for (int j = 0; j < modelo.getColumnCount(); j++) {
                articulos[i][j] = modelo.getValueAt(i, j);
            }
        }
        return articulos;
    }

    private void eCajaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eCajaKeyReleased
        // TODO add your handling code here:
        try {
            if (eCaja.equals("")) {
                dEfectivo.setText("");
            }
            else {
                float suma = Float.parseFloat(sumEfec.getText());
                float contado = Float.parseFloat(eCaja.getText());

                float diferencia = suma - contado;

                dEfectivo.setText(df.format(diferencia) + "");
            }
        }
        catch (Exception e) {
        }
        total();
    }//GEN-LAST:event_eCajaKeyReleased

    double ef = 0, tar = 0, che = 0, suma = 0;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ArchivoPDF p = new ArchivoPDF(cn);
        String nombre = "";
        try {
            String sql = "insert into cortecaja values(null,'" + fecha + "','" + totalCaja.getText() + "','" + usuario + "') ";

            PreparedStatement cmd = cn.prepareCall(sql);
            cmd.execute();

            cmd.close();
            JOptionPane.showMessageDialog(null, "Corte de caja guardado");

        }
        catch(Exception e){JOptionPane.showMessageDialog(this,"Error en corte\n"+e);
        }
        
        try{
            DefaultTableModel modelo = (DefaultTableModel) tablaCorte.getModel();
            Object[][] articulos = obtenerArticulos(modelo);

            DefaultTableModel modelo2 = (DefaultTableModel) jTable1.getModel();
            Object[][] articulos2 = obtenerArticulos(modelo2);

            DefaultTableModel modelo3 = (DefaultTableModel) tablaTipos.getModel();
            Object[][] articulos3 = obtenerArticulos(modelo3);
            
            DefaultTableModel modelo4 = (DefaultTableModel) tablaTrans.getModel();
            Object[][] articulos4 = obtenerArticulos(modelo4);

            double eCaja11 = 0, tCaja11 = 0, cCaja11 = 0;
            eCaja11 = Double.parseDouble(dEfectivo.getText());
            tCaja11 = Double.parseDouble(jTextField10.getText());
            cCaja11 = Double.parseDouble(jTextField15.getText());

            prin.iniciaCortes();

            try {
                nombre = "corteCaja_" + fecha;
                p.pdfCorteCaja(nombre, articulos, articulos2, articulos3,articulos4, fecha, totalCalculado.getText(), usuario,
                        eCaja.getText(), tCaja.getText(), cCaja.getText(), sumEfec.getText(), sumTar.getText(),
                        sumCheque.getText(), df.format(eCaja11), df.format(tCaja11), df.format(cCaja11), totalCaja.getText(), 
                        jTextField3.getText(),labelGastos.getText(),df.format(totalTipos)+"",labelTrans.getText());

            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error pdf corte de caja");
            }
            SimpleDateFormat fTicket = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat hora = new SimpleDateFormat("hh:mm a");
            Calendar cal = GregorianCalendar.getInstance();

            String fechaTicket = fTicket.format(cal.getTime());
            String horaTicket = hora.format(cal.getTime());

            Double totalEfectivo = Double.parseDouble(sumEfec.getText()) + Double.parseDouble(labelGastos.getText());

            String tic =
                    "       MEGAPUBLICIDAD\n"
                    + "       DUCJ681122GM7\n\n"
                    + "Av. Juan Escutia 134-A \n"
                    + "Zona Centro\n"
                    + "C.P. 63000 TEPIC, NAYARIT\n"
                    + "meganayarit@gmail.com\n"
                    + "311-218-0320\n"
                    + "================================\n"
                    + "    **** CORTE DE CAJA ***\n"
                    + "FECHA: " + fechaTicket + "  " + horaTicket + "\n"
                    + "================================\n"
                    + "CODIGO   CONCEPTO\tTIPO\n"
                    + "================================\n";

            for (int i = 0; i < tablaCorte.getRowCount(); i++) {
                String cod = tablaCorte.getValueAt(i, 0) + "";
                String con = tablaCorte.getValueAt(i, 1) + "";
                String total = tablaCorte.getValueAt(i, 2) + "";
                String tipo = tablaCorte.getValueAt(i, 3) + "";
                tic +=
                        cod + "   " + con + "\t" + tipo + "\n"
                        + "        Total: $" + total + "\n";
            }
            tic += //"\nA PAGAR:\t" + "$" + labelTotal.getText() + "\n"
                    //+ "\tDESCUENTO:\t" + lblDesc.getText() + "\n"
                    "\n   >>>>> CALCULADO <<<<<  \n"
                    + "Caja:     $" + sumEfec.getText() + "\n"
                    + "Tarjeta:  $" + sumTar.getText() + "\n"
                    + "Cheque:   $" + sumCheque.getText() + "\n"
                    + "Total:    $" + totalCalculado.getText() + "\n"
                    + "\n   >>>>> EN CAJA <<<<<  \n"
                    + "Caja:     $" + eCaja.getText() + "\n"
                    + "Tarjeta:  $" + tCaja.getText() + "\n"
                    + "Cheque:   $" + cCaja.getText() + "\n"
                    + "Total:    $" + totalCaja.getText() + "\n"
                    + "\n   >>>>> EFECTIVO TOTAL <<<<<  \n"
                    + "Sistema:  $" + sumEfec.getText()+"\n"
                    + "Gastos:   $" + labelGastos.getText() +"\n"
                    + "Total:    $" + df.format(totalEfectivo)+"\n\n"
                    + "\n  >>>>>ENTRADAS/SALIDAS <<<<<  \n";
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                String con = jTable1.getValueAt(i, 0) + "";
                String tot = jTable1.getValueAt(i, 1) + "";
                String tip = jTable1.getValueAt(i, 2) + "";
                tic +=
                        tip + "\t" + con + "\n"
                        + "        Total: $" + tot + "\n";
            }
            tic += "================================\n"
                    + "       " + usuario + "\n"
                    + "     !!! NOS VEMOS MAÑANA !!!\n\n\n\n";

            System.out.println(tic);
            Ticket2 o = new Ticket2(tic);

            try {
                Desktop desktop = Desktop.getDesktop();
                desktop.open(new java.io.File("C:\\Users\\Lenovo\\Documents\\Documentos Sistema\\Cortes\\" + nombre + ".pdf"));

            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No se puede abrir archivo." + ex.getMessage());
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error en registro del corte" + ex);
        }

        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tCajaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tCajaKeyReleased
        // TODO add your handling code here:
        try {
            if (tCaja.equals("")) {
                jTextField10.setText("");
            }
            else {
                float suma = Float.parseFloat(sumTar.getText());
                float contado = Float.parseFloat(tCaja.getText());

                float diferencia = suma - contado;

                jTextField10.setText(df.format(diferencia) + "");
            }
        }
        catch (Exception e) {
        }
        total();
    }//GEN-LAST:event_tCajaKeyReleased

    private void cCajaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cCajaKeyReleased
        // TODO add your handling code here:
        try {
            if (cCaja.equals("")) {
                jTextField15.setText("");
            }
            else {
                float suma = Float.parseFloat(sumCheque.getText());
                float contado = Float.parseFloat(cCaja.getText());

                float diferencia = suma - contado;

                jTextField15.setText(df.format(diferencia) + "");
            }
        }
        catch (Exception e) {
        }
        total();
    }//GEN-LAST:event_cCajaKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();

        String mov = JOptionPane.showInputDialog(null, "Tipo de movimiento:");
        if (mov != null) {
            String gasto = JOptionPane.showInputDialog(null, "Cantidad:");

            modelo.addRow(new Object[]{mov, "-" + gasto, "Salida"});
            sumaGastos();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();

        String mov = JOptionPane.showInputDialog(null, "Tipo de movimiento:");
        if (mov != null) {
            String gasto = JOptionPane.showInputDialog(null, "Cantidad:");

            modelo.addRow(new Object[]{mov, gasto, "Entrada"});
            sumaGastos();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(corteCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(corteCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(corteCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(corteCaja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new corteCaja().setVisible(true);
            }
        });*/
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cCaja;
    private javax.swing.JTextField dEfectivo;
    private javax.swing.JTextField eCaja;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField labelGastos;
    private javax.swing.JLabel labelTrans;
    private javax.swing.JTextField sumCheque;
    private javax.swing.JTextField sumEfec;
    private javax.swing.JTextField sumTar;
    private javax.swing.JTextField tCaja;
    private javax.swing.JTable tablaCorte;
    private javax.swing.JTable tablaTipos;
    private javax.swing.JTable tablaTrans;
    private javax.swing.JTextField totalCaja;
    private javax.swing.JTextField totalCalculado;
    // End of variables declaration//GEN-END:variables
}
