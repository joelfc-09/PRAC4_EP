package dataTest;

import data.ProductID;
import exceptions.NullArgumentException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductIDTest {
    @Test
    public void nullTest() {
        String code = null;
        try {
            ProductID productID = new ProductID(code);
            fail();
        } catch (NullArgumentException e) {
            e.printStackTrace();
        }
    }
}