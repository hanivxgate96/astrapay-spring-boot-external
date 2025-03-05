package com.astrapay.repository;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notes {

    private Long id;
    private String name;
    private String description;
    private LocalDateTime time;
}
