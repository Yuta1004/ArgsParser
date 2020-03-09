import argsparser.ArgsParser;

class Test {

    public static void main(String[] args) {
        createInstance();
        parseTest1();
    }

    private static void createInstance() {
        String args[] = {"a", "b", "c"};
        ArgsParser parser = new ArgsParser(args);
        check("CreateInstance", true, true);
    }

    private static void parseTest1() {
        String args[] = {"-a", "banana", "--b", "apple"};
        ArgsParser parser = new ArgsParser(args);
        check("ParseTest1", true, true);
    }

    private static <T> void check(String msg, T a, T b) {
        if(a.equals(b))
            System.out.println(msg + ": OK");
        else
            System.out.println(msg + ": NG (" + a + " != " + b + ")");
    }

}
