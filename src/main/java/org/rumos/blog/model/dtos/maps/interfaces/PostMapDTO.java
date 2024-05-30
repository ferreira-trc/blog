package org.rumos.blog.model.dtos.maps.interfaces;

import org.rumos.blog.model.dtos.post.PostDTOToAdd;
import org.rumos.blog.model.dtos.post.PostDTOToShow;
import org.rumos.blog.model.dtos.post.PostDTOToUpdate;
import org.rumos.blog.model.entities.Post;

public interface PostMapDTO extends EntityMapDTO<Post, PostDTOToShow, PostDTOToAdd, PostDTOToUpdate>{

}
