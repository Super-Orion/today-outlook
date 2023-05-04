package com.orion.outlook.interceptor;

import com.orion.outlook.common.dto.ResponseDto;
import java.util.List;
import javax.annotation.Nonnull;
import javax.validation.constraints.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author WCY
 * @since 2023-05-04
 */
@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(@Nonnull MethodParameter returnType, @Nonnull Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    /**
     * {@link com.orion.outlook.config.LocaleConfiguration#extendMessageConverters(List)}
     */
    @Override
    public Object beforeBodyWrite(
        Object body,
        @Nonnull MethodParameter returnType,
        @Nonnull MediaType selectedContentType,
        @Nonnull Class<? extends HttpMessageConverter<?>> selectedConverterType,
        @Nonnull ServerHttpRequest request,
        @Nonnull ServerHttpResponse response
    ) {
        if (body instanceof ResponseDto) {
            return body;
        }
        return null;
    }
}
