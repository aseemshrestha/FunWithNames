import com.names.score.calculator.AppFileReader;
import com.names.score.calculator.CharToNumberMapper;
import com.names.score.calculator.ScoreCalculator;
import exceptions.FileNameNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AppFileReaderTest {

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    /* throw exception when fileName is empty */
    @Test(expected = FileNameNotFoundException.class)
    public void testGetFileFromUser() throws FileNameNotFoundException {
        systemInMock.provideLines(StringUtils.EMPTY);
        AppFileReader appFileReader = new AppFileReader();
        String fileNameFromUser = appFileReader.getFileNameFromUser();
    }

    @Test
    public void testSortList() {
        List<String> input = Arrays.asList("bbb", "ccc", "aaa");
        List<String> expected = Arrays.asList("aaa", "bbb", "ccc");
        AppFileReader appFileReader = new AppFileReader();
        appFileReader.sortList(input);
        assertTrue(input.equals(expected));
    }

    @Test
    public void testFileDoesntExist() {
        String file = "src/test/resources/test1.txt";
        AppFileReader appFileReader = new AppFileReader();
        assertFalse(appFileReader.doesFileExist(file));
    }

    @Test
    public void testFileExist() {
        String file = "src/test/resources/test.txt";
        AppFileReader appFileReader = new AppFileReader();
        assertTrue(appFileReader.doesFileExist(file));
    }

    @Test(expected = IOException.class)
    public void testReadFile_FileNotFound() throws FileNameNotFoundException, IOException {
        String file = "src/test/resources/test.txt1";
        systemInMock.provideLines(file);
        AppFileReader appFileReader = new AppFileReader();
        List<String> strings = appFileReader.readFile();
    }

    @Test
    public void testReadFile() throws Exception {
        String file = "src/test/resources/test.txt";
        systemInMock.provideLines(file);
        AppFileReader appFileReader = new AppFileReader();
        ScoreCalculator scoreCalculator = new ScoreCalculator();
        Assert.assertEquals(3194, scoreCalculator.calculateScore(appFileReader.readFile()));
    }

    @Test
    public void testCharToNumberMapper() throws Exception {
        int a = CharToNumberMapper.getIntFromMap('A');
        assertEquals(a, 1);
        int b = CharToNumberMapper.getIntFromMap('B');
        assertEquals(b, 2);
        int c = CharToNumberMapper.getIntFromMap('C');
        assertEquals(c, 3);
    }

    @Test(expected = Exception.class)
    public void testCharToNumberMapperNotFound() throws Exception {
        int a = CharToNumberMapper.getIntFromMap('@');
        assertEquals(a, 1);
    }
}

