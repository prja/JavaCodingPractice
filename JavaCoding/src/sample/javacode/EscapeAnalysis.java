package sample.javacode;

import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class EscapeAnalysis {

    private static class Foo {
        private int x;
        private static int counter;

        public Foo() {
            x = (++counter);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        System.out.println("start");
        for (int i = 0; i < 10000000; ++i) {
            Foo foo = new Foo();
        }
        TimeUnit.MINUTES.sleep(3);
        System.out.println(Foo.counter);
        
        TreeMap map= new TreeMap();
        TimeUnit.MINUTES.sleep(5);
    }
}