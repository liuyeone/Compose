package com.example.common.aop;

import com.example.common.dao.ErrorRecordMapper;
import com.example.common.entity.ErrorRecord;
import com.example.common.exception.CustomException;
import com.example.mysql.config.DataSourceContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerExceptionAspect {

    @Autowired
    private ErrorRecordMapper errorRecordMapper;

    // 切点表达式以及通知类型
    @Around("execution(* com.example.*.controller.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws CustomException { // 通过joinPoint对象获取参数以及其他对象信息
        Object result;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            ErrorRecord errorRecord = new ErrorRecord();

            String methodName = joinPoint.getSignature().getName();
            errorRecord.setMethodName(methodName);

            Object[] args = joinPoint.getArgs();
            String argString = "";
            for (Object ob : args) {
                argString += ob + ",";
            }
            errorRecord.setMethodArgs(argString);

            String typeName = joinPoint.getSignature().getDeclaringTypeName();

            errorRecord.setErrorInfo(typeName + ":" + methodName + ":" + e.getMessage());
            this.insertIntoMysql(errorRecord);

            throw new CustomException(e.getMessage(), methodName, e.getLocalizedMessage());
        }
        return result;
    }

    public void insertIntoMysql(ErrorRecord errorRecord){
        DataSourceContextHolder.setDB("local");
        errorRecordMapper.insert(errorRecord);
        DataSourceContextHolder.clearDB();
    }
}
