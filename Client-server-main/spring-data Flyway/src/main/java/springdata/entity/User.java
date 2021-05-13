package kz.reself.springdata.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "users")
@XmlRootElement(name = "user")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"address", "temp"})
@EqualsAndHashCode(of = {"id", "name", "age"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    @ColumnDefault("true")
    @ApiModelProperty(notes = "means that user is active")
    private Boolean enabled;

//    @OneToOne(mappedBy = "user")
//    private Address address;

    @Transient
    private String temp;
}
