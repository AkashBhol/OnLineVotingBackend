package com.example.ElectronicVotingSyatem.Config;
import com.example.ElectronicVotingSyatem.DTO.Result;
import java.util.Objects;

public class BsicUtil {
    public static Result prepareResponseObject(String code, String message, Object responseData) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
//        if (responseData) {
//            result.setData(null);
//        } else {
        result.setData(responseData);
//        }
        return result;
    }

    public static boolean isNullOrEmpty(Object value) {
        return (Objects.isNull(value) || value.toString().isBlank()) ? Boolean.TRUE : Boolean.FALSE;
    }
}
