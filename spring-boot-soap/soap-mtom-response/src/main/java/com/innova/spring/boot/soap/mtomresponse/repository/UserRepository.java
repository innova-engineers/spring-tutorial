package com.innova.spring.boot.soap.mtomresponse.repository;

import com.innova.spring.boot.soap.mtomresponse.models.user.ProfilePicture;
import com.innova.spring.boot.soap.mtomresponse.models.user.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Component
public class UserRepository {

    private static final String PROFILE_PICTURE_PATH = "E:/soap_mtom/";
    private static final Map<Integer, User> USER_MAP = new HashMap<>();

    @PostConstruct
    public void init() {
        User user = new User();
        ProfilePicture pic = new ProfilePicture();
        user.setId(1);
        user.setFirstname("Toni");
        user.setLastname("Kroos");
        try {
            pic.setName(user.getId() + "_" + user.getFirstname() + ".jpeg");
            pic.setContent(ImageIO.read(new File(PROFILE_PICTURE_PATH + user.getId() + ".jpeg")));
            user.setProfilePicture(pic);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        USER_MAP.put(user.getId(), user);
    }

    public User getUserById(int id) {
        return USER_MAP.get(id);
    }
}
