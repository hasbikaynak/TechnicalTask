package com.technicaltask.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SocialNetworkPostRequest {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "Please provide the post date")
    private Date postDate;

    @NotBlank(message = "Please provide an author")
    private String author;

    @NotBlank(message = "Please provide a content")
    private String content;

    @NotNull(message = "Please provide a viewCount")
    private Integer viewCount;
}
