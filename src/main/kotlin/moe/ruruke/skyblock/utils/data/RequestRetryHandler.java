package moe.ruruke.skyblock.utils.data;

import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;

/**
 * This is a basic {@code HttpRequestRetryHandler} implementation that allows each request to be retried twice after the
 * first failure.
 */
public class RequestRetryHandler implements HttpRequestRetryHandler {
    private static final int MAX_RETRY_COUNT = 2;

    @Override
    public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
        if (executionCount >= MAX_RETRY_COUNT)  {
            DataUtils.useFallbackCDN = true;
        }

        return executionCount <= MAX_RETRY_COUNT;
    }
}
