package org.ljchengx.stringformt;

/**
 * @author ljchengx
 * @date 2021/5/18 11:02
 */
public interface FormatProcessor {

    /**
     * 类型转换
     *
     * @param obj: 参数
     */
    <T> String format(T obj);
}
