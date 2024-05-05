package com.github.sukieva.dodo.bean.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Error of Response
 *
 * @author SukiEva
 * @since 2024-05-05
 */
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RespError {
    private String sourceKey;

    private String errorCode;

    private String errorMessage;

    public static RespError of(String sourceKey, String errorCode, String errorMessage) {
        RespError respError = new RespError();
        respError.setSourceKey(sourceKey);
        respError.setErrorCode(errorCode);
        respError.setErrorMessage(errorMessage);
        return respError;
    }
}
