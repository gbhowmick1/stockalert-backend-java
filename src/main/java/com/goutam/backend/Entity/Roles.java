package com.goutam.backend.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Roles {

    @Id
    private Integer id;

    @Column(name="role_name")
    private String roleName;
}
