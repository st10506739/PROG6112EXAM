/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
//public class Product {
    public class Product implements IProduct {

    private String[] products;
    private int[][] sales; // sales[product][month]

    public Product(String[] products, int[][] sales) {
        this.products = products;
        this.sales = sales;
    }

    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                total += sales[i][j];
            }
        }
        return total;
    }

    @Override
    public double GetAverageProductSold() {
        int total = GetTotalProductsSold();
        int count = sales.length * sales[0].length; // 3 x 3 = 9
        return (double) total / count;
    }

    @Override
    public String GetMostPopularProduct() {
        int maxTotal = -1;
        int maxIndex = 0;
        for (int i = 0; i < sales.length; i++) {
            int productTotal = 0;
            for (int j = 0; j < sales[i].length; j++) {
                productTotal += sales[i][j];
            }
            if (productTotal > maxTotal) {
                maxTotal = productTotal;
                maxIndex = i;
            }
        }
        return products[maxIndex];
    }

    public int GetMostPopularProductSales() {
        int maxTotal = -1;
        for (int i = 0; i < sales.length; i++) {
            int productTotal = 0;
            for (int j = 0; j < sales[i].length; j++) {
                productTotal += sales[i][j];
            }
            if (productTotal > maxTotal) {
                maxTotal = productTotal;
            }
        }
        return maxTotal;
    }
}  
//}
