package com.zeatful.planningcenter.integration.resource;

import com.zeatful.planningcenter.integration.model.group.Group;
import com.zeatful.planningcenter.integration.service.PlanningCenterGroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Slf4j
@RestController
@RequestMapping("/resource/group")
public class GroupController {

  private final PlanningCenterGroupService planningCenterGroupService;

  public GroupController(PlanningCenterGroupService planningCenterGroupService){
    this.planningCenterGroupService = planningCenterGroupService;
  }

  @GetMapping
  public Flux<Group> getGroups(){
    log.info("GET /resource/group called!");
    return this.planningCenterGroupService.getGroups();
  }

}
