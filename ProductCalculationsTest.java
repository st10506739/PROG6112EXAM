/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.q2_product_appl;

/**
 *
 * @author Student
 */

public class ProductCalculationsTest {

    // Price from sample: 3500
    // VAT = 525, Commission = 175, Total = 4200
    ProductCalculations calc = new ProductCalculations(3500);

    //Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
        assertEquals(525.0, calc.GetVat(), 0.01);
    }

    //Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        assertEquals(4200.0, calc.GetTotal(), 0.01);
    }

    //Test
    public void GetCommission_WithValidData_ReturnsCorrectValue() {
        assertEquals(175.0, calc.GetCommission(), 0.01);
    }

    private void assertEquals(double d, double GetVat, double d0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}