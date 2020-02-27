package com.t0lia.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class GhLicense {
    private String key;
    private String name;
    private String spdx_id;
    private String url;
    private String node_id;
}
