package org.rumos.blog.model.dtos.maps.interfaces;

/**
 * Interface defining methods to map between an entity, its DTO representations for showing,
 * adding, and updating.
 * 
 * @param <Entity>    The entity type to be mapped from/to.
 * @param <DTOToShow> The DTO type for showing the entity.
 * @param <DTOToAdd>  The DTO type for adding the entity.
 * @param <DTOToUpdate> The DTO type for updating the entity.
 */
public interface EntityMapDTO<Entity, DTOToShow, DTOToAdd, DTOToUpdate> {

    /**
     * Converts a DTOToAdd to an entity.
     * 
     * @param entityDTO The DTO containing data to be converted to an entity.
     * @return The entity created from the DTO.
     */
    public Entity convertToClass(DTOToAdd entityDTO);

    /**
     * Converts a DTOToUpdate to update an existing entity.
     * 
     * @param entityDTO The DTO containing updated data.
     * @param entity    The entity to be updated.
     * @return The updated entity after conversion.
     */
    public Entity convertToClass(DTOToUpdate entityDTO, Entity entity);

    /**
     * Converts an entity to a DTOToShow for presentation.
     * 
     * @param entity The entity to be converted to a DTO for showing.
     * @return The DTO containing data from the entity for presentation.
     */
    public DTOToShow convertToDTO(Entity entity);
}

