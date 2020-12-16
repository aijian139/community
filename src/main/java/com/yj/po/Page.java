package com.yj.po;

/**
 * 分页对象
 */
public class Page {


    // 当前页
    private Integer current = 1;

    // 每页大小
    private Integer limit = 10;

    // 总条数
    private Integer rows;

    // 总页数
    private Integer total;

    // 查询的路径（用于复用分页连接）
    private String path;

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        if(current>=1) {
            this.current = current;
        }
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        if(limit >=1) {
            this.limit = limit;
        }
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        if(rows>=1) {
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取每一页的起始行
     */
    public int getOffset(){
        return (current-1)*limit;
    }

    /**
     * 获取总页数
     */
    public int getTotal(){
        int total = (rows%limit == 0) ? (rows/limit) : (rows/limit)+1;
        return total;
    }

    /**
     * 获取起始页码
     */
    public int getFrom() {
        int from = current - 2;
        return from < 1 ? 1 : from;
    }
    /**
     * 获取结束页码
     */
    public int getTo(){
        int to = current + 2;
        return to < getTotal() ? to : getTotal();
    }

}
