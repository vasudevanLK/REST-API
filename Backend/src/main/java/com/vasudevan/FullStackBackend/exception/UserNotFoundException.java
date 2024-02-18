package com.vasudevan.FullStackBackend.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(Long id){
        Super("Could Not Found The USER with ID" + id);
    }

    private void Super(String s) {
    }
}
