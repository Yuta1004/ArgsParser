class Test {

    public static void main(String[] args) {
    }

    private static <T> void check(String msg, T a, T b) {
        if(a.equals(b))
            System.out.println(msg + ": OK");
        else
            System.out.println(msg + ": NG (" + a + " != " + b + ")");
    }

}
