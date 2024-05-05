package com.github.sukieva.dodo.bean.extend;

import java.util.Map;

/**
 * Extend interface for Extend object
 *
 * @author SukiEva
 * @since 2024-05-06
 */
public interface IExtendable {
    Object getExtField(String key);

    void putExtField(String fieldName, Object value);

    Map<String, Object> getExtValues();

    void setExtValues(Map<String, Object> extValues);
}
