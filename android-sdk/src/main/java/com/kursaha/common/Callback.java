package com.kursaha.common;

/**
 * Call back for Async API operation
 */
public interface Callback<T> {
    /**
     * Called in case of success
     * @param t return type of the response
     */
    default void onSuccess(T t) {}

    /**
     * Called in case of success without response
     */
    default void onSuccess() {}

    /**
     * Called in case of failure
     */
    void onFailure();
}
