package org.ljchengx.stringformt;

/**
 * @author ljchengx
 * @date 2021/5/18 11:04
 */
public class StringFormatProcessor implements FormatProcessor{

    public <T> String format(T obj) {
        return obj.toString();
    }
}
