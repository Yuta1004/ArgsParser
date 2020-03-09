import argsparser.ArgsParser;

class Main {

    public static void main(String[] args) {
        ArgsParser parser = new ArgsParser(args);
        System.out.println("NonMappedValues");
        for(String value: parser.getNonMappedValues())
            System.out.println("  - "+value);
    }

}
