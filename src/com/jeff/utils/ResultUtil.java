package com.jeff.utils;

import com.jeff.commons.ActionType;
import com.jeff.commons.Result;

public class ResultUtil {

    public static Result renderActionResult(boolean success, ActionType optType) {
        String msg = "";
        switch (optType) {
            case ADD:
                msg = (success == true) ? "数据添加成功!" : "数据添加失败!";
                break;
            case EDIT:
                msg = (success == true) ? "数据修改成功!" : "数据修改失败!";
                break;
            case DELETE:
                msg = (success == true) ? "数据删除成功!" : "数据删除失败!";
                break;
            default:
                msg = "opt.error";
                break;
        }
        return renderResult(success, msg, null);
    }

    public static Result renderResult(boolean success, String msg, Object obj) {
        Result result = new Result();
        result.setMsg(msg);
        result.setSuccess(success);
        result.setObj(obj);
        return result;
    }

}
