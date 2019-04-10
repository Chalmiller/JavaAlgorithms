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
public class Invoice {

    private String partNumber;
    private String partDescriptor;
    private int quantity;
    private double pricePerItem;
    
    public Invoice(String partNum, String partDesc, int quant, double price) {
        partNumber = partNum;
        partDescriptor = partDesc;
        quantity = quant;
        pricePerItem = price;
    }  
    
    // Getters
    public String getPart() {
        System.out.printf("partNumber: %s\n",partNumber);
        return partNumber;
    }
    public String getDesc() {
        System.out.printf("partDescriptor: %s\n", partDescriptor);
        return partDescriptor;
    }
    public int getQuant() {
        System.out.printf("quantity: %s\n", quantity);
        return quantity;
    } 
    public double getPrice() {
        System.out.printf("pricePeritem: %s\n", pricePerItem);
        return pricePerItem;
    }
    
    //Setters
    public void setPartNum( String num ) {
        partNumber = num;
    }
    public void setPartDescr( String desc ) {
        partDescriptor = desc;
    }
    public void setQuantity( int quant ) {
        quantity = quant;
    }
    public void setPrice( double price ) {
        pricePerItem = price;
    }
    
    public double getInvoiceAmount() {
        double invoice;
        
        if (quantity < 0) {
            setQuantity(0);
        } else if (pricePerItem < 0){
            setPrice(0.0);
        }
        
        invoice = quantity * pricePerItem;
        
        System.out.printf("Invoice Cost: %s\n", invoice);
        
        return invoice;
    }
}
