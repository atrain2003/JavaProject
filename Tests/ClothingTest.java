import org.junit.Test;
import static org.junit.Assert.*;

public class ClothingTest {

    @Test
    public void testGettersAndSetters() {
        ClothingItem item = new ClothingItem("clothingitem", 15, "M", "black");

        assertEquals("clothingitem", item.getName());
        assertEquals(15, item.getQuantity());
        assertEquals("M", item.getSize());
        assertEquals("black", item.getColor());

        item.setName("newName");
        item.setQuantity(16);
        item.setSize("newSize");
        item.setColor("newColor");

        assertEquals("newName", item.getName());
        assertEquals(16, item.getQuantity());
        assertEquals("newSize", item.getSize());
        assertEquals("newColor", item.getColor());
    }

    @Test
    public void testToString() {
        ClothingItem item = new ClothingItem("clothingitem", 15, "M", "black");
        assertEquals("ClothingItem{name='clothingitem', quantity=15, size='M', color='black'}", item.toString());
    }
}