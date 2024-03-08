import org.junit.Test;
import static org.junit.Assert.*;

public class ShirtTest {

    @Test
    public void testGettersAndSetters() {
        Shirt shirt = new Shirt("shirt", 20, "S", "navy", 31.3, 29.0);

        assertEquals("shirt", shirt.getName());
        assertEquals(20, shirt.getQuantity());
        assertEquals("S", shirt.getSize());
        assertEquals("navy", shirt.getColor());
        assertEquals(31.3, shirt.getLengthSize(), 0);
        assertEquals(29.0, shirt.getSleeveLength(), 0);

        shirt.setName("newName");
        shirt.setQuantity(19);
        shirt.setSize("newSize");
        shirt.setColor("newColor");
        shirt.setLengthSize(33.0);
        shirt.setSleeveLength(30.0);

        assertEquals("newName", shirt.getName());
        assertEquals(19, shirt.getQuantity());
        assertEquals("newSize", shirt.getSize());
        assertEquals("newColor", shirt.getColor());
        assertEquals(33.0, shirt.getLengthSize(), 0);
        assertEquals(30.0, shirt.getSleeveLength(), 0);
    }

    @Test
    public void testToString() {
        Shirt shirt = new Shirt("shirt", 20, "S", "navy", 31.3, 29.0);
        assertEquals("Shirt{ClothingItem{name='shirt', quantity=20, size='S', color='navy'}, lengthSize=31.3, sleeveLength=29.0}", shirt.toString());
    }
}