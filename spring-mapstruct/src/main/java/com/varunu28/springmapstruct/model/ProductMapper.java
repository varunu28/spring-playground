package com.varunu28.springmapstruct.model;

import com.varunu28.springmapstruct.dto.ProductResponse;
import java.util.Date;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "name", target = "productName")
    @Mapping(source = "description", target = "productDescription")
    @Mapping(source = "deletedAt", target = "isDeleted", qualifiedByName = "isDeleted")
    ProductResponse mapProductToProductResponse(Product product);

    /**
     * A named method to calculate isDeleted based on the deletedAt field. MapStruct uses this to call this method.
     * @param deletedAt Date object for deletedAt
     * @return true if deletedAt is not null, else false
     */
    @Named("isDeleted")
    static boolean isDeleted(Date deletedAt) {
        return deletedAt != null;
    }
}
