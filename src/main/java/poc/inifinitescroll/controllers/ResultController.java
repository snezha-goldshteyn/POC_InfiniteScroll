package poc.inifinitescroll.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import poc.inifinitescroll.entity.ResultEntity;
import poc.inifinitescroll.services.IResultService;

import java.util.List;

@RestController
@RequestMapping("/api/results")
public class ResultController {

    @Autowired
    IResultService service;

    @GetMapping(value = "/{page}")
    public List<ResultEntity> getResults (@PathVariable("page") int page) {
        List<ResultEntity> results = service.getResultsFromRepo(page);
        if (results.isEmpty()) return null;
        return results;
    }

}
