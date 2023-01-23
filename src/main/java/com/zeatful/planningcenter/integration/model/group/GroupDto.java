package com.zeatful.planningcenter.integration.model.group;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GroupDto {
  private List<Group> data;

  /**
   * All Planning Center Responses come with a Root node which also contains a Data node.  The Data node contains the list of group results we want to retrieve.
   * @param root
   */
  @SuppressWarnings("unchecked")
  @JsonProperty("root")
  private void unpackNested(Map<String,Object> root){
    this.data = (List<Group>) root.get("data");
  }
}
