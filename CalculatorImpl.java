import com.zeroc.Ice.Current;

public class CalculatorImpl implements Demo.Calculator {

    @Override
    public int add(int a, int b, Current current) {
        int result = a + b;
        System.out.println("[add] " + a + " + " + b + " = " + result);
        return result;
    }

    @Override
    public int subtract(int a, int b, Current current) {
        int result = a - b;
        System.out.println("[subtract] " + a + " - " + b + " = " + result);
        return result;
    }

    @Override
    public int multiply(int a, int b, Current current) {
        int result = a * b;
        System.out.println("[multiply] " + a + " * " + b + " = " + result);
        return result;
    }
}