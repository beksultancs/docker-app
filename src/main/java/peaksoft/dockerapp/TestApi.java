package peaksoft.dockerapp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Beksultan
 */
@RestController
@ConfigurationProperties(prefix = "test")
public class TestApi {

    private String activeProfile;

    @GetMapping
    public Map<String, String> isWorking() {
        return Map.of(
                "WORKING", "true"
        );
    }

    @GetMapping("/test")
    public String welcomeToPeaksoft() {
        return "<h1 style=\"text-align: center;\">Welcome To Peaksoft</h1>";
    }

    @GetMapping("active/profile")
    public Map<String, String> showActiveProfile() {
        return Map.of(
                "SPRING_PROFILES_ACTIVE", activeProfile
        );
    }

    public String getActiveProfile() {
        return activeProfile;
    }

    public void setActiveProfile(String activeProfile) {
        this.activeProfile = activeProfile;
    }
}
