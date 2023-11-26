package com.example.devdossier.app.dtos;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Schema
@NoArgsConstructor
public class AppRequestDTO {
    @Min(value = 0, message = "Page number must be equal or greater than 0")
    private String page = "0";
    @Min(value = 1, message = "Size must be greater than 0")
    private String size = "10";
    @NotBlank(message = "Sort parameter must not be blank")
    private String sortParam = "createdAt";
    @Pattern(regexp = "ASC|DESC", message = "Direction must be 'ASC' or 'DESC'")
    private String direction = "ASC";
}
