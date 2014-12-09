import org.junit.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Administrator on 2014/12/2.
 */

public class TestMock {
    @Test
    public void mock_demo_show() throws Exception {
        BufferedReader reader = mock(BufferedReader.class);
        Mockito.when(reader.readLine()).thenReturn("hello");
        //    SecondHalfParser parser = new SecondHalfParser();
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("ITEM000001", 5);
        //  String parse = parse(reader);

        // assertThat(parse, is("hello"));
        assertThat(map.get("ITEM000001"), is(5));
            verify(reader.readLine());

    }


    @Test
    public void testName() throws Exception {
        BufferedReader reader = mock(BufferedReader.class);
        Mockito.when(reader.readLine()).thenReturn("What?");

        //   DiscountParser parser = new DiscountParser();

        //    String parse = parser.parse(reader).toString();
        //  assertThat(parse, is("I have no idea"));

    }


    @Test
    public void iterator_will_return_hello_world() {
        //arrange
        Iterator i = mock(Iterator.class);
        Mockito.when(i.next()).thenReturn("Hello").thenReturn("World");
        //act
        String result = i.next() + " " + i.next();
        //assert
        assertEquals("Hello World", result);
    }

    @Test
    public void OutputStreamWriter_Closes_OutputStream_on_Close()
            throws IOException {
        OutputStream mock = mock(OutputStream.class);
        OutputStreamWriter osw = new OutputStreamWriter(mock);
        osw.close();
        verify(mock).close();
    }

}


