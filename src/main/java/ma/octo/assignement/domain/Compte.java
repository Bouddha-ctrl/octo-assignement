package ma.octo.assignement.domain;

import javax.persistence.*;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "COMPTE")
@Data
public class Compte implements Serializable{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 16, unique = true)
  private String nrCompte;

  private String rib;

  @Column(precision = 16, scale = 2)
  private BigDecimal solde;

  @ManyToOne()
  @JoinColumn(name = "utilisateur_id")
  private Utilisateur utilisateur;

  public void ajoutSolde(BigDecimal ajout) {
	  this.solde=this.solde.add(ajout);
  }
 
}
