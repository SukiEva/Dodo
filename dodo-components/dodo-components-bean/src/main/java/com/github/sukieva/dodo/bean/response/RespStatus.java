package com.github.sukieva.dodo.bean.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Status of Response
 *
 * @author SukiEva
 * @since 2024-05-05
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum RespStatus {
    SUCCESS("success"),
    PARTIAL_SUCCESS("partial_success"),
    FAIL("fail");

    private final String value;
}
