package com.ingryd_capstone_project.votingapplication.model;

import com.ingryd_capstone_project.votingapplication.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity
@AllArgsConstructor @NoArgsConstructor
@Data
public class Election {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @Enumerated(value = EnumType.STRING)
    private Status status = Status.UPCOMING;

}
