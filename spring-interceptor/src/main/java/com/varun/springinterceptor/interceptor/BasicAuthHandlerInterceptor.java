package com.varun.springinterceptor.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import static java.util.Base64.*;

public class BasicAuthHandlerInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = Logger.getLogger(BasicAuthHandlerInterceptor.class.getName());

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";
    private static final String UNAUTHORIZED = "Unauthorized";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        LOGGER.info("BasicAuthHandlerInterceptor::preHandle()");
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, UNAUTHORIZED);
            return false;
        }
        String base64Credentials = authHeader.substring("Basic ".length());
        String decodedCredentials = new String(getDecoder().decode(base64Credentials));
        String[] credentials = decodedCredentials.split(":");
        if (credentials.length != 2 || !credentials[0].equals(USERNAME) || !credentials[1].equals(PASSWORD)) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, UNAUTHORIZED);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(
        HttpServletRequest request,
        HttpServletResponse response,
        Object handler,
        ModelAndView modelAndView) throws Exception {
        LOGGER.info("BasicAuthHandlerInterceptor::postHandle()");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
        throws Exception {
        LOGGER.info("BasicAuthHandlerInterceptor::afterCompletion()");
    }
}
