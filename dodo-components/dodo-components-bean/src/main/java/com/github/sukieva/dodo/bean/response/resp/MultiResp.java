package com.github.sukieva.dodo.bean.response.resp;

import com.github.sukieva.dodo.bean.response.RespError;
import com.github.sukieva.dodo.bean.response.RespStatus;
import com.github.sukieva.dodo.bean.response.Response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Response with batch record
 *
 * @author SukiEva
 * @since 2024-05-05
 */
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MultiResp<T> extends Response {
    private Collection<T> data;

    public List<T> getData() {
        if (Objects.isNull(data)) {
            return Collections.emptyList();
        }
        if (data instanceof List) {
            return (List<T>) data;
        }
        return new ArrayList<>(data);
    }

    public boolean isEmpty() {
        return Objects.isNull(data) || data.isEmpty();
    }

    public boolean isNotEmpty() {
        return !isEmpty();
    }

    public static <T> MultiResp<T> of(RespStatus status, Collection<RespError> errors, Collection<T> data) {
        MultiResp<T> multiResp = new MultiResp<>();
        multiResp.setStatus(status);
        multiResp.setErrors(errors);
        multiResp.setData(data);
        return multiResp;
    }

    public static <T> MultiResp<T> success(Collection<T> data) {
        return of(RespStatus.SUCCESS, Collections.emptyList(), data);
    }

    public static <T> MultiResp<T> partialSuccess(Collection<RespError> errors, Collection<T> data) {
        return of(RespStatus.PARTIAL_SUCCESS, errors, data);
    }

    public static <T> MultiResp<T> fail(Collection<RespError> errors) {
        return of(RespStatus.FAIL, errors, Collections.emptyList());
    }
}
