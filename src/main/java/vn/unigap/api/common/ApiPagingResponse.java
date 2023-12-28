package vn.unigap.api.common;


import org.springframework.data.domain.Page;

import java.util.List;

public class ApiPagingResponse<T> {
    private int page;
    private int pageSize;
    private long totalElements;
    private long totalPages;
    private List<T> data;
    // Constructor to convert from Page<T>
    public ApiPagingResponse(Page<T> page) {
        this.data = page.getContent();
        this.page = page.getNumber();
        this.pageSize = page.getSize();
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
    }
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
