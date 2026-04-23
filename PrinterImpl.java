import com.zeroc.Ice.Current;

public class PrinterImpl implements Demo.Printer {

    @Override
    public String printString(String s, Current current) {
        System.out.println("[printString] " + s);
        return "Printed: " + s;
    }

    @Override
    public String printUpperCase(String s, Current current) {
        String result = s.toUpperCase();
        System.out.println("[printUpperCase] " + result);
        return result;
    }

    @Override
    public String countChars(String s, Current current) {
        String result = "Char count: " + s.length();
        System.out.println("[countChars] " + result);
        return result;
    }
}