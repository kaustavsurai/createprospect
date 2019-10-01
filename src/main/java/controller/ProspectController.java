package controller;

import dbrepository.ProspectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pojo.Prospect;

import java.util.List;

@RestController
public class ProspectController {
@Autowired
    private ProspectRepository prospectRepository;

    @GetMapping("/Prospect")
    public List<Prospect> getProspect(){
    return  prospectRepository.findAll();
}

}
