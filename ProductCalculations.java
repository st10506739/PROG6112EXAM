/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.q2_product_appl;

/**
 *
 * @author Student
 */
class ProductCalculations {
    private double price;
    public ProductCalculations(double price) {
        this.price = price;
    }

   //Override
    public double GetVat() {
        return price * 0.15; // 15%
    }

    //Override
    public double GetCommission() {
        return price * 0.05; // 5%
    }

    //Override
    public double GetTotal() {
        return price + GetVat() + GetCommission();
    }
    
}
