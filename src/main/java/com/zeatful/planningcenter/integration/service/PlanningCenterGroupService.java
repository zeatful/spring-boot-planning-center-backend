package com.zeatful.planningcenter.integration.service;

import com.zeatful.planningcenter.integration.model.group.Group;
import com.zeatful.planningcenter.integration.model.group.GroupDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Slf4j
@Service
public class PlanningCenterGroupService {
  private final String applicationId;
  private final String secret;
  private final WebClient webClient;

  public PlanningCenterGroupService(WebClient webClient,
      @Value("${planning.center.applicationId}") String applicationId,
      @Value("${planning.center.secret}") String secret
  ){
    this.webClient = webClient;
    this.applicationId = applicationId;
    this.secret = secret;
  }

  public Flux<Group> getGroups(){
    log.info("Getting Groups from Planning Center...");
    return webClient.get()
        .uri(uriBuilder -> uriBuilder
            .path("/groups/v2/groups")
            .build()
        )
        .headers(h -> h.setBasicAuth(applicationId, secret))
        .retrieve()
        .bodyToFlux(GroupDto.class)
        .flatMapIterable(GroupDto::getData);
  }
}
