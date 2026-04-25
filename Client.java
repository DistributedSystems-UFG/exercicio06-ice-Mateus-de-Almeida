import com.zeroc.Ice.*;

public class Client {
    public static void main(String[] args) {
        // 1. Initialize the Ice communicator within a try-with-resources block
        try (Communicator communicator = Util.initialize(args)) {

            // 2. Create a proxy to the remote 'Printer' object
            // Replace '10.0.0.5' with the actual IP of your ICE server
            ObjectPrx base = communicator.stringToProxy(
                "SimplePrinter:default -h 127.0.0.1 -p 11000");
            
            // 3. Downcast the proxy to the Printer interface
            Demo.PrinterPrx printer = Demo.PrinterPrx.checkedCast(base);
            if (printer == null) throw new Error("Invalid proxy (Printer)");

            // 4. Call the remote method (modificado para se adequar ao server do ex.5)
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
