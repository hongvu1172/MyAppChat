/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



package Server;

import java.awt.BorderLayout;
import javax.swing.DefaultListSelectionModel;
import javax.swing.ListSelectionModel;

/**
 *
 * @author LEVU
 */
public class ServerMonitor extends javax.swing.JFrame {

    ServerManager serverManager;
    ServerStatusListener statusListener;
    ClientListener clientListener;
    /** Creates new form ServerMonitor */
    public ServerMonitor(ServerManager getManager)
    {
        serverManager=getManager;
        statusListener=new MyStatusListener();
        clientListener=new MyClientListener();
        initComponents();
        createListModel();
    }

    void createListModel()
    {
        list_model=new javax.swing.DefaultListModel();
        list_online_clients = new javax.swing.JList(list_model);
        list_online_clients.setBorder(javax.swing.BorderFactory.createTitledBorder("ONLINE CLIENTS"));

        dlsm=new DefaultListSelectionModel();
        dlsm.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	list_online_clients.setSelectionModel(dlsm);
        list_panel.setLayout(new BorderLayout());
        list_panel.add(list_online_clients);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_monitor_clients = new javax.swing.JTextArea();
        list_panel = new javax.swing.JPanel();
        lb_status = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        but_start = new javax.swing.JButton();
        but_stop = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server");
        setBackground(new java.awt.Color(153, 153, 255));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        ta_monitor_clients.setEditable(false);
        ta_monitor_clients.setColumns(20);
        ta_monitor_clients.setRows(5);
        ta_monitor_clients.setBorder(javax.swing.BorderFactory.createTitledBorder("Connection information"));
        jScrollPane1.setViewportView(ta_monitor_clients);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout list_panelLayout = new javax.swing.GroupLayout(list_panel);
        list_panel.setLayout(list_panelLayout);
        list_panelLayout.setHorizontalGroup(
            list_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        list_panelLayout.setVerticalGroup(
            list_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(list_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(list_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lb_status.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lb_status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_status.setText("Server is Stoped");
        lb_status.setBorder(javax.swing.BorderFactory.createTitledBorder("Server Status"));
        lb_status.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        but_start.setBackground(new java.awt.Color(153, 255, 153));
        but_start.setText("Start");
        but_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_startActionPerformed(evt);
            }
        });

        but_stop.setBackground(new java.awt.Color(255, 153, 153));
        but_stop.setText("Stop");
        but_stop.setEnabled(false);
        but_stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                but_stopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(but_start)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(but_stop)
                .addGap(50, 50, 50))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(but_start)
                    .addComponent(but_stop))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_status, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 43, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void but_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_startActionPerformed
        // TODO add your handling code here:
        but_stop.setEnabled(true);
        but_start.setEnabled(false);
        serverManager.startServer(statusListener,clientListener);

    }//GEN-LAST:event_but_startActionPerformed

    private void but_stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_but_stopActionPerformed
        // TODO add your handling code here:
        serverManager.stopServer(statusListener);
        but_stop.setEnabled(false);
        but_start.setEnabled(true);
    }//GEN-LAST:event_but_stopActionPerformed

    class MyStatusListener implements ServerStatusListener
    {
        public void status(String message)
        {
            lb_status.setText(message);
        }
    }

    class MyClientListener implements ClientListener
    {
        public void signIn(String userName)
        {
            list_model.addElement((Object)userName);
        }
        public void signOut(String userName)
        {
            list_model.removeElement((Object)userName);
        }
        public void clientStatus(String status)
        {
            ta_monitor_clients.append(status+"\n");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton but_start;
    private javax.swing.JButton but_stop;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lb_status;
    private javax.swing.JPanel list_panel;
    public javax.swing.JTextArea ta_monitor_clients;
    // End of variables declaration//GEN-END:variables
    public javax.swing.DefaultListModel list_model;
    public javax.swing.DefaultListSelectionModel dlsm;
    public javax.swing.JList list_online_clients;
}