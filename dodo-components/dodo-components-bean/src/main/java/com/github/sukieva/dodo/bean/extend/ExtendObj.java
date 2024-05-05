package com.github.sukieva.dodo.bean.extend;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * ExtendObj communicate with Client
 *
 * @author SukiEva
 * @since 2024-05-06
 */
@Getter
@Setter
public abstract class ExtendObj implements IExtendable {
    protected Map<String, Object> extValues = new HashMap<>();

    @Override
    public Object getExtField(String key) {
        return extValues.getOrDefault(key, null);
    }

    @Override
    public void putExtField(String fieldName, Object value) {
        this.extValues.put(fieldName, value);
    }
}
