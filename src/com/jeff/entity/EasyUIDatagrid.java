package com.jeff.entity;

import java.util.List;

public class EasyUIDatagrid {
    // 当前页显示的数据
    private List<?> rows;
    // 表中总个数
    private long total;

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

}
