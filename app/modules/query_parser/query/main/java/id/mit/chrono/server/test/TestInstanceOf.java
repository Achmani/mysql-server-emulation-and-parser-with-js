package id.mit.chrono.server.test;

public class TestInstanceOf {

    public TestInstanceOf() {


        A a = new A();

        Object obj = new C();

        System.out.println("a instance of A: " + (a instanceof A));
        System.out.println("obj instance of A: " + (obj instanceof A));
    }

    public static void main(String[] args) {
        new TestInstanceOf();
    }



    class A{

    }

    class B extends A{

    }

    class C{

    }

}
