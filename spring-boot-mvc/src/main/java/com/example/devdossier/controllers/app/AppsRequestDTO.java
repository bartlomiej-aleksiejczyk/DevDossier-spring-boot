package com.example.devdossier.controllers.app;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AppsRequestDTO {
    @Min(value = 0, message = "Page number must be equal or greater than 0")
    private String page = "0";
    @Min(value = 1, message = "Size must be greater than 0")
    private String size = "10";
    @NotBlank(message = "Sort parameter must not be blank")
    private String sortParam = "createdAt";
    @Pattern(regexp = "ASC|DESC", message = "Direction must be 'ASC' or 'DESC'")
    private String direction = "ASC";
}
