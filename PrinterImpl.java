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
    public int countChars(String s, Current current) { // Alterado para int
        int result = s.length(); // O tamanho da string é um int
        System.out.println("[countChars] Char count: " + result);
        return result;
    }
}