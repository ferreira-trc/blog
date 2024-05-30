package org.rumos.blog.model.dtos.maps.interfaces;

public interface EntityMapDTO<Entity, DTOToShow, DTOToAdd, DTOToUpdate> {

    public Entity convertToClass(DTOToAdd entityDTO);
    public Entity convertToClass(DTOToUpdate entityDTO, Entity entity);
    public DTOToShow convertToDTO(Entity entity);
}
