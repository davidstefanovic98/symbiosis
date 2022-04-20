package com.symbiosis.app.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="card")
@Getter
@Setter
@NoArgsConstructor
public class Card extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name="card_id")
    private Integer cardId;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @ManyToOne
    @JoinColumn(name="board_fk", referencedColumnName = "board_id")
    private Board board;
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<CardItem> cardItems;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Card card = (Card) o;
        return cardId != null && Objects.equals(cardId, card.cardId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
