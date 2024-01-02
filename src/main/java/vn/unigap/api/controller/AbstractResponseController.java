package vn.unigap.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import vn.unigap.api.common.ApiResponse;

public abstract class AbstractResponseController {
    public <T>ResponseEntity<ApiResponse<T>> responseEntity(CallbackFunction<T> callback, Integer statusCode, boolean isCreated){
        T result = callback.execute();
        ApiResponse<T> response = new ApiResponse<>();
        response.setErrorCode(0);
        response.setStatusCode(statusCode);
        response.setData(result);
        response.setMessage("Successful");
        HttpStatus status = HttpStatus.OK;
        if (isCreated){
            response.setData(null);
            status = HttpStatus.CREATED;
        }
        return new ResponseEntity<>(response, status);
    }
}
