package org.blubakery.common.core.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Structured per-field validation error detail.
 * Included in {@link ErrorResponse#fieldErrors} to give clients
 * the field name, the rejected value, and the constraint message.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValidationErrorDetail {

    /** The name of the field that failed validation. */
    private String field;

    /** The value that was rejected (may be null). */
    private Object rejectedValue;

    /** The human-readable constraint violation message. */
    private String message;
}
