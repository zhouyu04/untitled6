package com.zzyy.response;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/11/5.
 */
public class JqgridListForm implements Serializable {
    private static final long serialVersionUID = 1L;

    /* 当前页数 */
    private int page;
    /* 总页数 */
    private int total;
    /* 总计录数  */
    private long rows;

    private List<?> formList;

    public JqgridListForm() {
    }

    public JqgridListForm(int page, int total, long records, List<?> formList) {
        this.page = page;
        this.total = total;
        this.rows = records;
        this.formList = formList;
    }

    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public long getRecords() {
        return rows;
    }
    public void setRecords(long records) {
        this.rows = records;
    }
    public List<?> getFormList() {
        return formList;
    }
    public void setFormList(List<?> formList) {
        this.formList = formList;
    }
}
