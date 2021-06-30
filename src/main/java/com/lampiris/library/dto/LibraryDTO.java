package com.lampiris.library.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LibraryDTO {

    @NotEmpty
    private String labelLibrary;
}
