package org.rumos.blog.model.dtos.entities;

/**
 * A data transfer object (DTO) representing the response after successful user login.
 * <p>
 * This DTO contains the user and person IDs along with an authentication token.
 */
public record LoginResponseDTO(Long idUser, Long idPerson, String token) {

}
