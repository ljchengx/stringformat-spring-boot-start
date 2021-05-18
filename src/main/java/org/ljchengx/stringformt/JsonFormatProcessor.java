package org.ljchengx.stringformt;

import com.alibaba.fastjson.JSON;

/**
 * @author ljchengx
 * @date 2021/5/18 11:04
 */
public class JsonFormatProcessor implements FormatProcessor{

    public <T> String format(T obj) {
        return JSON.toJSONString(obj);
    }
}
