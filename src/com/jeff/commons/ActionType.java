package com.jeff.commons;

public enum ActionType {

	ADD(1, "添加操作"), 
	EDIT(2, "编辑操作"), 
	DELETE(3, "删除操作");
	
    /**
     * 主键
     */
    private final int key;
    /**
     * 描述
     */
    private final String desc;

    ActionType(final int key, final String desc) {
        this.key = key;
        this.desc = desc;
    }

    public int getKey() {
        return key;
    }

    public String getDesc() {
        return desc;
    }

}
