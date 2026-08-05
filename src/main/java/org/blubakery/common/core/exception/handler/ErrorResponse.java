package org.blubakery.common.core.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * Standard error response payload returned by all bakery services.
 *
 * <p>Contains both:
 * <ul>
 *   <li>{@link #validationErrors} — flat field→message map (backward compatible)</li>
 *   <li>{@link #fieldErrors} — structured per-field list with rejected values (new)</li>
 * </ul>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    /** Short error code, e.g. "VALIDATION_ERROR", "RESOURCE_NOT_FOUND". */
    private String code;

    /** Human-readable error message. */
    private String message;

    /** UTC timestamp of when the error occurred. */
    private LocalDateTime timestamp;

    /** Request URI path that triggered the error. */
    private String path;

    /**
     * Flat field → message map for validation errors.
     * Kept for backward compatibility with existing clients.
     */
    private Map<String, String> validationErrors;

    /**
     * Structured per-field validation errors including the rejected value.
     * Populated in addition to {@link #validationErrors} for richer client responses.
     */
    private List<ValidationErrorDetail> fieldErrors;

    /** Optional extra details (e.g. productId, requestedQuantity for stock errors). */
    private Map<String, Object> details;
}
