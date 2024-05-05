package com.github.sukieva.dodo.bean.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Page info of Response
 *
 * @author SukiEva
 * @since 2024-05-06
 */
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PageInfo {
    private int totalCount = 0;

    private int pageSize = 1;

    private int pageIndex = 1;

    public int getTotalCount() {
        return Math.max(totalCount, 0);
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = Math.max(totalCount, 0);
    }

    public int getPageSize() {
        return Math.max(pageSize, 1);
    }

    public void setPageSize(int pageSize) {
        this.pageSize = Math.max(pageSize, 1);
    }

    public int getPageIndex() {
        return Math.max(pageIndex, 1);
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = Math.max(pageIndex, 1);
    }

    public int getTotalPages() {
        return this.totalCount % this.pageSize == 0
                ? this.totalCount / this.pageSize
                : (this.totalCount / this.pageSize) + 1;
    }

    public static PageInfo of(int totalCount, int pageSize, int pageIndex) {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setTotalCount(totalCount);
        pageInfo.setPageSize(pageSize);
        pageInfo.setPageIndex(pageIndex);
        return pageInfo;
    }
}
