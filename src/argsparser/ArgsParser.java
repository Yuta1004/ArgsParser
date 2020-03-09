package argsparser;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * ArgsParser
 * 引数をパースして扱いやすくする
 */
public class ArgsParser {

    private String args[];
    private ArrayList<String> outOfGroup;
    private HashMap<String, String> matchTable;

    /**
     * コンストラクタ
     */
    public ArgsParser(String[] args) {
        this.args = args;
        outOfGroup = new ArrayList<String>();
        matchTable = new HashMap<String, String>();
        parse();
    }

    /**
     * argsのパースを行う
     */
    private void parse() {
        String prefixs[] = {"-", "--"};

        for(int idx = 0; idx < args.length; ++ idx) {
            // fetch
            String arg = args[idx], next = "";
            if(idx < args.length-1)
                next = args[idx+1];

            // check prefix
            for(String prefix: prefixs) {
                if(arg.startsWith(prefix)) {
                    String key = exclusionPrefix(arg, prefix.length());
                    matchTable.put(key, next);
                    ++ idx;
                } else {
                    outOfGroup.add(arg);
                }
            }
        }
    }

    /**
     * 接頭語がパース対象のものかチェック
     *
     * @param target 検証対象文字列
     */
    private boolean checkPrefix(String target) {
        String prefixs[] = {"-", "--"};
        for(String prefix: prefixs) {
            if(target.startsWith(prefix))
                return true;
        }
        return false;
    }

    /**
     * 接頭語を除いた文字列を返す
     *
     * @param target 対象文字列
     * @param len 接頭語の長さ
     */
    private String exclusionPrefix(String target, int len) {
        return target.substring(len, target.length());
    }

}
