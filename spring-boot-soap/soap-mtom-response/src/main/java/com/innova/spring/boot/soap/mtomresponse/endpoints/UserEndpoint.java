package com.innova.spring.boot.soap.mtomresponse.endpoints;

import com.innova.spring.boot.soap.mtomresponse.repository.UserRepository;
import com.innova.spring.boot.soap.mtomresponse.models.user.GetUserRequest;
import com.innova.spring.boot.soap.mtomresponse.models.user.GetUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Created by Innova on 24-06-2018.
 */
@Endpoint
public class UserEndpoint {
    private static final String NAMESPACE_URI = "http://innova.com/spring/boot/soap/mtomresponse/models/user";

    private UserRepository userRepository;

    @Autowired
    public UserEndpoint(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUser(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        response.setUser(userRepository.getUserById(request.getId()));

        return response;
    }
}
