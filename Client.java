import com.zeroc.Ice.*;

public class Client {
    public static void main(String[] args) {
        try (Communicator communicator = Util.initialize(args)) {

            // ── Printer ──────────────────────────────────────────────
            ObjectPrx base = communicator.stringToProxy(
                "SimplePrinter:default -h 127.0.0.1 -p 11000");
            Demo.PrinterPrx printer = Demo.PrinterPrx.checkedCast(base);
            if (printer == null) throw new Error("Invalid proxy (Printer)");

            System.out.println(printer.printString("Hello from Java!"));
            System.out.println(printer.printUpperCase("hello from java!"));
            System.out.println(printer.countChars("Hello"));

            // ── Calculator ───────────────────────────────────────────
            ObjectPrx baseCalc = communicator.stringToProxy(
                "SimpleCalculator:default -h 127.0.0.1 -p 11000");
            Demo.CalculatorPrx calc = Demo.CalculatorPrx.checkedCast(baseCalc);
            if (calc == null) throw new Error("Invalid proxy (Calculator)");

            System.out.println("3 + 4 = " + calc.add(3, 4));
            System.out.println("10 - 6 = " + calc.subtract(10, 6));
            System.out.println("5 * 7 = " + calc.multiply(5, 7));

        } catch (LocalException e) {
            e.printStackTrace();
        }
    }
}