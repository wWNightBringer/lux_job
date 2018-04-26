package job.bespalov.calc;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CalcFirstFileTest {
    private CalcFile calcFirstFile;

    public CalcFirstFileTest() {
        calcFirstFile=new CalcFile();
    }

    @Before
    void init(){
        calcFirstFile=new CalcFile();
    }
    @After
    void clear(){
        calcFirstFile=null;
    }
    @Test
    void longestLine() throws IOException {
        String expect="Following";
        assertEquals(expect,calcFirstFile.longestLine("Hello").toLowerCase());
    }

    @Test
    void shortestLine() throws IOException {
        String expect="Following";
        assertEquals(expect,calcFirstFile.shortestLine("Following Dumbledore,"));
    }

    @Test
    void lineLength() throws IOException {
        int expect=10;
        assertEquals(expect,calcFirstFile.lineLength("Voldemort consolidates his"));
    }
    @Ignore
    @Test
    void averageWord() throws IOException {
        int expect=8;
        assertEquals(expect,calcFirstFile.averageWord("Voldemort consolidates his"));
    }

}