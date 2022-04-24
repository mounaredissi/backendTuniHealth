package tn.enicarthage.TuniHealth.controller;

import tn.enicarthage.TuniHealth.entity.JwtRequest;
import tn.enicarthage.TuniHealth.entity.JwtResponse;
import tn.enicarthage.TuniHealth.service.JwtService;
import tn.enicarthage.TuniHealth.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtController {
    @Autowired
    private JwtUtil j;

    @Autowired
    private JwtService jwtService;

    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
    	JwtResponse r =jwtService.createJwtToken(jwtRequest);
    	System.out.println(r.getJwtToken());

        return r;
    }
}
