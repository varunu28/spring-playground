package com.varunu28.oauthdemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Base64;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
public class HelloController {

    @Value("${CLIENT_ID}")
    private String clientId;

    @Value("${CLIENT_SECRET}")
    private String clientSecret;

    private static final String REDIRECT_URI = "http://localhost:8080/oauth2/callback";

    private final RestClient restClient;
    private final ObjectMapper objectMapper;

    public HelloController(RestClient.Builder restClientBuilder, Jackson2ObjectMapperBuilder objectMapperBuilder) {
        this.restClient = restClientBuilder.build();
        this.objectMapper = objectMapperBuilder.build();
    }

    @GetMapping("/oauth2/callback")
    public String oauth2Callback(String code, HttpServletRequest request) throws IOException {
        // Not recommended for production applications. This process should be done through Spring security
        var tokenResponse = this.restClient.post()
            .uri("https://oauth2.googleapis.com/token")
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            // "Authorization: Basic base64(client_id:client_secret)"
            .headers(h -> h.setBasicAuth(clientId, clientSecret))
            .body(
                "code=%s&redirect_uri=%s&grant_type=authorization_code"
                    .formatted(code, REDIRECT_URI)
            )
            .retrieve()
            .body(String.class);
        var decodedResponse = objectMapper.readValue(tokenResponse, Map.class);

        // This is JWT
        String idToken = decodedResponse.get("id_token").toString();

        String rawPayload = idToken.split("\\.")[1];
        var decodedPayload = Base64.getDecoder().decode(rawPayload);

        var payload = objectMapper.readValue(decodedPayload, Map.class);
        var session = request.getSession(true);
        session.setAttribute("username", payload.get("name").toString());
        session.setAttribute("attributes", payload);
        return "redirect:/";
    }

    @GetMapping("/")
    public String index(HttpServletRequest request, Model model) {
        var session = request.getSession();
        if (session != null && session.getAttribute("username") != null) {
            model.addAttribute("username", session.getAttribute("username"));
            model.addAttribute("attributes", session.getAttribute("attributes"));
            return "authenticated";
        } else {
            var loginUri = UriComponentsBuilder.fromUriString("https://accounts.google.com/o/oauth2/v2/auth")
                .queryParam("client_id", clientId)
                .queryParam("redirect_uri", REDIRECT_URI)
                .queryParam("response_type", "code")
                // Means I want an id token back along with user email and profile information
                .queryParam("scope", "openid email profile")
                .build()
                .toUriString();
            model.addAttribute("loginUri", loginUri);
            return "anonymous";
        }
    }
}
