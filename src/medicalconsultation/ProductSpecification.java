package medicalconsultation;

import data.ProductID;

import java.math.BigDecimal;

public class ProductSpecification {
    public ProductID UPCcode;
    public String description;
    public BigDecimal price;

    public ProductSpecification(ProductID UPCcode, String description, BigDecimal price) {
        this.UPCcode = UPCcode;
        this.description = description;
        this.price = price;
    }

    public ProductID getProductID() { return UPCcode; }

    public String getDescription() { return description; }

    public BigDecimal getPrice() { return price; }
}