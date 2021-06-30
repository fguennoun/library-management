package com.lampiris.library.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class BookFamilyDTO {

    @NotEmpty
    private String labelBookFamily;

    @NotEmpty
    private int idLibrary;
}
