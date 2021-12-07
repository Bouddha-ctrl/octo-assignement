package ma.octo.assignement.domain;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "VERSEMENT")
public class Versement {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(precision = 16, scale = 2, nullable = false)
  private BigDecimal montantVersement;

  @Column
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateExecution;

  @Column
  private String nom_emetteur;
  
  @Column
  private String prenom_emetteur;

  @ManyToOne()
  private Compte compteBeneficiaire;

  @Column(length = 200)
  private String motifVersement;

  
}
