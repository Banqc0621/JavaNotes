package com.example.exception;

// 自定义异常类
class MyCustomException extends Exception {
    public MyCustomException() {
        super();
    }

    public MyCustomException(String message) {
        super(message);
    }

    public MyCustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyCustomException(Throwable cause) {
        super(cause);
    }
}

// 使用自定义异常的示例
class CustomExceptionExample {
    public static void main(String[] args) {
        try {
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (MyCustomException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static int divide(int dividend, int divisor) throws MyCustomException {
        if (divisor == 0) {
            throw new MyCustomException("Division by zero is not allowed");
        }
        return dividend / divisor;
    }
}
