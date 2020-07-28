import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    @Test
    public void Test() {
        // Given
        String expected =   "name:    Milk \t\t seen: 6 times\n" +
                            "============= \t \t =============\n" +
                            "Price: \t 3.23\t\t seen: 5 times\n" +
                            "-------------\t\t -------------\n" +
                            "Price:   1.23\t\t seen: 1 time\n\n" +

                            "name:   Bread\t\t seen: 6 times\n" +
                            "=============\t\t =============\n" +
                            "Price:   1.23\t\t seen: 6 times\n" +
                            "-------------\t\t -------------\n\n" +

                            "name: Cookies     \t seen: 8 times\n" +
                            "=============     \t =============\n" +
                            "Price:   2.25        seen: 8 times\n" +
                            "-------------        -------------\n\n" +

                            "name:  Apples     \t seen: 4 times\n" +
                            "=============     \t =============\n" +
                            "Price:   0.25     \t seen: 2 times\n" +
                            "-------------     \t -------------\n" +
                            "Price:   0.23  \t \t seen: 2 times\n\n" +

                            "Errors         \t \t seen: 4 times";


        // When
        String actual = Main.readRawDataToString();

        // Then
        Assert.assertEquals(expected, actual);

    }
}
