package com.pers.gfc.chapter3.po;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户
 *
 * @author guofucheng
 * @date 2020/10/10
 */
@NoArgsConstructor
@Data
public class User {
    private Integer id;
    private String userName;
    private String cnName;
    private Enum sex;
    private String mobile;
    private String email;
    private String note;

    @Override
    public String toString() {
        return "--->" + id + "--->" + userName + "--->" + cnName + "--->" + sex +
                "--->" + mobile + "--->" + email + "--->" + note;
    }
}