package com.example.zzmdemo.core.response;

//import io.swagger.annotations.ApiModelProperty;

 /**
  * @author zhangzhiming
  * description  后期再考虑引入swagger
  * @date 19:15 2019/10/9
  */

public interface Response {
 	public static final String CODE_FAILED = "-1"; 
    public static final String MSG_FAILED = "failed"; 
    public static final String CODE_SUCCESS = "1"; 
    public static final String MSG_SUCCESS = "success";
    public static final String CODE_EMPTY = "0";
    public static final String MSG_EMPTY = "empty";

//    @ApiModelProperty(value = "状态码：1成功-1失败")
    String getCode();
//    @ApiModelProperty(value = "提示信息")
	String getMsg();
}
