package org.linlinjava.litemall.db.task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DynamicNpcDialogRecordVO {
    private int mapId;

    private String mapName;

    private int npcId;

    private String npcName;

    private String checkType;

    private String checkPara;

    private List<DynamicNpcDialogOptionVO> options;
}
