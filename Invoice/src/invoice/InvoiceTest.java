/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoice;

/**
 *
 * @author Chris
 */
public class InvoiceTest {
    
    public static void main(String[] args) {
        
        Invoice invoice = new Invoice("1.0", "Does a thing", 3, 1.0);
        
        double invoice_amount;
        
        invoice.getPart();
        invoice.getDesc();
        invoice.getQuant();
        invoice.getPrice();
        
        invoice.setPartNum("2.0");
        invoice.setPartDescr("Doesn't do the thing");
        invoice.setQuantity(20);
        invoice.setPrice(20.00);
        
        invoice.getPart();
        invoice.getDesc();
        invoice.getQuant();
        invoice.getPrice();
        
        invoice_amount = invoice.getInvoiceAmount();
        
        invoice.setQuantity(-20);
        invoice.setPrice(-20.00);
        
        invoice_amount = invoice.getInvoiceAmount();
    }
}
