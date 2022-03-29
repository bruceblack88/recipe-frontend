package com.example;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;

@RestController
public class ActivitiesController {

    //@Autowired ActivitiesService activitiesService;

    @PostMapping(value = "/activities/simplify", produces = "application/vnd.galvanize.detailed+json")
    @JsonView(Views.Detailed.class)
    public String getJSONActivitiesDetailed(@RequestBody Activities activities) {
        ActivitiesService activitiesService = new ActivitiesService();
        return activitiesService.getDetailedView(activities);
    }

    @PostMapping(value = "/activities/simplify", produces = "application/vnd.galvanize.compact+json")
    @JsonView(Views.Compact.class)
    public String getJSONActivitiesCompact(@RequestBody Activities activities) {
        ActivitiesService activitiesService = new ActivitiesService();
        return activitiesService.getCompactView(activities);
    }
}
