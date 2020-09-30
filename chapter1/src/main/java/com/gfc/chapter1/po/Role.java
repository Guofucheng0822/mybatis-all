package com.gfc.chapter1.po;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Role {
    private Long id;
    private String roleName;
    private String note;

    public Role(String roleName, String note) {
        this.roleName = roleName;
        this.note = note;
    }
}