package argsparser;

import javax.management.BadStringOperationException;

/**
 * ArgsParser
 * 引数をパースして扱いやすくする
 */
public class ArgsParser {

    private String args[];

    /**
     * コンストラクタ
     */
    public ArgsParser(String[] args) {
        this.args = args;
    }

    /**
     * 接頭語を除いた文字列を返す
     * 対象文字列がprefixから始まらない場合は例外を投げる
     *
     * @param target 対象文字列
     * @param prefix 接頭語
     * @throws BadStringOperationException
     */
    private String exclusionPrefix(String target, String prefix) throws BadStringOperationException {
        if(target.startsWith(prefix)) {
            return exclusionPrefix(target, prefix.length());
        } else {
            throw new BadStringOperationException("\"target("+target+")\" no match \"prefix("+prefix+")\"");
        }
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
