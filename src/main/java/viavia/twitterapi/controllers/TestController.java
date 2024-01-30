package viavia.twitterapi.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "test")
public class TestController {
    private ArrayList<String> members = new ArrayList<>(Arrays.asList(
            "phuocleoceo",
            "viavia2912"
    ));

    @GetMapping
    public ResponseEntity<List<String>> getMembers() {
        return ResponseEntity.ok(members);
    }

    @PostMapping
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<List<String>> createMember(
            @RequestParam(name = "name") String name
    ) {
        members.add(name);
        return ResponseEntity.ok(members);
    }
}
