package ma.octo.assignement.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import ma.octo.assignement.service.imp.VersementServiceImp;


@ExtendWith(SpringExtension.class)
@SpringBootTest

public class  VersementRepositoryTest {

  @Autowired
  private VersementRepository versementRepository;

  @Test
  public void findOne() {
  }

  @Test
  public void findAll() {

  }

  @Test
  public void save() {
  }

  @Test
  public void delete() {
  }
}