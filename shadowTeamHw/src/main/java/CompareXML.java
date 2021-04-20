import java.io.*;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.diff.Diff;

public class CompareXML {

    public static boolean compareXmlFiles(BufferedReader source, BufferedReader target) {

        Diff diff = DiffBuilder.compare(source).withTest(target)
                .checkForSimilar()
                .ignoreWhitespace()
                .ignoreComments()
                .build();

        return diff.hasDifferences();
    }
}