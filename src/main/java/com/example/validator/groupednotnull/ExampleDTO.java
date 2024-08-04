package com.example.validator.groupednotnull;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@GroupedNotNullClass
public class ExampleDTO {

    @NotNullGroup(name="two")
    private String a;

    @NotNullGroup(name="two")
    private String b;

    @NotNullGroup(name="two")
    private String c;

    @NotNullGroup(name="one")
    private String d;

    @NotNullGroup(name="one")
    private String e;
}
