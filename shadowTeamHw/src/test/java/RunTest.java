import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;

public class RunTest {

    @Test
    public void testCompareXmls() throws IOException {

        FileInputStream fis1 = new FileInputStream("C:/Users/asus/Desktop/A.xml");
        FileInputStream fis2 = new FileInputStream("C:/Users/asus/Desktop/B.xml");

        BufferedReader source = new BufferedReader(new InputStreamReader(fis1));
        BufferedReader target = new BufferedReader(new InputStreamReader(fis2));

        boolean hasDifferences = CompareXML.compareXmlFiles(source, target);
        Assert.assertFalse(hasDifferences);
    }

}