package ma.octo.assignement.domain;

import ma.octo.assignement.domain.util.EventType;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "AUDIT")
@Data
public class Audit {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY )
  private Long id;

  @Column(length = 100)
  private String message;

  @Enumerated(EnumType.STRING)
  private EventType eventType;

  
}
