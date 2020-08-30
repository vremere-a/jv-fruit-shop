package core.basesyntax.read;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class ReadFileTest {
    public final static String FIRST_PATH = "src/test/resources/test_3.csv";
    public final static String SECOND_PATH = "src/test/resources/test_2.csv";
    public final static List<String> EXPECTING_RESULT_FIRST = new ArrayList<>();
    public final static String EXPECTING_RESULT_SECOND = "s,banana,100,2020-10-17";
    public final static String EXPECTING_RESULT_THIRD = "fruit, quantity";

    @Test
    public void simpleReadFileTest() {
        EXPECTING_RESULT_FIRST.add(EXPECTING_RESULT_SECOND);
        ReadFile reader = new ReadFile();
        List<String> actual = reader.readFile(FIRST_PATH);
        Assert.assertEquals(EXPECTING_RESULT_FIRST, actual);
    }

    @Test
    public void shouldFileReaderTest() {
        ReadFile reader = new ReadFile();
        String actual = reader.readFile(FIRST_PATH).get(0);
        Assert.assertEquals(EXPECTING_RESULT_SECOND, actual);
    }

    @Test(expected = RuntimeException.class)
    public void fileReaderTestFail() {
        ReadFile reader = new ReadFile();
        reader.readFile("blblblb").get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void fileReaderTestEmptyFile() {
        ReadFile reader = new ReadFile();
        String actual = reader.readFile(SECOND_PATH).get(0);
        Assert.assertEquals(EXPECTING_RESULT_THIRD, actual);
    }
}

