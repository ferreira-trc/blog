package org.rumos.blog.model.dtos.maps.interfaces;

import org.rumos.blog.model.dtos.entities.post.PostDTOToAdd;
import org.rumos.blog.model.dtos.entities.post.PostDTOToShow;
import org.rumos.blog.model.dtos.entities.post.PostDTOToUpdate;
import org.rumos.blog.model.entities.Post;

public interface PostMapDTO extends EntityMapDTO<Post, PostDTOToShow, PostDTOToAdd, PostDTOToUpdate>{

}
