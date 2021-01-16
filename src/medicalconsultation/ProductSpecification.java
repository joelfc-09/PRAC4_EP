package medicalconsultation;

import data.ProductID;
import exceptions.NullArgumentException;

import java.math.BigDecimal;

public class ProductSpecification {
    public ProductID UPCcode;
    public String description;
    public BigDecimal price;

    public ProductSpecification(ProductID UPCcode, String description, BigDecimal price) throws NullArgumentException {
        if (UPCcode == null || description == null || price == null) {
            throw new NullArgumentException();
        }
        this.UPCcode = UPCcode;
        this.description = description;
        this.price = price;
    }

    // Getters and Setters
    public ProductID getUPCcode() { return UPCcode; }

    public void setUPCcode(ProductID UPCcode) { this.UPCcode = UPCcode; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public BigDecimal getPrice() { return price; }

    public void setPrice(BigDecimal price) { this.price = price; }
}