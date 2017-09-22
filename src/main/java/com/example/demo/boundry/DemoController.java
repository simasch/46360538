package com.example.demo.boundry;

import com.example.demo.control.DemoRepository;
import com.example.demo.entity.Demo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final DemoRepository demoRepository;

    public DemoController(DemoRepository demoRepository) {
        this.demoRepository = demoRepository;
    }

    @RequestMapping(value = "/api/demos", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void add(Demo demo) {
        demoRepository.save(demo);
    }

    @RequestMapping(value = "/api/demos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Demo> get() {
        return demoRepository.findAll();
    }

    @RequestMapping(value = "/api/demos/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        demoRepository.delete(id);
    }
}
