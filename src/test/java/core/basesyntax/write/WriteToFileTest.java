package core.basesyntax.write;

import core.basesyntax.order.Order;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class WriteToFileTest {
    WriteToFile writeToFile = new WriteToFile();

    @Test
    public void standartWriteTest() {
        writeToFile.writingToFile();
        try {
            List<String> expected = new ArrayList<>(Files.readAllLines(Path.of("src/test/resources/expectedFile.csv")));
            List<String> actual = new ArrayList<>(Files.readAllLines(Path.of("src/test/resources/normalWriteTest.csv")));
            Assert.assertEquals(expected, actual);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
