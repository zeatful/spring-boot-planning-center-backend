package com.zeatful.planningcenter.integration.model.group;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Group {
  private String type;
  private String id;

  private GroupAttributes attributes;

  private GroupRelationship relationship;
}
