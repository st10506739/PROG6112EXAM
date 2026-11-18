/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 1D array
        String[] products = {
            "Cozy Nights Monarch mattress",
            "Restonic Barbados mattress",
            "Sealy Phuket mattress"
        };

        // 2D array - sales[product][month]
        int[][] sales = new int[3][3];

        for (int i = 0; i < products.length; i++) {
            for (int month = 0; month < 3; month++) {
                System.out.print("Enter number of sales for month " + (month + 1)
                        + " for " + products[i] + ": ");
                sales[i][month] = input.nextInt();
            }
            System.out.println();
        }

        Product product = new Product(products, sales);
        PrintProduct print = new PrintProduct(product);
        print.PrintReport();

        input.close();
    }
}