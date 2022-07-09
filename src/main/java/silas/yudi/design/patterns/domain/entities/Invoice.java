package silas.yudi.design.patterns.domain.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Invoice {

    private String id;

    private Double taxValue;
}
