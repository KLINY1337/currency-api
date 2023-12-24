package com.test.task.sputnik.currency.api.authentication.dto.response;

import com.test.task.sputnik.currency.api.authentication.entity.Token;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link Token}
 */
public record TokenResponse(UUID uuid) implements Serializable {
}