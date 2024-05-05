package com.github.sukieva.dodo.bean.response.resp;

import com.github.sukieva.dodo.bean.response.PageInfo;
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
 * Response with batch paged record
 *
 * @author SukiEva
 * @since 2024-05-05
 */
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PageResp<T> extends Response {
    private PageInfo page;

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

    public static <T> PageResp<T> of(RespStatus status, Collection<RespError> errors, Collection<T> data, PageInfo page) {
        PageResp<T> pageResp = new PageResp<>();
        pageResp.setStatus(status);
        pageResp.setErrors(errors);
        pageResp.setData(data);
        pageResp.setPage(page);
        return pageResp;
    }

    public static <T> PageResp<T> success(Collection<T> data, PageInfo page) {
        return of(RespStatus.SUCCESS, Collections.emptyList(), data, page);
    }

    public static <T> PageResp<T> partialSuccess(Collection<RespError> errors, Collection<T> data, PageInfo page) {
        return of(RespStatus.PARTIAL_SUCCESS, errors, data, page);
    }

    public static <T> PageResp<T> fail(Collection<RespError> errors, PageInfo page) {
        return of(RespStatus.FAIL, errors, Collections.emptyList(), page);
    }
}
