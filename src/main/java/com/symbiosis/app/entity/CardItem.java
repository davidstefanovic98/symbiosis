package com.symbiosis.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="card_item")
@Getter
@Setter
@NoArgsConstructor
public class CardItem extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name="card_item_id")
    private Integer cardItemId;
    @Column(name="header")
    private String header;
    @Column(name="body")
    private String body;
    @Column(name="description")
    private String description;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "card_fk", nullable = false)
    private Card card;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CardItem cardItem = (CardItem) o;
        return cardItemId != null && Objects.equals(cardItemId, cardItem.cardItemId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
