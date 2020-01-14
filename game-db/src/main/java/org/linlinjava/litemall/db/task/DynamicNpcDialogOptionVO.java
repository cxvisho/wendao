package org.linlinjava.litemall.db.task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DynamicNpcDialogOptionVO {
    private String content;

    private String command;
}
