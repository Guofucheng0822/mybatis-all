package com.pers.gfc.chapter1.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 角色
 *
 * @author guofucheng
 * @date 2020/09/30
 */
@Data
@NoArgsConstructor
public class Role {
    private Integer id;
    private String roleName;
    private String note;
}
