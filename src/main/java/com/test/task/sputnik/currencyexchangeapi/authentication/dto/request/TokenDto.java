package com.test.task.sputnik.currencyexchangeapi.authentication.dto.request;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link com.test.task.sputnik.currencyexchangeapi.authentication.entity.Token}
 */
public record TokenDto(UUID uuid) implements Serializable {
}