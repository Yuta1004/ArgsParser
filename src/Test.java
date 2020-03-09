import argsparser.ArgsParser;

class Test {

    public static void main(String[] args) {
        createInstance();
        parseTest1();
        parseTest2();
    }

    private static void createInstance() {
        String args[] = {"a", "b", "c"};
        ArgsParser parser = new ArgsParser(args);
        check("CreateInstance", true, true);
    }

    private static void parseTest1() {
        String args[] = {"-a", "banana", "--b", "apple"};
        ArgsParser parser = new ArgsParser(args);
        check("ParseTest1-1", parser.hasTag("a"));
        check("ParseTest1-2", parser.hasTag("b"));
        check("ParseTest1-3", parser.hasTag("-a"));
        check("ParseTest1-4", parser.hasTag("c"));
    }

    private static void parseTest2() {
        String args[] = {"-a", "pineapple", "melon", "--b", "--c", "lemon"};
        ArgsParser parser = new ArgsParser(args);
        check("ParseTest2-1", parser.getValue("a"), "pineapple");
        check("ParseTest2-2", parser.getValue("b"), "");
        check("ParseTest2-3", parser.getValue("c"), "lemon");
        check("ParseTest2-4", parser.getValue("d"), "");
    }

    private static void check(String msg, boolean a) {
        if(a)
            System.out.println(msg + ": OK");
        else
            System.out.println(msg + ": NG");
    }

    private static <T> void check(String msg, T a, T b) {
        if(a.equals(b))
            System.out.println(msg + ": OK");
        else
            System.out.println(msg + ": NG (" + a + " != " + b + ")");
    }

}
