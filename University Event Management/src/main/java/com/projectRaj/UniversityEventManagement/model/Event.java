package com.projectRaj.UniversityEventManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Valid
public class Event {
    @Id
    private Long eventId;

    @NotEmpty
    @Size(max = 100)
    private String eventName;

    @NotBlank
    @Size(max = 100)
    private String locationOfEvent;

    private LocalDate date;

    @Pattern(regexp = "\\d{2}:\\d{2}:\\d{2}", message = "Time must be in HH:mm:ss format")
    private String startTime;

    @Pattern(regexp = "\\d{2}:\\d{2}:\\d{2}", message = "Time must be in HH:mm:ss format")
    private String endTime;

}
