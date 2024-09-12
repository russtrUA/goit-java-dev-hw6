package ua.goit.service.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MaxProjectsClient {
    private String clientName;
    private Long countOfProjects;
}