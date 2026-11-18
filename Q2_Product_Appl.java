/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.q2_product_appl;

/**
 *
 * @author Student
 */
//public class Q2_Product_Appl {

    //public static void main(String[] args) {
        //System.out.println("Hello World!");
   // }
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class Q2_Product_Appl extends JFrame {

    private JTextField txtCustomerName;
    private JComboBox<String> cmbProduct;
    private JTextField txtPrice;
    private JButton btnProcess;

    private JMenuItem mnuExit;
    private JMenuItem mnuProcess;
    private JMenuItem mnuClear;

    public Q2_Product_Appl() {
        setTitle("Product App");
        setSize(450, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 15));

        // Q2.4 - Menu System
        JMenuBar menuBar = new JMenuBar();

        JMenu mnuFile = new JMenu("File");
        mnuExit = new JMenuItem("Exit");
        mnuFile.add(mnuExit);

        JMenu mnuTools = new JMenu("Tools");
        mnuProcess = new JMenuItem("Process");
        mnuClear = new JMenuItem("Clear");
        mnuTools.add(mnuProcess);
        mnuTools.add(mnuClear);

        menuBar.add(mnuFile);
        menuBar.add(mnuTools);
        setJMenuBar(menuBar);

        // Q2.2 - Form controls
        add(new JLabel("Customer Name:"));
        txtCustomerName = new JTextField();
        add(txtCustomerName);

        add(new JLabel("Select Product:"));
        cmbProduct = new JComboBox<>(new String[]{
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        });
        add(cmbProduct);

        add(new JLabel("Enter Price:"));
        txtPrice = new JTextField();
        add(txtPrice);

        add(new JLabel("")); // empty for layout
        btnProcess = new JButton("PROCESS");
        add(btnProcess);

        // Q2.3 + Q2.4 - Button and Menu actions all call processSale()
        btnProcess.addActionListener(e -> processSale());
        mnuProcess.addActionListener(e -> processSale());

        mnuClear.addActionListener(e -> {
            txtCustomerName.setText("");
            txtPrice.setText("");
            cmbProduct.setSelectedIndex(0);
        });

        mnuExit.addActionListener(e -> System.exit(0));
    }

    private void processSale() {
        try {
            String customerName = txtCustomerName.getText();
            String productName = (String) cmbProduct.getSelectedItem();
            double price = Double.parseDouble(txtPrice.getText());

            ProductCalculations calc = new ProductCalculations(price);
            double vat = calc.GetVat();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            // Show Message Dialog - same as sample screenshot
            String message = "Customer Name: " + customerName + "\n"
                    + "Product: " + productName + "\n"
                    + "VAT: R " + vat + "\n"
                    + "COMMISSION: R " + commission + "\n"
                    + "TOTAL: R " + total;

            JOptionPane.showMessageDialog(this, message, "Message",
                    JOptionPane.INFORMATION_MESSAGE);

            // Q2.3 - Save to data.txt
            try (FileWriter writer = new FileWriter("data.txt", true)) {
                writer.write("DATA LOG\n");
                writer.write("************************************\n");
                writer.write("Customer Name: " + customerName + "\n");
                writer.write("Product: " + productName + "\n");
                writer.write("VAT: R " + vat + "\n");
                writer.write("COMMISSION: R " + commission + "\n");
                writer.write("TOTAL: R " + total + "\n");
                writer.write("************************************\n");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error writing to file: " + ex.getMessage());
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid price.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Q2_Product_Appl().setVisible(true);
        });
    }
}

