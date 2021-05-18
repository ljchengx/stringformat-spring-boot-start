package org.ljchengx;

import org.ljchengx.config.FormatProperties;
import org.ljchengx.stringformt.FormatProcessor;

/**
 * @author ljchengx
 * @date 2021/5/18 11:07
 */
public class FormatTemPlate {

    private FormatProcessor formatProcessor;

    private FormatProperties formatProperties;


    public FormatTemPlate(FormatProcessor formatProcessor, FormatProperties formatProperties) {
        this.formatProcessor = formatProcessor;
        this.formatProperties = formatProperties;
    }

    public <T> String doFormat(T obj) {

        return "Execute format" + "Execute format" + formatProperties.getName() + "\n" + "Obj format result: " + formatProcessor.format(obj) + "\n";
    }
}
