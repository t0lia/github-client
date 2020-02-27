package com.t0lia.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
@ToString
public class Summary {
    GhUser user;
    GhUser[] followers;
    GhRepo[] repos;
}
