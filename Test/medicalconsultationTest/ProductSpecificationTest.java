package medicalconsultationTest;

import exceptions.NullArgumentException;
import medicalconsultation.ProductSpecification;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductSpecificationTest {
     @Test
     public void nullTest() {
         try {
             ProductSpecification productSpecification = new ProductSpecification(null, null, null);
             fail();
         } catch (NullArgumentException e) {
             e.printStackTrace();
         }
     }
}