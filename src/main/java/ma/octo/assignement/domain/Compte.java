package ma.octo.assignement.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "COMPTE")
@Data
public class Compte {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 16, unique = true)
  private String nrCompte;

  private String rib;

  @Column(precision = 16, scale = 2)
  private BigDecimal solde;

  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnore
  @JoinColumn(name = "utilisateur_id")
  private Utilisateur utilisateur;
  
  @Version
  @Column(name="OPTLOCK")
  private Long version;

  public void ajoutSolde(BigDecimal ajout) {
	  this.solde=this.solde.add(ajout);
  }
 
}
