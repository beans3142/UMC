package umc.spring.web.dto.Store;

import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class CreateStoreDTO {
        private String name;
        private String address;
        private Long regionId;
    }
}