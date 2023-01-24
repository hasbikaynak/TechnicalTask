package com.technicaltask.dto.response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SocialNetworkPostResponse {

    private Date postDate;

    private String author;

    private String content;

    private Integer viewCount;
}
