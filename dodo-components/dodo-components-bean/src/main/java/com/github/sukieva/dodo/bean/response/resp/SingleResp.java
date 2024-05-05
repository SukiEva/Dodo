package com.github.sukieva.dodo.bean.response.resp;

import com.github.sukieva.dodo.bean.response.RespError;
import com.github.sukieva.dodo.bean.response.RespStatus;
import com.github.sukieva.dodo.bean.response.Response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.Collections;

/**
 * Response with single record
 *
 * @author SukiEva
 * @since 2024-05-05
 */
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SingleResp<T> extends Response {
    private T data;

    public static <T> SingleResp<T> of(RespStatus status, Collection<RespError> errors, T data) {
        SingleResp<T> singleResp = new SingleResp<>();
        singleResp.setStatus(status);
        singleResp.setErrors(errors);
        singleResp.setData(data);
        return singleResp;
    }

    public static <T> SingleResp<T> success(T data) {
        return of(RespStatus.SUCCESS, Collections.emptyList(), data);
    }

    public static <T> SingleResp<T> partialSuccess(Collection<RespError> errors, T data) {
        return of(RespStatus.PARTIAL_SUCCESS, errors, data);
    }

    public static <T> SingleResp<T> fail(Collection<RespError> errors) {
        return of(RespStatus.FAIL, errors, null);
    }
}
