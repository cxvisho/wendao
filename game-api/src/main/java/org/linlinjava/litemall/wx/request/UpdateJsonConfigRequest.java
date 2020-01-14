package org.linlinjava.litemall.wx.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateJsonConfigRequest {
    private String repositoryName;

    private String jsonStr;
}
