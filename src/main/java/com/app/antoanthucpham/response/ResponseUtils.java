package com.app.antoanthucpham.response;

import org.springframework.http.ResponseEntity;

public class ResponseUtils {
    public static ResponseEntity<ApiResponse> ok(Object data) {
        return ResponseEntity.ok(new ApiResponse("Success", data));
    }
}
