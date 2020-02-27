package com.t0lia;

import java.util.concurrent.Callable;

class ExceptionWrapper {
    static <T> T wrap(Callable<T> fun) {
        try {
            return fun.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
