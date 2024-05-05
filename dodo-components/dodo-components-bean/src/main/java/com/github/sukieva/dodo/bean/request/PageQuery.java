package com.github.sukieva.dodo.bean.request;

import lombok.Getter;
import lombok.Setter;

/**
 * Page Query Param
 *
 * @author SukiEva
 * @since 2024-05-06
 */
@Getter
@Setter
public abstract class PageQuery extends Query {
    private static final int DEFAULT_PAGE_SIZE = 10;

    public static final String ASC = "ASC";

    public static final String DESC = "DESC";

    private int pageSize = DEFAULT_PAGE_SIZE;

    private int pageIndex = 1;

    private String orderBy;

    private String orderDirection = ASC;

    private String groupBy;

    private boolean needTotalCount = true;

    public int getPageSize() {
        return pageSize < 1 ? DEFAULT_PAGE_SIZE : pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize < 1 ? DEFAULT_PAGE_SIZE : pageSize;
    }

    public int getPageIndex() {
        return Math.max(pageIndex, 1);
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = Math.max(pageIndex, 1);
    }

    public int getOffset() {
        return (getPageIndex() - 1) * getPageSize();
    }

    public void setOrderDirection(String orderDirection) {
        if (ASC.equalsIgnoreCase(orderDirection) || DESC.equalsIgnoreCase(orderDirection)) {
            this.orderDirection = orderDirection;
        }
    }
}
