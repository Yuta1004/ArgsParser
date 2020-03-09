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
        check("ParseTest1-1", parser.hasTag("a"), true);
        check("ParseTest1-2", parser.hasTag("b"), true);
        check("ParseTest1-3", parser.hasTag("-a"), false);
        check("ParseTest1-4", parser.hasTag("c"), false);
    }

    private static <T> void check(String msg, T a, T b) {
        if(a.equals(b))
            System.out.println(msg + ": OK");
        else
            System.out.println(msg + ": NG (" + a + " != " + b + ")");
    }

}
