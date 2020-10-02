package com.dangvandat.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AbstractDTO<T> {
	
	private Long id;
    private String createdBy;
    private String modifiedBy;
    private Timestamp createdDate;
    private Timestamp modifiedDate;
    private int maxPageItem;
    private int page;
    private String action;
    private List<T> listResult = new ArrayList<T>();
    private Long[] ids;
    private Integer totalItems = 0;
    private Integer totalPage = 0;
    private String sortName;
    private String sortBy;

	public Long getId() {
		return id;
	}
    public void setId(Long id) {
        this.id = id;
    }
    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public String getModifiedBy() {
        return modifiedBy;
    }
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
    public Timestamp getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }
    public Timestamp getModifiedDate() {
        return modifiedDate;
    }
    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
    public int getMaxPageItem() {
        return maxPageItem;
    }
    public void setMaxPageItem(int maxPageItem) {
        this.maxPageItem = maxPageItem;
    }
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }
    public List<T> getListResult() {
        return listResult;
    }
    public void setListResult(List<T> listResult) {
        this.listResult = listResult;
    }
    public Long[] getIds() {
        return ids;
    }
    public void setIds(Long[] ids) {
        this.ids = ids;
    }
    public Integer getTotalItems() {
        return totalItems;
    }
    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }
    public Integer getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
    public String getSortName() {
        return sortName;
    }
    public void setSortName(String sortName) {
        this.sortName = sortName;
    }
    public String getSortBy() {
        return sortBy;
    }
    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }
}
