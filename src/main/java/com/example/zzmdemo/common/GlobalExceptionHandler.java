package com.example.zzmdemo.common;

import com.example.zzmdemo.entity.response.FailedResponse;
import com.example.zzmdemo.entity.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhangzhiming
 * description 全局异常处理，所有的抛出异常的controller都会跑到这里
 * @date 17:42 2019/10/17
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public Response defaultErrorHandler(HttpServletResponse response, Exception e) throws Exception {
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        log.error("GLOBAL", e);
        String str = e.getMessage();
        if (e instanceof IllegalArgumentException) {
            return new FailedResponse("参数异常," + str);
        } else
//            if (e instanceof BusinessException) {
//            BusinessException be = (BusinessException) e;
//            return new FailedResponse("逻辑异常," + be.getCode() + "," + be.getMessage());
//        } else if (e instanceof PermissionCheckException) {
//            PermissionCheckException be = (PermissionCheckException) e;
//            return new FailedResponse("您没有操作权限," + be.getPerssionName() + "," + be.getOrgCode());
//        } else
            if (e instanceof HttpMediaTypeNotAcceptableException) {
                if (StringUtils.isBlank(str)) {
                    return new FailedResponse("系统程序异常(406)，请联系维护人员！");
                } else {
                    return new FailedResponse(str);
                }
            } else if (e instanceof HttpRequestMethodNotSupportedException) {

                if (StringUtils.isBlank(str)) {
                    return new FailedResponse("系统程序异常(405)，请联系维护人员！");
                } else {
                    return new FailedResponse(str);
                }

            } else if (e instanceof MissingServletRequestParameterException) {

                if (StringUtils.isBlank(str)) {
                    return new FailedResponse("系统程序异常(400)，请联系维护人员！");
                } else {
                    return new FailedResponse(str);
                }

            } else if (e instanceof HttpRequestMethodNotSupportedException || e instanceof TypeMismatchException ||
                    e instanceof HttpMessageNotReadableException) {

                if (StringUtils.isBlank(str)) {
                    return new FailedResponse("系统程序异常(405)，请联系维护人员！");
                } else {
                    return new FailedResponse(str);
                }

            } else if (e instanceof IndexOutOfBoundsException) {

                if (StringUtils.isBlank(str)) {
                    return new FailedResponse("系统程序异常(数组异常)，请联系维护人员！");
                } else {
                    return new FailedResponse(str);
                }

            } else if (e instanceof NoSuchMethodException) {

                if (StringUtils.isBlank(str)) {
                    return new FailedResponse("系统程序异常(未知方法异常)，请联系维护人员！");
                } else {
                    return new FailedResponse(str);
                }

            } else if (e instanceof IOException) {
                if (StringUtils.isBlank(str)) {
                    return new FailedResponse("系统程序异常(IO异常)，请联系维护人员！");
                } else {
                    return new FailedResponse(str);
                }

            } else if (e instanceof ClassCastException) {

                if (StringUtils.isBlank(str)) {
                    return new FailedResponse("系统程序异常(类型转换异常)，请联系维护人员！");
                } else {
                    return new FailedResponse(str);
                }

            } else if (e instanceof NullPointerException) {

                if (StringUtils.isBlank(str)) {
                    return new FailedResponse("系统程序异常(空指针异常)，请联系维护人员！");
                } else {
                    return new FailedResponse(str);
                }
            } else if (e instanceof RuntimeException) {

                if (StringUtils.isBlank(str)) {
                    return new FailedResponse("系统程序异常(运行时异常)，请联系维护人员！");
                } else {
                    return new FailedResponse(str);
                }
            } else {

                if (StringUtils.isBlank(str)) {
                    return new FailedResponse("无法处理的系统异常");
                } else {
                    return new FailedResponse(str);
                }
            }
    }

}
