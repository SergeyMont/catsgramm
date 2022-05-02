package ru.yandex.practicum.catsgram.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.Objects;

@Data
public class User {
    private int id;
    private String email;
    private String nickname;
    private LocalDate birthdate;
}