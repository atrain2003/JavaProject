import org.junit.Test;
import static org.junit.Assert.*;

public class PantTest {

    @Test
    public void testGettersAndSetters() {
        Pant pant = new Pant("jeans", 3, "32/32", "blue", 32.0, 32.0);

        assertEquals("jeans", pant.getName());
        assertEquals(3, pant.getQuantity());
        assertEquals("32/32", pant.getSize());
        assertEquals("blue", pant.getColor());
        assertEquals(32.0, pant.getWaistSize(), 0);
        assertEquals(32.0, pant.getInseamLength(), 0);

        pant.setName("newName");
        pant.setQuantity(5);
        pant.setSize("newSize");
        pant.setColor("newColor");
        pant.setWaistSize(33.0);
        pant.setInseamLength(31.0);

        assertEquals("newName", pant.getName());
        assertEquals(5, pant.getQuantity());
        assertEquals("newSize", pant.getSize());
        assertEquals("newColor", pant.getColor());
        assertEquals(33.0, pant.getWaistSize(), 0);
        assertEquals(31.0, pant.getInseamLength(), 0);
    }

    @Test
    public void testToString() {
        Pant pant = new Pant("jeans", 3, "32/32", "blue", 32.0, 32.0);
        assertEquals("Pant{ClothingItem{name='jeans', quantity=3, size='32/32', color='blue'}, waistSize=32.0, inseamLength=32.0}", pant.toString());
    }
}